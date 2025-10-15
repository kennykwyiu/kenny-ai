package com.kenny.kenny_ai.repository;

import java.util.List;

public class InMemoryChatHistoryRepository implements ChatHistoryRepository {
    @Override
    public void save(String type, String chatId) {

    }

    @Override
    public List<String> getChatIds(String type) {
        return List.of();
    }
}
