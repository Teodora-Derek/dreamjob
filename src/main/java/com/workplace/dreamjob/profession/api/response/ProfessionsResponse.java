package com.workplace.dreamjob.profession.api.response;

import com.workplace.dreamjob.profession.service.response.ProfessionResponse;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class ProfessionsResponse {

    @NonNull
    List<ProfessionResponse> professions;
}
