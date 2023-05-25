package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication;

import at.adesso.leagueapi.authservice.application.AuthenticationService;
import at.adesso.leagueapi.authservice.domain.users.model.User;
import at.adesso.leagueapi.authservice.domain.users.model.UserData;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.mapper.AuthenticationMapper;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.LoginRequestDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.SignupRequestDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.SignupResponseDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@Validated
public class AuthenticationController implements AuthenticationApi {

    private final AuthenticationService authenticationService;

    private final AuthenticationMapper authenticationMapper;

    public AuthenticationController(final AuthenticationService authenticationService, final AuthenticationMapper authenticationMapper) {
        this.authenticationService = authenticationService;
        this.authenticationMapper = authenticationMapper;
    }

    @PostMapping("/authenticate")
    @Override
    public ResponseEntity<UserDto> authenticate(@RequestBody final LoginRequestDto loginRequestDto) {
        final User user = authenticationService.authenticate(authenticationMapper.toLoginData(loginRequestDto));
        return ResponseEntity
                .ok()
                .body(authenticationMapper.toUserDto(user));
    }

    @PostMapping("/signup")
    @Override
    public ResponseEntity<SignupResponseDto> signup(@RequestBody final SignupRequestDto signupRequestDto) {
        final UserData userData = authenticationService.signup(authenticationMapper.toSignUpData(signupRequestDto));
        return ResponseEntity
                .ok()
                .body(authenticationMapper.toSignUpResponseDto(userData));
    }
}
