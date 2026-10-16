package com.ness.BankingAssistant.dto;

import jakarta.validation.constraints.Size;

public record SummaryResponse(
        @Size(min = 10, max = 500)
        String summary,
        @Size(min = 10, max = 500)
        String suggestedNextStep
) {
}
