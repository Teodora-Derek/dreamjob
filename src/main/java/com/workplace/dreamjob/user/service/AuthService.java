package com.workplace.dreamjob.user.service;


import com.workplace.dreamjob.security.dto.LoginDto;
import com.workplace.dreamjob.security.dto.TokenDto;
import com.workplace.dreamjob.security.exception.ApplicationAuthenticationException;
import com.workplace.dreamjob.security.service.jwt.JwtService;
import com.workplace.dreamjob.security.user.AuthUser;
import com.workplace.dreamjob.user.api.model.UserResponse;
import com.workplace.dreamjob.user.api.model.UserResponseWithCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public TokenDto login(LoginDto loginDto) {

        UserResponseWithCredentials userCredentials =
                userService.getUserCredentialsByUsername(loginDto.username());

        if (!passwordEncoder.matches(loginDto.password(), userCredentials.passwordHash())) {
            throw new ApplicationAuthenticationException("Password is incorrect");
        }

        UserResponse userResponse = userCredentials.userResponse();
        AuthUser authUser =
                new AuthUser(Integer.toString(userResponse.userId()), userResponse.role());

        String jwtToken = jwtService.createJwtToken(authUser);

        return new TokenDto(jwtToken);
    }
}
