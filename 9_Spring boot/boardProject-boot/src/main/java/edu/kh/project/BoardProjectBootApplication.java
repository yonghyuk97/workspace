package edu.kh.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

					// 보안 관련 자동 설정을 사용 X 
			//(bCryptPasswordEncoder로 하니까 자동설정을 로그인 화면이 생김 그래서 없애줌)
@SpringBootApplication(exclude = SecurityAutoConfiguration.class )
// Spring boot Application을 만들고, 수행하는데 필요한
// 필수 어노테이션을 모아둔 어노테이션
public class BoardProjectBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardProjectBootApplication.class, args);
	}

}
