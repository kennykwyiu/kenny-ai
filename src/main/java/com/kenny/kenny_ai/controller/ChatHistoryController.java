package com.kenny.kenny_ai.controller;

import com.kenny.kenny_ai.entity.vo.MessageVO;
import com.kenny.kenny_ai.repository.ChatHistoryRepository;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ai/history")
public class ChatHistoryController {
    private final ChatHistoryRepository chatHistoryRepository;

    private final ChatMemory chatMemory;

    public ChatHistoryController(ChatHistoryRepository chatHistoryRepository, ChatMemory chatMemory) {
        this.chatHistoryRepository = chatHistoryRepository;
        this.chatMemory = chatMemory;
    }

    @GetMapping("/{type}")
    public List<String> getChatIds(@PathVariable("type") String type) {
        return chatHistoryRepository.getChatIds(type);
    }

    @GetMapping("/{type}/{chatId}")
    public List<MessageVO> getChatHistory(@PathVariable("type") String type, @PathVariable("chatId") String chatId) {
        List<Message> messages = chatMemory.get(chatId);
        if (messages==null) {
            return List.of();
        }
        return messages.stream().map(MessageVO::new).toList();
    }
}
