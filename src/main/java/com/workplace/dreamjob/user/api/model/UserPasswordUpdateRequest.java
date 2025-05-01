package com.workplace.dreamjob.user.api.model;

public record UserPasswordUpdateRequest(String oldPassword, String newPassword) {
}
