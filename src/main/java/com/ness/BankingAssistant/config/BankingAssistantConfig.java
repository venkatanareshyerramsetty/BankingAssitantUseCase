package com.ness.BankingAssistant.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankingAssistantConfig {

    @Value("${OPENAI_API_KEY}")
    private String apiKey;


    @Bean
    public OpenAIClient configureApiKey() {
        return OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
