package at.adesso.leagueapi.authservice.infrastructure.config.security;

import at.adesso.leagueapi.commons.errorhandling.exceptions.TechnicalException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity httpSecurity) {
        try {
            httpSecurity.cors().disable()
                    .csrf().disable()
                    .authorizeHttpRequests((requests) -> requests
                            .requestMatchers("/**").permitAll()
                            .anyRequest().authenticated());

            return httpSecurity.build();
        } catch (final Exception exception) {
            throw new TechnicalException(exception);
        }
    }
}
