package com.ness.BankingAssistant.dto;

import jakarta.validation.constraints.Size;

public record AskRequest(
        @Size(min = 5, max = 1000)
        String question
) { }
