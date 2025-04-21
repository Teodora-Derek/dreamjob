package com.workplace.dreamjob.user.service;

import com.workplace.dreamjob.common.BadRequestException;
import com.workplace.dreamjob.user.api.model.CreateUserRequest;
import com.workplace.dreamjob.user.model.AccountStatus;
import com.workplace.dreamjob.user.model.UserDetails;
import com.workplace.dreamjob.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(CreateUserRequest createUserRequest) {

        throwIfNotValidRequest(createUserRequest);

        UserDetails userDetails =
                new UserDetails(null, createUserRequest.username(), createUserRequest.password(),
                        createUserRequest.email(), createUserRequest.displayName(),
                        AccountStatus.Active);

        userRepository.createUser(userDetails);
    }

    private void throwIfNotValidRequest(CreateUserRequest createUserRequest)
            throws BadRequestException {

        throwIfUsernameIsInvalid(createUserRequest);
        throwIfEmailIsAlreadyUsed(createUserRequest);
    }

    private void throwIfUsernameIsInvalid(CreateUserRequest createUserRequest) {

        if (!StringUtils.isAsciiPrintable(createUserRequest.username())) {
            throw new BadRequestException("Username is not in ASCII format!");
        }
    }

    private void throwIfEmailIsAlreadyUsed(CreateUserRequest createUserRequest) {

        userRepository.getByEmail(createUserRequest.email()).ifPresent(user -> {
            throw BadRequestException.factorAlreadyInUse("", user.userId());
        });
    }
}
