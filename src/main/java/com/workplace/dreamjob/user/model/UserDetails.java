package com.workplace.dreamjob.user.model;

import com.workplace.dreamjob.common.Role;
import lombok.Builder;

@Builder
public record UserDetails(int userId, String username, String passwordHash, String email,
                          String displayName, Role role, AccountStatus status) {
}
