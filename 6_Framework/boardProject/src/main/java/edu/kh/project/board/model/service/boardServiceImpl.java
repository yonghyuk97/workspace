package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.board.model.DAO.BoardDAO;

@Service
public class boardServiceImpl implements BoardService {

	@Autowired // 타입이 같은 걸 연결해서 의존성 주입 하겠다~~
	private BoardDAO dao;

	// 게시판 종류 목록 조회
	@Override
	public List<Map<String, Object>> selectBoardTypeList() {
		return dao.selectBoardTypeList();
	}
}
