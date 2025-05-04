package com.workplace.dreamjob.user.service.response;

import com.workplace.dreamjob.common.AccountStatus;
import com.workplace.dreamjob.common.Role;
import lombok.Builder;

@Builder
public record UserResponse(
        int userId,
        String username,
        String email,
        String displayName,
        Role role,
        AccountStatus status) {

}
