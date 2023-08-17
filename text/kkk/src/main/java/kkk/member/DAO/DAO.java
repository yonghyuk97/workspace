package kkk.member.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kkk.member.vo.Member;

public class DAO {

	
	public static Member login(Connection conn, Member member) throws Exception {
		
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member mem  = null;
		
		try {
			String sql = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2,member.getPwd());
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				mem.setId(rs.getString("USER_ID"));
				mem.setPwd(rs.getString("USER_PWD"));
				mem.setName(rs.getString("USER_NAME"));
				mem.setPhone(rs.getString("PHONE "));
				
			}
			
		} finally {
			rs.close();
			pstmt.close();
		}
		
		
		return mem;
	}

}
