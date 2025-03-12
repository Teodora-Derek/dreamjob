package com.workplace.dreamjob.dto.user;

public record UserResponseWithCredentials(UserResponse userResponse, String passwordHash) {
}
