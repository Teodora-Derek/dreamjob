package com.workplace.dreamjob.user.api.model;

import com.workplace.dreamjob.common.AccountStatus;
import lombok.Builder;

public record PatchTraderRequest(
        int traderId,
        String mobileNumber,
        String description,
        AccountStatus status) {

}
