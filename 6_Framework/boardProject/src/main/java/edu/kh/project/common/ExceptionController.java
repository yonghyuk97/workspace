package edu.kh.project.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 예외 처리용 컨트롤러 (프로젝트 전역)
@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		
		// Exception e : 예외 정보를 담고있는 객체
		// Model model : 데이터 전달용 객체 ( request scope가 기본)
		
		e.printStackTrace(); // 예외 내용/발생 메소드 확인
		
		model.addAttribute("e", e);
		
		// forward 진행
		// -> view Resolver의 prefix, suffix를 붙혀 jsp 경로로 만듬
		return "common/error";
	}
		
	
}
