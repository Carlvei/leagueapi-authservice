package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication;

import at.adesso.leagueapi.authservice.application.AuthenticationService;
import at.adesso.leagueapi.authservice.domain.users.model.TokenPair;
import at.adesso.leagueapi.authservice.domain.users.model.UserData;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.mapper.AuthenticationMapper;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.CredentialsDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.TokenPairDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController implements AuthenticationApi {

    private final AuthenticationService authenticationService;

    private final AuthenticationMapper authenticationMapper;

    public AuthenticationController(AuthenticationService authenticationService, AuthenticationMapper authenticationMapper) {
        this.authenticationService = authenticationService;
        this.authenticationMapper = authenticationMapper;
    }

    @PostMapping("/authenticate")
    @Override
    public ResponseEntity<TokenPairDto> authenticate(@RequestBody final CredentialsDto credentialsDto) {
        final TokenPair tokenPair = authenticationService.authenticate(authenticationMapper.toCredentials(credentialsDto));
        return ResponseEntity
                .ok()
                .body(authenticationMapper.toTokenPairDto(tokenPair));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody final CredentialsDto credentialsDto) {
        final UserData userData = authenticationService.signup(authenticationMapper.toCredentials(credentialsDto));
        return ResponseEntity
                .ok()
                .body(authenticationMapper.toUserDto(userData));
    }
}
