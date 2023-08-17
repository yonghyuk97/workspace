package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // Persistence Layer, 영속성 관련 클래스
// 			(파일, DB 관련 클래스) + Bean 등록 (== Spring이 객체로 만들어줌)
public class MemberDAO {

	// SqlSessionTemplate (마이바티스 객체)
	@Autowired // 등록된 Bean 중에서 SqlSessionTemplate 타입의 Bean을 주입
	private SqlSessionTemplate sqlsession;
	
	/** 로그인 DAO
	 * @param inputMember
	 * @return 회원 정보 또는 null
	 */
	public Member login(Member inputMember) {
		
		// 마이바티스를 이용해서 1행 조회(selectOne)
		
		// sqlSession.selectOne("namespace값.id값", 전달할 값)
		// -> namespace가 일치하는 mapper에서 
		//    id가 일치하는 SQL 구문을 수행 후 
		//    결과를 1행 (dto, 기본 자료형)반환
		
		return sqlsession.selectOne("memberMapper.login", inputMember);
	}

	/** 회원가입 DAO
	 * @param inputMember
	 * @return result
	 */
	public int signUp(Member inputMember) {
		// 1) mapper의 namespace 지정 후 
		// 그 안에 어떤 Id를 가지는 sql을 수행할지 작성
		
		// 2) SQL에 사용할 데이터 전달 ( 자료형 중요!!! )
		
		// return sqlsession.insert("1) namgspace.id", 2) inputMember);
		
		// insert 성공한 행의 개수 반환
		return sqlsession.insert("memberMapper.signUp", inputMember);
	}


	
}
