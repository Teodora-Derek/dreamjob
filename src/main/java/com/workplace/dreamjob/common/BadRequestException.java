package com.workplace.dreamjob.common;

import java.util.UUID;
import lombok.Getter;

import static com.workplace.dreamjob.common.ErrorCodes.FACTOR_ALREADY_IN_USE_UUID;
import static com.workplace.dreamjob.common.ErrorCodes.USER_ID_NOT_EXISTS_UUID;

@Getter
public class BadRequestException extends RuntimeException {

    private static final String FACTOR_ALREADY_IN_USE_ERROR_MESSAGE =
            "Factor already in use [requesting userId=%s, occupying userId=%s]";
    private static final String USER_ID_NOT_EXISTS_ERROR_MESSAGE =
            "User id not found [userId=%s]";
    private static final String USER_ID_ALREADY_EXISTS_ERROR_MESSAGE =
            "User id already exists [userId=%s]";

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

    public static BadRequestException userAlreadyExists(String userId) {

        return new BadRequestException(
                USER_ID_ALREADY_EXISTS_ERROR_MESSAGE.formatted(userId),
                FACTOR_ALREADY_IN_USE_UUID);
    }

    public static BadRequestException userIdNotFound(String userId) {

        return new BadRequestException(
                USER_ID_NOT_EXISTS_ERROR_MESSAGE.formatted(userId),
                USER_ID_NOT_EXISTS_UUID);
    }
}
