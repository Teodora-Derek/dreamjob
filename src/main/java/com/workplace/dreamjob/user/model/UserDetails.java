package com.workplace.dreamjob.user.model;

public record UserDetails(String userId, String username, String password, String email,
                          String displayName, AccountStatus status) {
}
