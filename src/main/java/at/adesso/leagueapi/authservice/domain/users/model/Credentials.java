package at.adesso.leagueapi.authservice.domain.users.model;

import lombok.Data;

@Data
public class Credentials {
    private String userName;
    private String password;
}
