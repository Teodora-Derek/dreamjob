package com.workplace.dreamjob.user.service.response;

import com.workplace.dreamjob.user.service.response.UserResponse;

public record UserResponseWithCredentials(
        UserResponse userResponse,
        String passwordHash) {

}
