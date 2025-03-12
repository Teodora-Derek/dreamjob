package com.workplace.dreamjob.dto.user;

public record UserPasswordUpdateRequest(String oldPassword, String newPassword) {
}
