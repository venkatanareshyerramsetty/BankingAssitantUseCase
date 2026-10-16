package com.ness.BankingAssistant.service;

public interface AiService {
    String classify(String customerMessage);
    String buildSummary(String customerMessage);
    String askQuestion(String customerMessage);
}
