package edu.kh.jdbc.member.model.service;

// import static 구문 : static 메소드를 import하여
//					   클래스명.static메소드() 형태에서
//					   클래스명을 생략할 수 있게 하는 구문

import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import  edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.vo.Member;


// Service : 데이터 가공(요청에 맞는 데이터를 만드는 것)
// 			+ 트랜잭션 제어 처리
//			-> 하나의 Service 메소드에서 n개의 DAO 메소드를 호출할 수 있음
//				-> n개의 DAO에서 수행된 SQL을 한 번에 commit/rollback  

// *** Service 에서 트랜잭션을 처리하기 위해서는 Connection 객체가 필요하다 ***
//		== Service에서 Connection 객체를 생성하고 반환해야 한다.

public class MemberService {
	
	// 회원 관련 SQL 수행 및 결과를 반환할 DAO 객체 생성 및 참조
	private MemberDAO dao = new MemberDAO();

	/**
	 * 아이디 중복 검사 Service
	 * @param memberId
	 * @return
	 */
	public int duplicateCheck(String memberId) throws Exception{
		
		// 1. Connection 객체 생성
		// -> JDBCTemplate에 작성된 getConnection() 메소드를 이용해 생성 후 얻어옴
		Connection conn = getConnection(); // JDBCTemplate.getConnection()
		
		
		// 2. DAO 메소드 (SELECT) 호출 후 결과 반환 받음 
		int result = dao.duplicateCheck(conn, memberId);
		
		// (SELECT는 별도의 트랜잭션 제어 필요 없음)
		// 3. 사용한 Connection 객체 반환
		close(conn);
		
		// 4. 중복 검사 반환 View로 반환
		
		return result;
	}

	/** 
	 * 회원 가입 Service
	 * @param signUpMember
	 * @return result
	 * @throws Exception
	 */
	public int singUp(Member signUpMember) throws Exception{ // 모든 예외는 view에서 모아 처리
		
		// 1) Connection 생성
		Connection conn = getConnection();
		// 2) 회원 가입 DAO 메소드 호출하고 결과 반환 받기
		 int result = dao.singUp(conn,signUpMember);
		
		// 3) DAO 수행 결과에 따라 트랜잭션 처리
		if(result > 0 ) commit(conn);
		else			rollback(conn);
		// 4) 사용한 Connection 반환
		close(conn);
		
		// 5) DAO 수행결과 View로 반환
		return result;
	}

	/**
	 * 로그인 Service
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member mem) throws Exception {
		
		// 1) Connection 생성
		Connection conn = getConnection();
		// 2) DAO 메소드 수행 후 결과 반환 받기
		Member loginMember = dao.login(conn, mem);
		// (SELECT 수행 -> 트랜잭션 제어 처리 X) 
		
		// 3) 사용한 Connection 반환
		close(conn);
		
		// 4) DAO 조회결과 View로 반환
		return loginMember;
	}

	/**
	 * 가입된 회원 목록 조회 Service
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectAll() throws Exception{
		
		// 1) Connection 생성
		Connection conn = getConnection();
		
		// 2) DAO 메소드(SELECT 수행) 호출 후 결과 반환 받기
		List<Member> memberList =dao.selectAll(conn);
		
		// 3) Connection 반환
		close(conn);
		
		// 4) DAO 호출 결과 View 반환
		return memberList;
	}

	/**
	 * 내 정보 수정 Service
	 * @param updateMember
	 * @return result
	 * @throws Exception
	 */
	public int updateMyInfo(Member updateMember) throws Exception{
		
		// 1) Connection 생성
		Connection conn = getConnection();
		
		// 2)DAO 수행(UPDATE) 후 결과 반환 받기
		int result = dao.updateMyInfo(conn,updateMember);
		
		// 3) 트랜젝션 제어 처리 (DML(UPDATE,INSERT,DELETE) 사용했기 때문에)
	
		if(result > 0)  commit(conn);
		else		   rollback(conn);
		
		// 4)사용한 Connection 자원 반환 
		close(conn);
		
		// 5) DAO 수행 결과 View로 반환
		return result;
	}

	/**
	 * 비밀번호 변경 Service
	 * @param memberNo
	 * @param currentPw
	 * @param newPw
	 * @return result
	 * @throws Exception
	 */
	public int updatePw(int memberNo, String currentPw, String newPw) throws Exception{
		// 1) Connection 생성
		Connection conn = getConnection();
		
		// 2)DAO 수행(UPDATE) 후 결과 반환 받기
		int result = dao.updatePw(conn, memberNo, currentPw, newPw);
		
		// 3) 트랜젝션 제어 처리 (DML(UPDATE,INSERT,DELETE) 사용했기 때문에)
		if(result > 0)  commit(conn);
		else		   rollback(conn);
		
		// 4)사용한 Connection 자원 반환 
		close(conn);
		
		// 5) DAO 수행 결과 View로 반환
		return result;
	}

	/**
	 * 회원 탈퇴 Service
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(int memberNo, String memberPw) throws Exception {
	
		Connection conn = getConnection();
		
		int result = dao.secession(conn, memberNo, memberPw);
		
		if(result > 0)  commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		return result;
	}

}
