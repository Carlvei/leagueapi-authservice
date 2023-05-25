package at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.mapper;

import at.adesso.leagueapi.authservice.domain.users.model.*;
import at.adesso.leagueapi.authservice.infrastructure.api.rest.authentication.model.*;
import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = DefaultMapperConfig.class)
public interface AuthenticationMapper {
    LoginData toLoginData(LoginRequestDto loginRequestDto);

    SignUpData toSignUpData(SignupRequestDto signupRequestDto);

    SignupResponseDto toSignUpResponseDto(UserData userData);

    TokenPairDto toTokenPairDto(TokenPair tokenPair);

    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "email", source = "user.email")
    UserDto toUserDto(User user);
}
