package com.workplace.dreamjob.user.service;

import com.workplace.dreamjob.common.AccountStatus;
import com.workplace.dreamjob.common.exception.BadRequestException;
import com.workplace.dreamjob.common.exception.NotFoundException;
import com.workplace.dreamjob.common.Role;
import com.workplace.dreamjob.security.exception.ApplicationAuthenticationException;
import com.workplace.dreamjob.user.model.UserDetails;
import com.workplace.dreamjob.user.repository.UserRepository;
import com.workplace.dreamjob.user.service.request.UserCreateCommand;
import com.workplace.dreamjob.user.service.request.UserPatchCommand;
import com.workplace.dreamjob.user.service.response.UserResponse;
import com.workplace.dreamjob.user.service.response.UserResponseWithCredentials;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetails getUserDetails(int userId) {

        return userRepository.findByUserId(userId)
                .orElseThrow(() -> BadRequestException.userIdNotFound(Integer.toString(userId)));
    }

    public void createUser(UserCreateCommand command) {

        throwIfNotValidRequest(command);
        String passwordHash = passwordEncoder.encode(command.password());

        UserDetails userDetails = UserDetails.builder()
                .username(command.username())
                .passwordHash(passwordHash)
                .email(command.email())
                .displayName(command.displayName())
                .role(Role.ROLE_USER)
                .status(AccountStatus.Active)
                .build();

        userRepository.create(userDetails);
    }


    public void patchUserDetails(UserPatchCommand command) {

        int userId = command.userId();
        UserDetails currentUserDetails = getUserDetails(userId);

        UserDetails updatedUserDetails = UserDetails.builder()
                .displayName(command.displayName() != null ? command.displayName() : currentUserDetails.displayName())
                .passwordHash(command.password() != null ? command.password() : currentUserDetails.passwordHash())
                .status(command.status() != null ? command.status() : currentUserDetails.status())
                .build();

        userRepository.patch(updatedUserDetails);
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

    public void changeUserPassword(
            int userId,
            String oldPassword,
            String newPassword) {

        UserDetails userDetails = getUserDetails(userId);

        if (!passwordEncoder.matches(oldPassword, userDetails.passwordHash())) {
            throw new ApplicationAuthenticationException("Old password is incorrect");
        }

        String newPasswordHash = passwordEncoder.encode(newPassword);

        UserDetails updatedUserDetails = UserDetails.builder()
                .passwordHash(newPasswordHash)
                .displayName(userDetails.displayName())
                .status(AccountStatus.Active)
                .build();

        userRepository.patch(updatedUserDetails);
    }

    private void throwIfNotValidRequest(UserCreateCommand command) {

        throwIfUsernameIsInvalid(command.username());
        throwIfEmailIsAlreadyUsed(command.email());
    }

    private void throwIfUsernameIsInvalid(String username) {

        if (!StringUtils.isAsciiPrintable(username)) {
            throw new BadRequestException("Username is not in ASCII format!");
        }
    }

    private void throwIfEmailIsAlreadyUsed(String email) {

        userRepository.findByEmail(email).ifPresent(user -> {
            throw BadRequestException.factorAlreadyInUse("", String.valueOf(user.userId()));
        });
    }
}
