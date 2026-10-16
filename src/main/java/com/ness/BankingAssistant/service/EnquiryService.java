package com.ness.BankingAssistant.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ness.BankingAssistant.dto.*;
import org.springframework.stereotype.Service;

@Service
public class EnquiryService {
    private final AiService aiService;
    private final ObjectMapper mapper;

    public EnquiryService(
            AiService aiService,
            ObjectMapper mapper) {

        this.aiService = aiService;
        this.mapper = mapper;
    }

    public ClassifyResponse classify(
            EnquiryRequest request) {

        try {

            String aiResponse =
                    aiService.classify(
                            request.message());

            return mapper.readValue(
                    aiResponse,
                    ClassifyResponse.class);

        } catch (Exception ex) {

            throw new RuntimeException(
                    "Failed to process AI response");
        }
    }

    public SummaryResponse summary(
            EnquiryRequest request) {

        try {

            String aiResponse =
                    aiService.buildSummary(
                            request.message());

            return mapper.readValue(
                    aiResponse,
                    SummaryResponse.class);

        } catch (Exception ex) {

            throw new RuntimeException(
                    "Failed to process AI response");
        }
    }

    public AskResponse askQuestion(
            AskRequest request) {

        try {

            String aiResponse =
                    aiService.askQuestion(
                            request.question());

            return mapper.readValue(
                    aiResponse,
                    AskResponse.class);

        } catch (Exception ex) {

            throw new RuntimeException(
                    "Failed to process AI response");
        }
    }

}
