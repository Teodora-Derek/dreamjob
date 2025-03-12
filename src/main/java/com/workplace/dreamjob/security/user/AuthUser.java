package com.workplace.dreamjob.security.user;

import com.workplace.dreamjob.common.Role;

import java.util.List;

public record AuthUser(String userId, List<Role> roles) {
}
