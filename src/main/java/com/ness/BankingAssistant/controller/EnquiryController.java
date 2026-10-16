package com.ness.BankingAssistant.controller;

import com.ness.BankingAssistant.dto.*;
import com.ness.BankingAssistant.service.EnquiryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnquiryController {
    private final EnquiryService enquiryService;

    public EnquiryController(
            EnquiryService enquiryService) {

        this.enquiryService = enquiryService;
    }

    @PostMapping("/api/enquiries/classify")
    public ClassifyResponse classify(
            @Valid @RequestBody EnquiryRequest request) {

        return enquiryService.classify(request);
    }

    @PostMapping("/api/enquiries/summarize")
    public SummaryResponse summary(
            @Valid @RequestBody EnquiryRequest request) {

        return enquiryService.summary(request);
    }

    @PostMapping(" /api/assistant/ask")
    public AskResponse summary(
            @Valid @RequestBody AskRequest request) {

        return enquiryService.askQuestion(request);
    }


}
