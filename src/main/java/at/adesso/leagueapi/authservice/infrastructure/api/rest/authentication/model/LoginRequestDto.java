package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginRequestDto {
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}
