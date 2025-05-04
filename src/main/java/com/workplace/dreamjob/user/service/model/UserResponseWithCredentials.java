package com.workplace.dreamjob.user.service.model;

public record UserResponseWithCredentials(
        UserResponse userResponse,
        String passwordHash) {

}
