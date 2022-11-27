package com.hackaton.todayfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TodayfitApplication {

	//비밀번호 해쉬 인코딩 매소드 빈 등록
	@Bean
	public BCryptPasswordEncoder encodePWD(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(TodayfitApplication.class, args);
	}

}
