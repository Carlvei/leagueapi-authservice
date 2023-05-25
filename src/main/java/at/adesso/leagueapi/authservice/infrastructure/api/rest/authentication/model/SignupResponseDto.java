package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model;

import lombok.Data;

@Data
public class SignupResponseDto {
    private String username;
    private String email;
}
