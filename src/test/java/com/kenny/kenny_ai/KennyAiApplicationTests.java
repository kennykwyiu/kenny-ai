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

		String[] texts2 = new String[] {
				// Relevant
				"哈马斯称加沙下阶段停火谈判仍在进行 以方尚未做出承诺",
				"乌克兰东部前线再起激烈交火 多地发布空袭警报",
				"土耳其、芬兰、瑞典与北约代表将继续就瑞典“入约”问题进行谈判",
				"也门胡塞武装与政府军在港口城市再度爆发冲突",
				// Borderline
				"联合国安理会呼吁有关各方保持克制 通过对话缓解地区紧张",
				"多国宣布扩大对俄制裁 涉及能源与金融领域",
				// Distractors
				"国家游泳中心（水立方）：恢复游泳、嬉水乐园等水上项目运营",
				"我国首次在空间站开展舱外辐射生物学暴露实验",
				"日本航空基地水井中检测出有机氟化物超标",
				"上海发布新一轮文旅消费券 刺激假期消费"
		};

		String query2 = "国际 冲突";

		String[] texts3 = new String[] {
				"加沙地带再起冲突 双方互指对方违反停火协议",
				"北约将举行防务部长会议 商讨东翼增兵计划",
				"中东地区多国外长在开罗举行紧急会晤 聚焦停火框架",
				"军事观察：黑海无人机冲突风险升温",
				"世卫组织宣布新一轮公共卫生培训项目",
				"高校毕业生就业服务周活动在多地展开",
				"我国成功发射遥感三十九号卫星",
				"杭州亚运会收官 中国代表团位列金牌榜第一",
				"新能源汽车销量再创新高 市场渗透率提升",
				"博物馆夜场活动走红 年轻人打卡热情高涨"
		};
	}
}
