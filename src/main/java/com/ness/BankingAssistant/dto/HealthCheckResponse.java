package com.ness.BankingAssistant.dto;

public record HealthCheckResponse(
        String status,
        String service
) { }
