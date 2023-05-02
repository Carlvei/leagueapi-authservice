package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model;

import lombok.Data;

@Data
public class CredentialsDto {
    private String userName;
    private String password;
}
