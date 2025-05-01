package com.workplace.dreamjob.user.service;

import com.workplace.dreamjob.common.BadRequestException;
import com.workplace.dreamjob.common.NotFoundException;
import com.workplace.dreamjob.common.Role;
import com.workplace.dreamjob.security.exception.ApplicationAuthenticationException;
import com.workplace.dreamjob.security.user.AuthUser;
import com.workplace.dreamjob.user.api.model.CreateUserRequest;
import com.workplace.dreamjob.user.api.model.UpdateUserRequest;
import com.workplace.dreamjob.user.api.model.UserPasswordUpdateRequest;
import com.workplace.dreamjob.user.api.model.UserResponse;
import com.workplace.dreamjob.user.api.model.UserResponseWithCredentials;
import com.workplace.dreamjob.user.model.AccountStatus;
import com.workplace.dreamjob.user.model.UserDetails;
import com.workplace.dreamjob.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(CreateUserRequest createUserRequest) {

        throwIfNotValidRequest(createUserRequest);
        String passwordHash = passwordEncoder.encode(createUserRequest.password());

        UserDetails userDetails = UserDetails.builder()
                .username(createUserRequest.username())
                .passwordHash(passwordHash)
                .email(createUserRequest.email())
                .displayName(createUserRequest.displayName())
                .role(Role.ROLE_USER)
                .status(AccountStatus.Active)
                .build();

        userRepository.persistUser(userDetails);
    }

    public void updateUser(UpdateUserRequest updateUserRequest, AuthUser authUser) {

        int userId = authUser.getNumericUserId();
        UserDetails userDetails = getUserDetails(userId);

        UserDetails updatedUserDetails = UserDetails.builder()
                .username(updateUserRequest.username())
                .passwordHash(userDetails.passwordHash())
                .email(userDetails.email())
                .displayName(updateUserRequest.displayName())
                .role(Role.ROLE_USER)
                .status(AccountStatus.Active)
                .build();

        userRepository.persistUser(updatedUserDetails);
    }


    public UserResponseWithCredentials getUserCredentialsByUsername(String username) {

        UserDetails userDetails = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("No such username exists!"));

        UserResponse userResponse = UserResponse.builder()
                .userId(userDetails.userId())
                .username(userDetails.username())
                .email(userDetails.email())
                .displayName(userDetails.displayName())
                .role(userDetails.role())
                .status(userDetails.status())
                .build();

        return new UserResponseWithCredentials(userResponse, userDetails.passwordHash());
    }

    public void changeUserPassword(UserPasswordUpdateRequest passwordUpdateRequest, AuthUser authUser) {

        UserDetails userDetails = getUserDetails(authUser.getNumericUserId());

        if (!passwordEncoder.matches(passwordUpdateRequest.oldPassword(), userDetails.passwordHash())) {
            throw new ApplicationAuthenticationException("Old password is incorrect");
        }

        String newPasswordHash = passwordEncoder.encode(passwordUpdateRequest.newPassword());

        UserDetails updatedUserDetails = UserDetails.builder()
                .username(userDetails.username())
                .passwordHash(newPasswordHash)
                .email(userDetails.email())
                .displayName(userDetails.displayName())
                .role(Role.ROLE_USER)
                .status(AccountStatus.Active)
                .build();

        userRepository.persistUser(updatedUserDetails);
    }

    private UserDetails getUserDetails(int userId) {

        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("No such userId exists!"));
    }

    private void throwIfNotValidRequest(CreateUserRequest createUserRequest) throws BadRequestException {

        throwIfUsernameIsInvalid(createUserRequest);
        throwIfEmailIsAlreadyUsed(createUserRequest);
    }

    private void throwIfUsernameIsInvalid(CreateUserRequest createUserRequest) {

        if (!StringUtils.isAsciiPrintable(createUserRequest.username())) {
            throw new BadRequestException("Username is not in ASCII format!");
        }
    }

    private void throwIfEmailIsAlreadyUsed(CreateUserRequest createUserRequest) {

        userRepository.findByEmail(createUserRequest.email()).ifPresent(user -> {
            throw BadRequestException.factorAlreadyInUse("", String.valueOf(user.userId()));
        });
    }
}
