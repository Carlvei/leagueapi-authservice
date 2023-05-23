package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication;

import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.LoginDataDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.SignupDataDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.TokenPairDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface AuthenticationApi {

    ResponseEntity<TokenPairDto> authenticate(@Valid LoginDataDto loginDataDto);


    ResponseEntity<UserDto> signup(@Valid SignupDataDto signupDataDto);
}
