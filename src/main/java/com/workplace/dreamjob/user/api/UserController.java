package com.workplace.dreamjob.user.api;

import com.workplace.dreamjob.user.api.model.CreateUserRequest;
import com.workplace.dreamjob.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/users"})
public class UserController {

    private final UserService userService;

    @PostMapping(path = {"customer/register"})
    public ResponseEntity<Void> registerUser(
            @Valid @RequestBody CreateUserRequest createUserRequest) {
        // persist the user
        userService.createUser(createUserRequest);
        return ResponseEntity.ok().build();
    }

    // TODO: This endpoint should be authenticated
    @PostMapping(path = {"traider/register"})
    public void registerTraider() {

    }
}
