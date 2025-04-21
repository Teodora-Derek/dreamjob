package com.workplace.dreamjob.user.repository;

import com.workplace.dreamjob.user.model.UserDetails;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Optional;

import static com.dreamjob.db.jooq.tables.UserDetails.USER_DETAILS;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private DSLContext dslContext;
    private Clock clock;

    public void createUser(UserDetails userDetails) {

        LocalDateTime now = LocalDateTime.now(clock);

        dslContext
                .insertInto(USER_DETAILS)
                .set(USER_DETAILS.USERNAME, userDetails.username())
                .set(USER_DETAILS.PASSWORD, userDetails.password())
                .set(USER_DETAILS.EMAIL, userDetails.email())
                .set(USER_DETAILS.DISPLAY_NAME, userDetails.displayName())
                .set(USER_DETAILS.STATUS, userDetails.status().name())
                .set(USER_DETAILS.CREATED_ON, now)
                .set(USER_DETAILS.UPDATED_ON, now)
                .execute();
    }

    public Optional<UserDetails> getByEmail(String email) {

        return dslContext.selectFrom(USER_DETAILS)
                .where(USER_DETAILS.EMAIL.eq(email))
                .fetchOptionalInto(UserDetails.class);
    }
}
