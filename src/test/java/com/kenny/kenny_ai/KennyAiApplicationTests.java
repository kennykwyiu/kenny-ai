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

		// 1.2.用来做比较的文本
		String[] texts = new String[]{
				"哈马斯称加沙下阶段停火谈判仍在进行 以方尚未做出承诺",
				"土耳其、芬兰、瑞典与北约代表将继续就瑞典“入约”问题进行谈判",
				"日本航空基地水井中检测出有机氟化物超标",
				"国家游泳中心（水立方）：恢复游泳、嬉水乐园等水上项目运营",
				"我国首次在空间站开展舱外辐射生物学暴露实验",
		};

	}
}
