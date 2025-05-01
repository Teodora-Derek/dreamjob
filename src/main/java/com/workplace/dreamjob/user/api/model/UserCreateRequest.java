package com.workplace.dreamjob.user.api.model;

public record UserCreateRequest(String username, String password, String firstName,
                                String lastName) {
}
