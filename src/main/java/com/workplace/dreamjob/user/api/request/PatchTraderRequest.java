package com.workplace.dreamjob.user.api.request;

import com.workplace.dreamjob.common.AccountStatus;

public record PatchTraderRequest(
        int traderId,
        String mobileNumber,
        String description,
        AccountStatus status) {

}
