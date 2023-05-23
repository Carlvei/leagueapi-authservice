package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.mapper;

import at.adesso.leagueapi.authservice.domain.users.model.LoginData;
import at.adesso.leagueapi.authservice.domain.users.model.SignUpData;
import at.adesso.leagueapi.authservice.domain.users.model.TokenPair;
import at.adesso.leagueapi.authservice.domain.users.model.UserData;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.LoginDataDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.SignupDataDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.TokenPairDto;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.UserDto;
import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = DefaultMapperConfig.class)
public interface AuthenticationMapper {
    LoginData toLoginData(LoginDataDto loginDataDto);

    SignUpData toSignUpData(SignupDataDto signupDataDto);

    TokenPairDto toTokenPairDto(TokenPair tokenPair);

    UserDto toUserDto(UserData userData);
}
