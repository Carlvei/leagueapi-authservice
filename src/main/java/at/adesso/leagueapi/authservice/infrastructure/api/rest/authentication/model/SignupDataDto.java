package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignupDataDto {

    private String username;

    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$", message = "Password must contain at least one uppercase character, one lowercase character, one number and must be at least 8 characters long.")
    private String password;

    @Pattern(regexp = "^[\\w]+@[\\w]+.[\\w]+$", message = "Invalid email.")
    private String email;
}
