package com.workplace.dreamjob.user.repository;

import com.dreamjob.db.jooq.tables.records.TraderDetailsRecord;
import com.workplace.dreamjob.common.AccountStatus;
import com.workplace.dreamjob.user.model.TraderDetails;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.dreamjob.db.jooq.Tables.TRADER_DETAILS;
import static com.dreamjob.db.jooq.tables.UserDetails.USER_DETAILS;

@Repository
@RequiredArgsConstructor
public class TraderRepository {

    private final DSLContext dslContext;
    private final Clock clock;

    public void create(TraderDetails traderDetails) {

        LocalDateTime now = LocalDateTime.now(clock);

        dslContext.insertInto(TRADER_DETAILS)
                .set(TRADER_DETAILS.USER_ID, traderDetails.userId())
                .set(TRADER_DETAILS.MOBILE_NUMBER, traderDetails.mobileNumber())
                .set(TRADER_DETAILS.DESCRIPTION, traderDetails.description())
                .set(TRADER_DETAILS.STATUS, traderDetails.status().name())
                .set(TRADER_DETAILS.CREATED_ON, now)
                .set(TRADER_DETAILS.UPDATED_ON, now)
                .execute();
    }

    public void patch(TraderDetails traderDetails) {

        dslContext.update(TRADER_DETAILS)
                .set(TRADER_DETAILS.MOBILE_NUMBER, traderDetails.mobileNumber())
                .set(TRADER_DETAILS.DESCRIPTION, traderDetails.description())
                .set(TRADER_DETAILS.STATUS, traderDetails.status().name())
                .set(TRADER_DETAILS.UPDATED_ON, LocalDateTime.now(clock))
                .where(TRADER_DETAILS.ID.eq(traderDetails.id()))
                .execute();
    }

    public Optional<TraderDetails> findById(int id) {

        return dslContext.selectFrom(TRADER_DETAILS)
                .where(TRADER_DETAILS.ID.eq(id))
                .stream()
                .map(this::toTraderDetails)
                .findFirst();
    }

    public Optional<TraderDetails> findByUserId(int userId) {

        return dslContext.selectFrom(TRADER_DETAILS)
                .where(TRADER_DETAILS.USER_ID.eq(userId))
                .stream()
                .map(this::toTraderDetails)
                .findFirst();
    }


    private TraderDetails toTraderDetails(TraderDetailsRecord record) {

        return TraderDetails.builder()
                .id(record.get(TRADER_DETAILS.ID, Integer.class))
                .userId(record.get(TRADER_DETAILS.USER_ID, Integer.class))
                .mobileNumber(record.get(TRADER_DETAILS.MOBILE_NUMBER, String.class))
                .description(record.get(TRADER_DETAILS.DESCRIPTION, String.class))
                .status(record.get(TRADER_DETAILS.STATUS, AccountStatus.class))
                .createdOn(record.get(USER_DETAILS.CREATED_ON, LocalDateTime.class))
                .updatedOn(record.get(USER_DETAILS.UPDATED_ON, LocalDateTime.class))
                .build();
    }
}
