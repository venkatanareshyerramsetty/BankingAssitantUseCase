package com.ness.BankingAssistant.prompt;

public class PromptBuilder {
    public static String buildClassificationPrompt(String message) {

        return """
                Classify this enquiry.

                Allowed category:
                TRANSFER_ISSUE,
                CARD_ISSUE,
                ACCOUNT_SERVICE,
                DIGITAL_BANKING,
                LOAN_QUERY,
                GENERAL_ENQUIRY,
                OTHER.

                Allowed urgency:
                LOW,
                MEDIUM,
                HIGH.

                Allowed sentiment:
                POSITIVE,
                NEUTRAL,
                CONCERNED,
                FRUSTRATED.

                Enquiry:
                %s

                Return ONLY valid JSON:
                {
                  "category":"",
                  "urgency":"",
                  "sentiment":"",
                  "confidence":0.0,
                  "rationale":""
                }
                """
                .formatted(message);
    }

    public static String buildSummaryPrompt(String message) {

        return """
                Summarize this enquiry and.
                %s

                Return ONLY valid JSON:
                {
                  "summary":"",
                  "suggestedNextStep":""
                }
                """
                .formatted(message);
    }

    public static String buildAskPrompt(String message) {

        return """
                 answer and.
                %s

                Return ONLY valid JSON:
                {
                  "answer":"",
                  "disclaimer":""
                }
                """
                .formatted(message);
    }

}
