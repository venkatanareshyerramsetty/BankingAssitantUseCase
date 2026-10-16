package com.ness.BankingAssistant.controller;

import com.ness.BankingAssistant.dto.BankingAssistantRequest;
import com.ness.BankingAssistant.dto.BankingAssistantResponse;
import com.ness.BankingAssistant.service.BankingAssistantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sdk")
public class BankingAssistantController {

    private final BankingAssistantService aiService;

    public BankingAssistantController(BankingAssistantService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/summary/basic")
    public BankingAssistantResponse basicSummary(
            @RequestBody BankingAssistantRequest request) {

        return new BankingAssistantResponse(
                aiService.basicSummary(
                        request.meetingNotes()));
    }

    @PostMapping("/summary/system")
    public BankingAssistantResponse systemSummary(
            @RequestBody BankingAssistantRequest request) {

        return new BankingAssistantResponse(
                aiService.summaryWithSystemPrompt(
                        request.meetingNotes()));
    }

    @PostMapping("/summary/tone")
    public BankingAssistantResponse toneSummary(
            @RequestBody BankingAssistantRequest request) {

        return new BankingAssistantResponse(
                aiService.executiveSummary(
                        request.meetingNotes()));
    }

    @PostMapping("/summary/highlights")
    public BankingAssistantResponse highlights(
            @RequestBody BankingAssistantRequest request) {

        return new BankingAssistantResponse(
                aiService.highlights(
                        request.meetingNotes()));
    }

    @PostMapping("/email-draft")
    public BankingAssistantResponse emailDraft(
            @RequestBody BankingAssistantRequest request) {

        return new BankingAssistantResponse(
                aiService.emailDraft(
                        request.meetingNotes()));
    }

}
