package com.kenny.kenny_ai;

import org.junit.jupiter.api.Test;
import org.springframework.ai.ollama.OllamaEmbeddingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KennyAiApplicationTests {

	@Autowired
	private OllamaEmbeddingModel embeddingModel;

	@Test
	void contextLoads() {
	}

}
