package com.workplace.dreamjob.user.service.model;

import com.workplace.dreamjob.common.AccountStatus;
import java.util.Optional;
import lombok.Builder;

@Builder
public record UserPatchCommand(
        int userId,
        String displayName,
        String email,
        String password,
        AccountStatus status) {

}
