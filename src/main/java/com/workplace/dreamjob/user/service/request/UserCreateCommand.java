package com.workplace.dreamjob.user.service.request;

import com.workplace.dreamjob.user.api.request.CreateUserRequest;
import lombok.Builder;

@Builder
public record UserCreateCommand(
        String username,
        String password,
        String email,
        String displayName) {

    public static UserCreateCommand fromCreateUserRequest(CreateUserRequest createUserRequest) {

        return UserCreateCommand.builder()
                .username(createUserRequest.username())
                .password(createUserRequest.password())
                .email(createUserRequest.email())
                .displayName(createUserRequest.displayName())
                .build();
    }
}
