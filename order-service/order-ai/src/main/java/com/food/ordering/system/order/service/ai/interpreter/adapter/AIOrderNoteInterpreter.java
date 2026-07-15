package com.food.ordering.system.order.service.ai.interpreter.adapter;


import com.food.ordering.system.order.service.ai.exception.AIOrderNoteInterpreterException;
import com.food.ordering.system.order.service.domain.ports.output.ai.order.noteinterpreter.OrderNoteInterpreter;
import com.food.ordering.system.order.service.domain.valueobject.OrderPreferences;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @dev : Ezekiel Eromosei
 * @date : 15 Jul, 2026
 */

@Slf4j
@Component
public class AIOrderNoteInterpreter implements OrderNoteInterpreter {

    private final ChatClient chatClient;
    private final Resource orderNoteInterpreterPrompt;
    private final Resource orderSystemPrompt;
    private final int maxAttempts;


    public AIOrderNoteInterpreter(@Qualifier("openAIChatClient") ChatClient chatClient,
                                  @Value("classpath:/templates/order-interpreter-prompt.st") Resource orderNoteInterpreterPrompt,
                                  @Value("classpath:/templates/order-system-prompt.st") Resource orderSystemPrompt,
                                  @Value("${order.ai.interpreter.max-attempts}") int maxAttempts) {
        this.chatClient = chatClient;
        this.orderNoteInterpreterPrompt = orderNoteInterpreterPrompt;
        this.orderSystemPrompt = orderSystemPrompt;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public OrderPreferences interpret(String orderNote) {
        AIOrderNoteInterpreterException lastException  = null;
        PromptTemplate promptTemplate = new PromptTemplate(orderNoteInterpreterPrompt);

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                String retryWarning = getRetryWarning(attempt);
                OrderPreferences orderPreferences = doInterpret(orderNote, promptTemplate, retryWarning);
                log.info("Returning order preference for order notes: {}", orderNote);
                return orderPreferences;
            }catch (Exception e){
                log.warn("Error in Order Interpreter AI response: {}", e.getMessage());
                lastException = new AIOrderNoteInterpreterException("Error in Order Interpreter AI response", e);
            }
        }
        throw lastException;
    }

    private String getRetryWarning(int attempt) {
        return attempt == 1
                ? ""
                : """
                IMPORTANT:
                Previous attempt %d produced an invalid response that could not be parsed into the required OrderPreferences structure.
                
                Remaining attempts: %d
                
                Return ONLY valid structured output matching the required schema.
                Do NOT include explanations, markdown, reasoning, conversational text, or extra content
                """.formatted(attempt - 1, maxAttempts - attempt + 1);
    }

    private OrderPreferences doInterpret(String orderNote, PromptTemplate promptTemplate, String retryWarning){
        Prompt orderNotesPrompt = promptTemplate.create(Map.of(
                "orderNotes", orderNote,
                "retryWarning", retryWarning)
        );
        return chatClient
                .prompt(orderNotesPrompt)
                .system(orderSystemPrompt)
                .call()
                .entity(OrderPreferences.class);
    }

}
