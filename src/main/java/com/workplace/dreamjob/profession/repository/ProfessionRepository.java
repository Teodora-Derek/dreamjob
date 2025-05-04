package com.workplace.dreamjob.profession.repository;

import com.workplace.dreamjob.common.ProfessionStatus;
import com.workplace.dreamjob.profession.model.Profession;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import static com.dreamjob.db.jooq.Tables.PROFESSION;

@Repository
@RequiredArgsConstructor
public class ProfessionRepository {

    private final DSLContext dslContext;
    private final Clock clock;

    public void create(Profession profession) {

        LocalDateTime now = LocalDateTime.now(clock);

        dslContext.insertInto(PROFESSION)
                .set(PROFESSION.PROFESSION_NAME, profession.name())
                .set(PROFESSION.DESCRIPTION, profession.description())
                .set(PROFESSION.STATUS, profession.status().name())
                .set(PROFESSION.UPDATED_ON, now)
                .set(PROFESSION.CREATED_ON, now)
                .execute();
    }

    public void patch(Profession profession) {

        dslContext.update(PROFESSION)
                .set(PROFESSION.DESCRIPTION, profession.description())
                .set(PROFESSION.STATUS, profession.status().name())
                .set(PROFESSION.UPDATED_ON, LocalDateTime.now(clock))
                .where(PROFESSION.ID.eq(profession.id()))
                .execute();
    }

    public Optional<Profession> findById(int id) {

        return dslContext.selectFrom(PROFESSION)
                .where(PROFESSION.ID.eq(id))
                .stream()
                .map(this::toProfession)
                .findFirst();
    }

    public Stream<Profession> findActiveProfessions() {

        return dslContext.selectFrom(PROFESSION)
                .where(PROFESSION.STATUS.eq(ProfessionStatus.ACTIVE.name()))
                .stream()
                .map(this::toProfession);
    }

    private Profession toProfession(Record record) {

        return Profession.builder()
                .id(record.get(PROFESSION.ID, Integer.class))
                .name(record.get(PROFESSION.PROFESSION_NAME))
                .description(record.get(PROFESSION.DESCRIPTION))
                .status(record.get(PROFESSION.STATUS, ProfessionStatus.class))
                .createdOn(record.get(PROFESSION.CREATED_ON, LocalDateTime.class))
                .updatedOn(record.get(PROFESSION.UPDATED_ON, LocalDateTime.class))
                .build();
    }
}
