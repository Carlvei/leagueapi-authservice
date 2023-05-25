package at.adesso.leagueapi.authservice.application;

import at.adesso.leagueapi.authservice.application.errors.AuthorizationError;
import at.adesso.leagueapi.authservice.domain.users.model.*;
import at.adesso.leagueapi.authservice.domain.users.repository.UserRepository;
import at.adesso.leagueapi.commons.domain.Role;
import at.adesso.leagueapi.commons.errorhandling.exceptions.UnauthorizedAccessException;
import at.adesso.leagueapi.commons.errorhandling.exceptions.ValidationFailedException;
import at.adesso.leagueapi.commons.util.jwt.JwtTokenGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final JwtTokenGenerator jwtTokenGenerator;

    private final PasswordEncoder passwordEncoder;

    private final String salt;

    public AuthenticationService(@Value("leagueapi.security.salt") final String salt,
                                 final UserRepository userRepository,
                                 final JwtTokenGenerator jwtTokenGenerator,
                                 final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.passwordEncoder = passwordEncoder;
        this.salt = salt;
    }

    public User authenticate(final LoginData enteredLoginData) {
        final UserData userData = userRepository.findUserByEmail(enteredLoginData.getEmail())
                .orElseThrow(() -> new UnauthorizedAccessException(AuthorizationError.CREDENTIALS_NOT_FOUND_ERROR));
        validatePassword(userData, enteredLoginData);
        return User.builder()
                .user(userData)
                .tokenPair(TokenPair.builder()
                        .accessToken(generateAccessToken(userData))
                        .refreshToken("refreshToken")
                        .build())
                .build();
    }

    public UserData signup(final SignUpData signUpData) {
        checkIfEmailAdressAlreadyExists(signUpData.getEmail());
        return userRepository.save(UserData.builder()
                .email(signUpData.getEmail())
                .username(signUpData.getUsername())
                .role(Role.USER)
                .encrpytedPassword(passwordEncoder.encode(signUpData.getPassword() + salt))
                .build());
    }


    private String generateAccessToken(final UserData userData) {
        return jwtTokenGenerator.generateToken(userData.getId(), userData.getRole());
    }

    private void checkIfEmailAdressAlreadyExists(final String email) {
        if (userRepository.findUserByEmail(email).isPresent()) {
            throw new ValidationFailedException("Email is already given.");
        }
    }

    private void validatePassword(final UserData userData, final LoginData enteredLoginData) {
        if (!passwordEncoder.matches(enteredLoginData.getPassword() + salt, userData.getEncrpytedPassword())) {
            throw new UnauthorizedAccessException(AuthorizationError.CREDENTIALS_NOT_FOUND_ERROR);
        }
    }
}
