package at.adesso.leagueapi.authservice.application.errors;

import at.adesso.leagueapi.commons.errorhandling.error.Error;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum AuthorizationError implements Error {

    CREDENTIALS_NOT_FOUND_ERROR("ERR-AUTH-003", "Couldn't find match for the given credentials.", HttpStatus.UNAUTHORIZED, true);
    private final String code;
    private final String message;
    private final HttpStatus defaultHttpStatus;
    private final boolean logged;

    AuthorizationError(final String code, final String message, final HttpStatus defaultHttpStatus, final boolean logged) {
        this.code = code;
        this.message = message;
        this.defaultHttpStatus = defaultHttpStatus;
        this.logged = logged;
    }
}
