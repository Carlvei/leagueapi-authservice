package at.adesso.leagueapi.authservice.application;

import at.adesso.leagueapi.authservice.domain.users.model.Credentials;
import at.adesso.leagueapi.authservice.domain.users.model.TokenPair;
import at.adesso.leagueapi.authservice.domain.users.model.UserData;
import at.adesso.leagueapi.authservice.domain.users.repository.UserRepository;
import at.adesso.leagueapi.commons.domain.Role;
import at.adesso.leagueapi.commons.errorhandling.exceptions.UnauthorizedAccessException;
import at.adesso.leagueapi.commons.errorhandling.exceptions.ValidationFailedException;
import at.adesso.leagueapi.commons.util.jwt.JwtTokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final JwtTokenGenerator jwtTokenGenerator;

    private final PasswordEncoder passwordEncoder;

    public TokenPair authenticate(final Credentials enteredCredentials) {
        final UserData userData = userRepository.findUserByUserName(enteredCredentials.getUserName())
                .orElseThrow(() -> new UnauthorizedAccessException(getWrongCredentialsErrorMessage()));
        validatePassword(userData, enteredCredentials);
        return TokenPair.builder()
                .accessToken(generateAccessToken(userData))
                .refreshToken("refreshToken")
                .build();
    }

    public UserData signup(final Credentials credentials) {
        checkIfUserNameAlreadyExists(credentials.getUserName());
        return userRepository.save(UserData.builder()
                .userName(credentials.getUserName())
                .role(Role.USER)
                .encrpytedPassword(passwordEncoder.encode(credentials.getPassword()))
                .build());
    }


    private String generateAccessToken(final UserData userData) {
        return jwtTokenGenerator.generateToken(userData.getId(), userData.getRole());
    }

    private void checkIfUserNameAlreadyExists(final String username) {
        if (userRepository.findUserByUserName(username).isPresent()) {
            throw new ValidationFailedException("Username is already given.");
        }
    }

    private void validatePassword(final UserData userData, final Credentials enteredCredentials) {
        if (!userData.getEncrpytedPassword().equals(passwordEncoder.encode(enteredCredentials.getPassword()))) {
            throw new UnauthorizedAccessException(getWrongCredentialsErrorMessage());
        }
    }

    private String getWrongCredentialsErrorMessage() {
        return "Couldn't find match for the entered credentials.";
    }
}
