package com.ness.BankingAssistant.service;

import com.ness.BankingAssistant.dto.PromptAudit;

import java.util.List;

public interface AiService {
    String classify(String customerMessage);
    String buildSummary(String customerMessage);
    String askQuestion(String customerMessage);
    List<PromptAudit> auditPromptHistory();
}
