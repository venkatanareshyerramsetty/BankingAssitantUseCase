package com.ness.BankingAssistant.service.impl;

import com.ness.BankingAssistant.prompt.PromptBuilder;
import com.ness.BankingAssistant.service.AiService;
import com.openai.client.OpenAIClient;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import org.springframework.stereotype.Service;

@Service
public class OpenAiServiceImpl implements AiService {
    private OpenAIClient client;

    public OpenAiServiceImpl(OpenAIClient client) {
        this.client = client;
    }

    @Override
    public String classify(String customerMessage) {
        String prompt = PromptBuilder.buildClassificationPrompt(customerMessage);
        return callOpenAI(prompt);
    }

    @Override
    public String buildSummary(String customerMessage) {
        String prompt = PromptBuilder.buildSummaryPrompt(customerMessage);
        return callOpenAI(prompt);
    }

    @Override
    public String askQuestion(String customerMessage) {
        String prompt = PromptBuilder.buildAskPrompt(customerMessage);
        return callOpenAI(prompt);
    }

    private String callOpenAI(String prompt) {

        ChatCompletionCreateParams params =
                ChatCompletionCreateParams.builder()
                        .model("gpt-4o-mini")
                        .addUserMessage(prompt)
                        .build();

        ChatCompletion completion =
                client.chat()
                        .completions()
                        .create(params);

        return completion
                .choices()
                .get(0)
                .message()
                .content()
                .orElse("No Response");
    }
}
