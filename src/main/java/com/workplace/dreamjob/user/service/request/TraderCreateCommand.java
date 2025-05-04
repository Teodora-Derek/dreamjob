package com.workplace.dreamjob.user.service.request;

import com.workplace.dreamjob.user.api.request.CreateTraderRequest;
import lombok.Builder;

@Builder
public record TraderCreateCommand(
        int userId,
        String mobileNumber,
        String description) {

    public static TraderCreateCommand fromCreateTraderRequest(int userId, CreateTraderRequest request) {

        return TraderCreateCommand.builder()
                .userId(userId)
                .mobileNumber(request.mobileNumber())
                .description(request.description())
                .build();
    }
}
