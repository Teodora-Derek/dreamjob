package com.workplace.dreamjob.user.api;

import com.workplace.dreamjob.security.dto.LoginDto;
import com.workplace.dreamjob.security.dto.TokenDto;
import com.workplace.dreamjob.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
public class AuthenticationController {

    private final AuthService authService;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginDto loginDto) {

        return authService.login(loginDto);
    }
}
