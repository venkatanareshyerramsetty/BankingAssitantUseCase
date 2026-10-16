package com.ness.BankingAssistant.dto;

import jakarta.validation.constraints.Size;

public record ClassifyResponse(
         String category,
         String urgency,
         String sentiment,
         Double confidence,
         @Size(min = 10, max = 240)
         String rationale
) { }
