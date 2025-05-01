package com.workplace.dreamjob.user.repository;

import com.workplace.dreamjob.common.Role;
import com.workplace.dreamjob.user.model.AccountStatus;
import com.workplace.dreamjob.user.model.UserDetails;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import static com.dreamjob.db.jooq.tables.UserDetails.USER_DETAILS;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final DSLContext dslContext;
    private final Clock clock;

    public void persistUser(UserDetails userDetails) {

        LocalDateTime now = LocalDateTime.now(clock);

        dslContext.insertInto(USER_DETAILS)
                .set(USER_DETAILS.USERNAME, userDetails.username())
                .set(USER_DETAILS.PASSWORD_HASH, userDetails.passwordHash())
                .set(USER_DETAILS.EMAIL, userDetails.email())
                .set(USER_DETAILS.DISPLAY_NAME, userDetails.displayName())
                .set(USER_DETAILS.STATUS, userDetails.status().name())
                .set(USER_DETAILS.CREATED_ON, now)
                .set(USER_DETAILS.UPDATED_ON, now)
                .execute();
    }

    public Optional<UserDetails> findByEmail(String email) {

        return dslContext.selectFrom(USER_DETAILS)
                .where(USER_DETAILS.EMAIL.eq(email))
                .stream()
                .map(this::toUserDetails)
                .findFirst();
    }

    public Optional<UserDetails> findByUsername(String username) {

        return dslContext.selectFrom(USER_DETAILS)
                .where(USER_DETAILS.USERNAME.eq(username))
                .stream()
                .map(this::toUserDetails)
                .findFirst();
    }

    public Optional<UserDetails> findByUserId(int userId) {

        return dslContext.selectFrom(USER_DETAILS)
                .where(USER_DETAILS.ID.eq(userId))
                .stream()
                .map(this::toUserDetails)
                .findFirst();
    }

    private UserDetails toUserDetails(Record record) {

        return new UserDetails(
                record.get(USER_DETAILS.ID, Integer.class),
                record.get(USER_DETAILS.USERNAME),
                record.get(USER_DETAILS.PASSWORD_HASH, String.class),
                record.get(USER_DETAILS.EMAIL),
                record.get(USER_DETAILS.DISPLAY_NAME),
                Role.ROLE_USER,
                record.get(USER_DETAILS.STATUS, AccountStatus.class));
    }
}
