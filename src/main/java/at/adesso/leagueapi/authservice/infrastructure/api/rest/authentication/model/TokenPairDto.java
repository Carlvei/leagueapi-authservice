package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model;

import lombok.Data;

@Data
public class TokenPairDto {
    private String accessToken;
    private String refreshToken;
}
