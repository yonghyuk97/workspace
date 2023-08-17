package edu.kh.community.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.community.board.model.service.BoardService;
import edu.kh.community.board.model.service.ReplyService;
import edu.kh.community.board.model.vo.BoardDetail;
import edu.kh.community.board.model.vo.Reply;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 파라미터 총 게시글 번호(no) 얻어오기
			int boardNo = Integer.parseInt(req.getParameter("no"));
			
			BoardService service = new BoardService();
			
			// 게시글 정보 + 이미지리스트 조회
			BoardDetail detail = service.selectBoardDetail(boardNo);
			
			// 게시글 상세조회된 내용이 있을 경우 댓글 목록 조회
			if(detail != null) {
				ReplyService rService = new ReplyService();
				
				List<Reply> rList = rService.selectReplyList(boardNo);
				req.setAttribute("rList", rList);
				
				// 	List<Reply> rList =new ReplyService().selectReplyList(boardNo);
			}
			
			req.setAttribute("detail", detail);
			
			String path = "/WEB-INF/views/board/boardDetail.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
}
