package com.ness.BankingAssistant.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnquiryRequest(
        @Size(max = 40)
        String customerReference,

        String channel,

        @NotBlank
        @Size(min = 10, max = 1500)
        String message
) {
}
