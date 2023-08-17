package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.kh.test.user.model.vo.UserDTO;

public class UserDAO {

	public static UserDTO searchUser(Connection conn, PreparedStatement pstmt, ResultSet rs, int memberNo) throws Exception{
		
		UserDTO user = new UserDTO();
		
		try {
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","realsemi_CYH","realsemi1234");	
			
			String sql = "SELECT USER_NO, USER_ID, USER_NAME, USER_AGE FROM TB_USER WHERE USER_NO = ? ORDER BY USER_NO";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				user.setMemberNo(rs.getInt("USER_NO"));
				user.setMemberId(rs.getString("USER_ID"));
				user.setMemberName(rs.getString("USER_NAME"));
				user.setMemberAge(rs.getInt("USER_AGE"));
					
			}
			
		} finally {
			
			rs.close();
			pstmt.close();
			conn.close();	
			
		}

		return user;
	}


}


