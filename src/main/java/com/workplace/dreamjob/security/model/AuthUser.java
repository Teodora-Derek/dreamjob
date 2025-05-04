package com.workplace.dreamjob.security.model;

import com.workplace.dreamjob.common.exception.BadRequestException;
import com.workplace.dreamjob.common.Role;
import org.apache.commons.lang3.StringUtils;

public record AuthUser(String userId, Role role) {

    public boolean isUserIdNumeric() {
        return StringUtils.isNumeric(userId);
    }

    public int getNumericUserId() {

        if (!isUserIdNumeric()) {
            throw new BadRequestException("UserId is not numeric!");
        }

        try {
            return Integer.parseInt(userId);
        } catch (Exception exception) {
            throw new BadRequestException("UserId is not numeric!");
        }
    }
}
