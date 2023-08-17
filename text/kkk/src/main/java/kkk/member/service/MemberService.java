package kkk.member.service;

import java.sql.Connection;
import java.sql.DriverManager;

import kkk.member.DAO.DAO;
import kkk.member.vo.Member;

public class MemberService {

	public Member login(Member member) throws Exception {
		
		Connection conn = getConnection();
		
		Member mem = DAO.login(conn,member);
		
		conn.close();
		
		return mem;
	}

}
