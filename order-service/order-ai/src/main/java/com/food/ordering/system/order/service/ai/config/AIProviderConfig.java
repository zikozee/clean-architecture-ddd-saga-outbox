package com.food.ordering.system.order.service.ai.config;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @dev : Ezekiel Eromosei
 * @date : 15 Jul, 2026
 */

@Configuration
public class AIProviderConfig {

    @Bean("orderNoteInterpreterChatClient")
    @ConditionalOnProperty(prefix = "order.ai", name = "provider", havingValue = "openai", matchIfMissing = true)
    ChatClient openAIChatClient(OpenAiChatModel openAiChatModel, SimpleLoggerAdvisor loggerAdvisor) {
        return ChatClient.builder(openAiChatModel).defaultAdvisors(loggerAdvisor).build();
    }

    @Bean("orderNoteInterpreterChatClient")
    @ConditionalOnProperty(prefix = "order.ai", name = "provider", havingValue = "ollama", matchIfMissing = true)
    ChatClient ollamaChatClient(OllamaChatModel ollamaChatModel, SimpleLoggerAdvisor loggerAdvisor) {
        return ChatClient.builder(ollamaChatModel).defaultAdvisors(loggerAdvisor).build();
    }

    @Bean
    SimpleLoggerAdvisor loggerAdvisor(){
        return  new SimpleLoggerAdvisor();
    }
}
