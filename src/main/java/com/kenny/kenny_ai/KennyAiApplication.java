package com.kenny.kenny_ai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.kenny.kenny_ai.mapper")
@SpringBootApplication
public class KennyAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KennyAiApplication.class, args);
	}

}
