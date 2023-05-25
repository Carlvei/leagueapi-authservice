package at.adesso.leagueapi.authservice.domain.users.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private UserData user;
    private TokenPair tokenPair;
}
