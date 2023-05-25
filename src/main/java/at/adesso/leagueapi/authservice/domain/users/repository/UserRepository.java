package at.adesso.leagueapi.authservice.domain.users.repository;

import at.adesso.leagueapi.authservice.domain.users.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
    Optional<UserData> findUserByEmail(final String email);
}
