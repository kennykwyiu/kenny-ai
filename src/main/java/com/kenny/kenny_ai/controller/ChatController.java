package com.kenny.kenny_ai.controller;

import com.kenny.kenny_ai.repository.ChatHistoryRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@RestController
@RequestMapping("/ai")
public class ChatController {

    private final ChatClient chatClient;

    private final ChatHistoryRepository chatHistoryRepository;
    
    public ChatController(ChatClient chatClient, ChatHistoryRepository chatHistoryRepository) {
        this.chatClient = chatClient;
        this.chatHistoryRepository = chatHistoryRepository;
    }

    @RequestMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(String prompt, String chatId) {

        chatHistoryRepository.save("chat", chatId);
        
        return chatClient.prompt()
                .user(prompt)
//                .advisors(new org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor())
                .advisors(a -> a.param(CONVERSATION_ID, chatId))
                .stream()
                .content();
    }
}
