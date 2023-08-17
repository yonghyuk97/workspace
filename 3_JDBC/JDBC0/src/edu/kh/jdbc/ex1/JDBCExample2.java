package edu.kh.jdbc.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {

	public static void main(String[] args) {
		
		// 필요한 변수선언 
		
		Connection conn = null; // 연결통로
		
		Statement stmt = null; // 입력값 또는 결과값을 담아 옮겨줄 버스 
		
		ResultSet rs = null;  // 결과값 저장용 변수
		
		
		try {
			// DB연결에 필요한 Oracle JDBC Driver 메모리 로드 
			// (생략 가능)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		// FIleNotFoundExamception 발생 가능성 있음
			
			String type = "jdbc:oracle:thin:@";
			
			String host = "localhost";
			
			String port = ":1521";
			
			String sid = ":xe";
			
			String id = "lhk";
			
			String pw = "lhk1234";
			
			//conn = DriverManager.getConnection(type+host+port+sid,id,pw);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "lys", "lys1234");
			
			System.out.println(conn);
			
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY FROM EMPLOYEE ORDER BY EMP_NAME ASC";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			int sum = 0; // 합계를 구할 변수 선언
			
			while( rs.next() ) {
				// 여기서 rs.next() --> 다음 결과 값이 있으면 true를 반환, 다음 결과 값이 없다면 false를 반환
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				
				sum += salary;
				
				System.out.printf("사번 : %d 이름 : %s 급여: %6d원\n",empId,empName,salary);
				
				
			}
			System.out.println("급여 합계 : " + sum + "원" );
		} catch (SQLException e) { // DB연결관련 예외의 최상위 부모 
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("라이브러리 미등록 또는 경로 오타");
			e.printStackTrace();
		}
		
		
		
	}

}
