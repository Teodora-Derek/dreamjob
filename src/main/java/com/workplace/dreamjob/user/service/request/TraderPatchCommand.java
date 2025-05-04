package com.workplace.dreamjob.user.service.request;

import com.workplace.dreamjob.common.AccountStatus;
import com.workplace.dreamjob.user.api.request.PatchTraderRequest;
import lombok.Builder;

@Builder
public record TraderPatchCommand(
        int traderId,
        String mobileNumber,
        String description,
        AccountStatus status) {

    public static TraderPatchCommand fromPatchTraderRequest(PatchTraderRequest request) {

        return TraderPatchCommand.builder()
                .traderId(request.traderId())
                .mobileNumber(request.mobileNumber())
                .description(request.description())
                .status(request.status())
                .build();
    }
}
