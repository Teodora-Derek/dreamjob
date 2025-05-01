package com.workplace.dreamjob.user.api.model;

import com.workplace.dreamjob.common.Role;
import com.workplace.dreamjob.user.model.AccountStatus;
import lombok.Builder;

@Builder
public record UserResponse(int userId, String username, String email, String displayName,
                           Role role, AccountStatus status) {
}
