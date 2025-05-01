package com.workplace.dreamjob.user.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateUserRequest(
        @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters") @Pattern(
                regexp = "^[a-zA-Z0-9_]+$",
                message = "Username can only contain letters, numbers, and underscores") @NotBlank(
                message = "Username is required")
        // Rules: not blank, length between 3–20, alphanumeric (sometimes underscores), unique (usually checked separately).
        @NotBlank String username, @NotBlank String displayName) {
}
