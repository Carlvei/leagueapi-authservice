package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String email;
    private TokenPairDto tokenPair;
}
