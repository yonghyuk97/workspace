package edu.kh.community.board.model.service;
import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.community.board.model.dao.ReplyDAO;
import edu.kh.community.board.model.vo.Reply;
import edu.kh.community.common.Util;




public class ReplyService {

	private ReplyDAO dao = new ReplyDAO();

	/** 댓글 목록 조회 Service
	 * @param boardNo
	 * @return reply
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(int boardNo) throws Exception {
		
		Connection conn = getConnection(); // DBCP에서 커넥션 얻어오기
		
		// 댓글 목록 조회 SQL 수행 후 결과 반환 받기
		List<Reply> rList = dao.selectReplyList(conn,boardNo);
		
		close(conn);
		
		return rList;
	}

	/** 댓글 작성 Service
	 * @param reply
	 * @return result
 	 * @throws Exception
	 */
	public int insertReply(Reply reply) throws Exception {
		
		Connection conn = getConnection();
		
		reply.setReplyContent( Util.XSSHanding(reply.getReplyContent() ));
		
		// - 개행문자 변경 처리
		// textarea에 줄바꿈 문자 입력시 \n, \r, \r\n, \n\r 중 하나로 입력된다 (브라우저, OS에 따라 다름)
		// 이 문자들을 HTML에서 줄바꿈으로 인식할 수 있도록 "<br>" 태그로 변경
		
		// reply.getReplyContent().replaceAll("정규표현식", "바꿀 문자열");
		
		// 댓글 등록/ 수정
		// 게시글 등록/수정에서 사용
		// reply.setReplyContent( reply.getReplyContent().replaceAll("\n|\r|\r\n|\n\r", "<br>") );
		
		// static으로 선언해둔 개행문자 변경 메소드 사용
		reply.setReplyContent( Util.newLineHandling( reply.getReplyContent() ));
		
		// XSS : 관리자가 아닌 이용자가 악성 스크립트를 삽입해서 공격
		// Cross Site Scripting(XSS, 크로스 사이트 스크립팅) 공격 
		
		
		int result = dao.insertReply(conn,reply);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteReply(int replyNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.deleteReply(conn,replyNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/** 댓글 수정 Service
	 * @param replyNo
	 * @param replyContent
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(int replyNo, String replyContent) throws Exception{
		
		Connection conn = getConnection();
		
		// XSS 처리
		replyContent =  Util.XSSHanding(replyContent);
		
		// 개행문자 처리
		replyContent = 	 Util.newLineHandling(replyContent);
		
		int result = dao.updateReply(conn, replyNo, replyContent);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

}
