package com.workplace.dreamjob.user.service.model;

import com.workplace.dreamjob.user.api.model.CreateTraderRequest;
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
