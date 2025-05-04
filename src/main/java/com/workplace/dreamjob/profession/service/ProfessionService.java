package com.workplace.dreamjob.profession.service;

import com.workplace.dreamjob.profession.service.response.ProfessionResponse;
import com.workplace.dreamjob.profession.model.Profession;
import com.workplace.dreamjob.profession.repository.ProfessionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessionService {

    private final ProfessionRepository professionRepository;

    public List<ProfessionResponse> getProfessions() {

        return professionRepository.findActiveProfessions()
                .map(this::toProfessionDto)
                .toList();
    }

    private ProfessionResponse toProfessionDto(Profession profession) {

        return ProfessionResponse.builder()
                .name(profession.name())
                .description(profession.description())
                .build();
    }
}
