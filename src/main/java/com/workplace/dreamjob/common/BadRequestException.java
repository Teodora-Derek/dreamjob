package com.workplace.dreamjob.common;

import lombok.Getter;

import java.util.UUID;

import static com.workplace.dreamjob.common.ErrorCodes.FACTOR_ALREADY_IN_USE_UUID;

@Getter
public class BadRequestException extends RuntimeException {

    private static final String FACTOR_ALREADY_IN_USE_ERROR_MESSAGE =
            "Factor already in use [requesting userId=%s, occupying userId=%s]";

    private UUID errorCode;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(String message, UUID errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BadRequestException(String message, Throwable cause, UUID errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public static BadRequestException factorAlreadyInUse(String requestingUserId, String occupyingUserId) {
        return new BadRequestException(
                FACTOR_ALREADY_IN_USE_ERROR_MESSAGE.formatted(requestingUserId, occupyingUserId),
                FACTOR_ALREADY_IN_USE_UUID);
    }
}
