package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication;

import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.CredentialsDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.TokenPairDto;
import org.springframework.http.ResponseEntity;

public interface AuthenticationApi {

    ResponseEntity<TokenPairDto> authenticate(final CredentialsDto credentialsDto);
}
