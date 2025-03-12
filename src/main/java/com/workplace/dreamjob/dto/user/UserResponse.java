package com.workplace.dreamjob.dto.user;

import com.workplace.dreamjob.common.Role;

import java.util.List;

public record UserResponse(String id, String username, String firstName, String lastName,
                           List<Role> roles, Boolean active) {
}
