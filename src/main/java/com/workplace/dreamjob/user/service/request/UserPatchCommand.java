package com.workplace.dreamjob.user.service.request;

import com.workplace.dreamjob.common.AccountStatus;
import lombok.Builder;

@Builder
public record UserPatchCommand(
        int userId,
        String displayName,
        String email,
        String password,
        AccountStatus status) {

}
