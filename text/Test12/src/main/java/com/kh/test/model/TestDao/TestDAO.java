package com.kh.test.model.TestDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.test.model.TEST;

public class TestDAO {
	
	public List<TEST> selectList(){
		
		List<TEST> list = new ArrayList<TEST>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(" jdbc:oracle:thin:@192.168.10.3:1521:xe",  "kh",  "kh" );
			
			String sql = "SELECT * FROM TEST";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {
				
				TEST test = new TEST();
				
				test.setSeq(rs.getInt("SEQ"));
				test.setWriter(rs.getString("WRITER"));
				test.setTitle(rs.getString("TITLE"));
				test.setContent(rs.getString("CONTENT"));
				test.setRegdate(rs.getString("REGDATE"));
				
				list.add(test);

			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				if(rs != null)		rs.close();
				if(stmt != null)	stmt.close();
				if(conn != null)	conn.close();
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
				
			}
			
			
		}
		
		return list;
	}

}
