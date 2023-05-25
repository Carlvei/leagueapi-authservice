package at.adesso.leagueapi.authservice.domain.users.model;

import lombok.Data;

@Data
public class LoginData {
    private String email;
    private String password;
}
