package com.workplace.dreamjob.user.api;

import com.workplace.dreamjob.security.user.AuthUser;
import com.workplace.dreamjob.user.api.model.CreateTraderRequest;
import com.workplace.dreamjob.user.service.TraderService;
import com.workplace.dreamjob.user.service.model.TraderCreateCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/user"})
public class UserController {

    private final TraderService traderService;

    // TODO: This endpoint should be authenticated
    @PostMapping(path = {"/trader"})
    public ResponseEntity<Void> registerTrader(
            Authentication authentication,
            @Valid @RequestBody CreateTraderRequest createTraderRequest) {

        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        int userId = authUser.getNumericUserId();

        TraderCreateCommand command = TraderCreateCommand.fromCreateTraderRequest(userId, createTraderRequest);
        traderService.createTrader(command);

        return ResponseEntity.ok().build();
    }
}
