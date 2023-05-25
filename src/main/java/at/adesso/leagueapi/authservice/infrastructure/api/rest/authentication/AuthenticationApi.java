package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication;

import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.LoginRequestDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.SignupRequestDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.SignupResponseDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface AuthenticationApi {

    ResponseEntity<UserDto> authenticate(@Valid LoginRequestDto loginRequestDto);


    ResponseEntity<SignupResponseDto> signup(@Valid SignupRequestDto signupRequestDto);
}
