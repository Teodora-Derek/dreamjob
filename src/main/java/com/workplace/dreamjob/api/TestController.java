package com.workplace.dreamjob.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/dreamjob/test")
@Tag(name = "Test Controller", description = "Test API endpoints.")
public class TestController {

    @Operation(summary = "Gets a job section by id", security = {@SecurityRequirement(name = "bearer-key")})

    @GetMapping("/{id}")
    public ResponseEntity<String> getJobById(@PathVariable("id") @NotNull Long id) {
        return ResponseEntity.ok("Test job with ID: " + id);
    }
}
