package com.workplace.dreamjob.profession.model;

import com.workplace.dreamjob.common.ProfessionStatus;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record Profession(
        int id,
        String name,
        String description,
        ProfessionStatus status,
        LocalDateTime createdOn,
        LocalDateTime updatedOn) {

}
