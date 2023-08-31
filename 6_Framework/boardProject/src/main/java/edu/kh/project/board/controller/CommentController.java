package edu.kh.project.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.board.model.DTO.Comment;
import edu.kh.project.board.model.service.CommentService;

// @Controller + @ResponseBody
@RestController // 요청/응답 처리 (단, 모든 요청 응답은 비동기)
				// -> REST API 구축하기 위한 Controller
@SessionAttributes({"loginMember"})
public class CommentController {

	@Autowired
	private CommentService service;
	
	
	// 댓글 목록 조회
	@GetMapping(value="/comment", produces = "application/json; charset=UTF-8")
	public List<Comment> select(@RequestParam("boardNo") int boardNo) {
		return service.select(boardNo); // HttpmessageConverter List -> JSON 변환
	}
	
	// 댓글 삽입 
	@PostMapping(value="/comment")
	public int insert(@RequestBody Comment comment) {
		// 요청 데이터(JSON)를
		// HttpMessageConverter가 해석해서 Java 객체(comment)에 대입
		return service.insert(comment);
	}
	
	// 댓글 삭제
	@DeleteMapping("/comment")
	public int delete(@RequestBody int commentNo) {
				// ajax 요청 시 body에 담겨있는 하나 밖에 없는 데이터는
				// 매개변수 int commentNo에 담기게 된다.
		return service.delete(commentNo);
	}
	
	@PutMapping("/comment")
	public int update(@RequestBody Comment comment) {
		
		return service.update(comment);
	}
	
}
