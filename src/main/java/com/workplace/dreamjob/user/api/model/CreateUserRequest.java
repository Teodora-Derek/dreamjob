package com.workplace.dreamjob.user.api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CreateUserRequest(

        @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters") @Pattern(
                regexp = "^[a-zA-Z0-9_]+$",
                message = "Username can only contain letters, numbers, and underscores") @NotBlank(
                message = "Username is required")
        // Rules: not blank, length between 3–20, alphanumeric (sometimes underscores), unique (usually checked separately).
        @NotBlank String username,
        @NotBlank @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
        message = "Password must be at least 8 characters and include uppercase, lowercase, number, and special character")
        // Rules: length ≥ 8, must contain uppercase, lowercase, number, special character.
        String password,
        @NotBlank @Email String email,
        @NotBlank String displayName) {
}
