package at.adesso.leagueapi.authservice.infrastructure.api.rest;

import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.TokenPairDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.CredentialsDto;
import org.springframework.http.ResponseEntity;

public interface AuthenticationApi {

    ResponseEntity<TokenPairDto> authenticate(final CredentialsDto credentialsDto);
}
