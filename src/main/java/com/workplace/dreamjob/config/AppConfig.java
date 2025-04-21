package com.workplace.dreamjob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

@Configuration
public class AppConfig {

    private static final long EPOCH_SECONDS_START = 1744550000; // 2025-04-13T13:13:20Z[UTC]

    @Bean
    public Clock clock() {
        return Clock.fixed(toInstant(0), ZoneId.of("UTC"));
    }

    private static Instant toInstant(int seconds) {
        return Instant.ofEpochSecond(EPOCH_SECONDS_START + seconds);
    }
}
