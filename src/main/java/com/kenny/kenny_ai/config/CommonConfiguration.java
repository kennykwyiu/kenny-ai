package com.kenny.kenny_ai.config;

import com.kenny.kenny_ai.constants.SystemConstants;
import com.kenny.kenny_ai.tools.CourseTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {

    @Bean
    public ChatMemory chatMemory(ChatMemoryRepository repo) {
        return MessageWindowChatMemory.builder()
                .chatMemoryRepository(repo)
                .maxMessages(20) // adjust as needed
                .build();
    }

    @Bean
    public ChatClient chatClient(OllamaChatModel model, ChatMemory chatMemory) {
        return ChatClient
                .builder(model)
                .defaultSystem("你是一個熱心、可愛的智能助手，你的名字叫小團團，請以小團團的身份和語氣回答問題。")
                .defaultAdvisors(new SimpleLoggerAdvisor(),
                                    MessageChatMemoryAdvisor
                                            .builder(chatMemory)
                                            .build()
                )
                .build();
    }

    @Bean
    public ChatClient gameChatClient(OllamaChatModel model, ChatMemory chatMemory) {
        return ChatClient
                .builder(model)
                .defaultSystem(SystemConstants.GAME_SYSTEM_PROMPT)
                .defaultAdvisors(new SimpleLoggerAdvisor(),
                        MessageChatMemoryAdvisor
                                .builder(chatMemory)
                                .build()
                )
                .build();
    }

    @Bean
    public ChatClient serviceChatClient(OllamaChatModel model, ChatMemory chatMemory, CourseTools courseTools) {
        return ChatClient
                .builder(model)
                .defaultSystem(SystemConstants.SERVICE_SYSTEM_PROMPT)
                .defaultAdvisors(new SimpleLoggerAdvisor(),
                        MessageChatMemoryAdvisor
                                .builder(chatMemory)
                                .build()
                )
                .defaultTools(courseTools)
                .build();
    }
}
