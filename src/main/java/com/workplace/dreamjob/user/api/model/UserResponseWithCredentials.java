package com.workplace.dreamjob.user.api.model;

public record UserResponseWithCredentials(UserResponse userResponse, String passwordHash) {
}
