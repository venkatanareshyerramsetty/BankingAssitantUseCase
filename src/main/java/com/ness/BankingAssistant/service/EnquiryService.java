package com.ness.BankingAssistant.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ness.BankingAssistant.dto.*;
import com.ness.BankingAssistant.repository.PromptAuditRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiryService {
    private final AiService aiService;
    private final ObjectMapper mapper;
    private final PromptAuditRepository auditRepository;

    public EnquiryService(
            AiService aiService,
            ObjectMapper mapper, PromptAuditRepository auditRepository) {

        this.aiService = aiService;
        this.mapper = mapper;
        this.auditRepository = auditRepository;
    }

    public ClassifyResponse classify(
            EnquiryRequest request) {

        try {

            String aiResponse =
                    aiService.classify(
                            request.message());

            ClassifyResponse classifyResponse = mapper.readValue(
                    aiResponse,
                    ClassifyResponse.class);

            //audit method
            PromptAudit audit = new PromptAudit();
            audit.setPrompt(request.message());
            audit.setPromptType("Classify");
            audit.setResponse(String.valueOf(classifyResponse));
            //saving audit prompt
            auditRepository.save(audit);

            return classifyResponse;

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

            SummaryResponse summaryResponse = mapper.readValue(
                    aiResponse,
                    SummaryResponse.class);

            //audit method
            PromptAudit audit = new PromptAudit();
            audit.setPrompt(request.message());
            audit.setPromptType("Summary");
            audit.setResponse(String.valueOf(summaryResponse));
            //saving audit prompt
            auditRepository.save(audit);

            return summaryResponse;

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

            AskResponse askResponse = mapper.readValue(
                    aiResponse,
                    AskResponse.class);

            //audit method
            PromptAudit audit = new PromptAudit();
            audit.setPrompt(request.question());
            audit.setPromptType("AskQuestion");
            audit.setResponse(String.valueOf(askResponse));
            //saving audit prompt
            auditRepository.save(audit);

            return askResponse;

        } catch (Exception ex) {

            throw new RuntimeException(
                    "Failed to process AI response");
        }
    }

    public List<PromptAudit>auditPromptHistory(){
        return aiService.auditPromptHistory();
    }

}
