package com.lec.spring.config04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.lec.beans.Score;

@Configuration
@ImportResource("classpath:appCtx04.xml") // XML 설정을 Java 설정안에 가져오기
public class AppConfig04 {
	
	@Bean
	public Score score1() {
		return new Score(100, 100, 100, "만만점");
	}
	
	@Bean
	public Score score2() {
		return new Score(60, 30, 45, "나빠요");
	}
	
}
