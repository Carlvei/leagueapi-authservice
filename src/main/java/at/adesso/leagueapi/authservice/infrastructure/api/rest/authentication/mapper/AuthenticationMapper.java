package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.mapper;

import at.adesso.leagueapi.authservice.domain.users.model.Credentials;
import at.adesso.leagueapi.authservice.domain.users.model.TokenPair;
import at.adesso.leagueapi.authservice.domain.users.model.UserData;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.UserDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.CredentialsDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.TokenPairDto;
import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

@Mapper(config = DefaultMapperConfig.class)
public interface AuthenticationMapper {
    Credentials toCredentials(CredentialsDto credentialsDto);

    TokenPairDto toTokenPairDto(TokenPair tokenPair);

    UserDto toUserDto(UserData userData);
}
