package com.workplace.dreamjob.user.service;

import com.workplace.dreamjob.common.AccountStatus;
import com.workplace.dreamjob.common.exception.BadRequestException;
import com.workplace.dreamjob.user.model.TraderDetails;
import com.workplace.dreamjob.user.model.UserDetails;
import com.workplace.dreamjob.user.repository.TraderRepository;
import com.workplace.dreamjob.user.service.request.TraderCreateCommand;
import com.workplace.dreamjob.user.service.request.TraderPatchCommand;
import com.workplace.dreamjob.user.service.request.UserPatchCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TraderService {

    private final TraderRepository traderRepository;
    private final UserService userService;

    public TraderDetails getTraderDetails(int traderId) {

        return traderRepository.findById(traderId)
                .orElseThrow(() -> BadRequestException.userIdNotFound(Integer.toString(traderId)));
    }

    @Transactional
    public void createTrader(TraderCreateCommand command) {

        int userId = command.userId();
        throwIfTraderExists(userId);

        UserDetails userDetails = getTraderUserDetails(userId);
        activateUserStatusOrThrow(userDetails);

        TraderDetails traderDetails = TraderDetails.builder()
                .userId(userId)
                .mobileNumber(command.mobileNumber())
                .description(command.description())
                .status(AccountStatus.Active)
                .userDetails(userDetails)
                .build();

        traderRepository.create(traderDetails);
    }

    public void patchTraderDetails(TraderPatchCommand command) {

        TraderDetails currentDetails = getTraderDetails(command.traderId());

        TraderDetails updatedTraderDetails = TraderDetails.builder()
                .id(currentDetails.id())
                .userId(currentDetails.userId())
                .mobileNumber(command.mobileNumber() != null ? command.mobileNumber() : currentDetails.mobileNumber())
                .description(command.description() != null ? command.description() : currentDetails.description())
                .status(command.status() != null ? command.status() : currentDetails.status())
                .build();

        traderRepository.patch(updatedTraderDetails);
    }

    private void activateUserStatusOrThrow(UserDetails userDetails) {

        throwIfUserStatusSuspended(userDetails);

        UserPatchCommand command = UserPatchCommand.builder()
                .userId(userDetails.userId())
                .status(AccountStatus.Active)
                .build();

        userService.patchUserDetails(command);
    }


    private void throwIfTraderExists(int userId) {

        traderRepository.findByUserId(userId)
                .ifPresent(traderDetails -> {
                    throw BadRequestException.userAlreadyExists(Integer.toString(traderDetails.userId()));
                });
    }

    private UserDetails getTraderUserDetails(int userId) {

        return userService.getUserDetails(userId);
    }

    private void throwIfUserStatusSuspended(UserDetails userDetails) {

        if (userDetails.status() == AccountStatus.Suspended) {
            throw new BadRequestException("User was suspended! Action denied!");
        }
    }
}
