package com.kenny.kenny_ai;

import com.kenny.kenny_ai.utils.VectorDistanceUtils;
import org.junit.jupiter.api.Test;
import org.springframework.ai.ollama.OllamaEmbeddingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class KennyAiApplicationTests {

	@Autowired
	private OllamaEmbeddingModel embeddingModel;

	@Test
	void contextLoads() {
		// 1.测试数据
		// 1.1.用来查询的文本，国际冲突
		String query = "national conflicts";

	}
}
