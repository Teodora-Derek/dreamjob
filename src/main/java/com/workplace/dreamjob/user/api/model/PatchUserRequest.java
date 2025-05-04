package com.workplace.dreamjob.user.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.workplace.dreamjob.common.AccountStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PatchUserRequest(
        String passwordHash,
        String displayName,
        AccountStatus status) {

}
