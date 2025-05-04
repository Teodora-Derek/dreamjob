package com.workplace.dreamjob.profession.api;

import com.workplace.dreamjob.profession.api.response.ProfessionsResponse;
import com.workplace.dreamjob.profession.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfessionController {

    private final ProfessionService professionService;

    @GetMapping("/professions")
    public ProfessionsResponse getProfessions() {

        return ProfessionsResponse.builder()
                .professions(professionService.getProfessions())
                .build();
    }
}
