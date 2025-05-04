package com.workplace.dreamjob.user.api;

import com.workplace.dreamjob.security.dto.LoginDto;
import com.workplace.dreamjob.security.dto.TokenDto;
import com.workplace.dreamjob.user.api.request.CreateUserRequest;
import com.workplace.dreamjob.user.service.AuthService;
import com.workplace.dreamjob.user.service.UserService;
import com.workplace.dreamjob.user.service.request.UserCreateCommand;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
@SecurityRequirement(name = "")
public class AuthenticationController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping(path = {"/register"})
    public ResponseEntity<Void> registerUser(@Valid @RequestBody CreateUserRequest createUserRequest) {

        UserCreateCommand command = UserCreateCommand.fromCreateUserRequest(createUserRequest);
        userService.createUser(command);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginDto loginDto) {

        return authService.login(loginDto);
    }
}
