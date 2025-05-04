package com.workplace.dreamjob.user.model;

import com.workplace.dreamjob.common.AccountStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Builder;


@Builder
public record TraderDetails(
        Integer id,
        @NotNull Integer userId,
        @NotBlank String mobileNumber,
        String description,
        AccountStatus status,
        LocalDateTime createdOn,
        LocalDateTime updatedOn,
        UserDetails userDetails) {

}
