package at.adesso.leagueapi.authservice.domain.users.model;

import lombok.Data;

@Data
public class SignUpData {
    private String email;
    private String username;
    private String password;
}
