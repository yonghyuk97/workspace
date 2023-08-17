package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.AjaxDAO;

@Service //  서비스 임을 명시 + Bean 등록
public class AjaxServiceImpl implements AjaxService{

	@Autowired
	private AjaxDAO dao;

	// 이메일로 닉네임 조회
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String selectNickname(String email) {
		
		return dao.selectNickname(email);
	}

	// 닉네임으로 전화번호 조회
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String selectMemberTel(String nickname) {
		
		return dao.selectMemberTel(nickname);
	}

	// 이메일 중복 검사
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int CheckEmail(String email) {
		return dao.CheckEmail(email);
	}
	// 닉네임 중복 검사
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int checkNickname(String nickname) {
		return dao.checkNickname(nickname);
	}
}
