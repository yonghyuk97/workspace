package edu.kh.project.board.model.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.DTO.Board;
import edu.kh.project.board.model.DTO.BoardImage;

@Repository
public class boardDAO2 {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 게시글 삽입
	 * @param board
	 * @return boardNo
	 */
	public int boardInsert(Board board) {
		
		int result = sqlSession.insert("boardMapper.boardInsert", board);
		// -> sql 수행 후 매개변수 board 객체에는 boardNo가 존재한다. 
		
		// 삽입 성공 시 
		if(result > 0) result = board.getBoardNo();
		
		return result; // 삽입 성공 시 boardNo, 실패 시 0 반환
	}

	/** 이미지 리스트(여러 개) 삽입
	 * @param uploadList
	 * @return result
	 */
	public int insertImageList(List<BoardImage> uploadList) {
		
		return sqlSession.insert("boardMapper.insertImageList", uploadList);
	}
}
