package edu.kh.test.user.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;

@WebServlet("/search")
public class SelectUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int memberNo = Integer.parseInt(req.getParameter("search"));
		
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String path = null;
		
		HttpSession session = req.getSession();
		
		session.setAttribute("contextPath", req.getContextPath());
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			UserDTO user = UserDAO.searchUser(conn,pstmt,rs,memberNo);
			
			
			if(user.getMemberName() != null ) {
				
				req.setAttribute("user", user);
				path = "/WEB-INF/views/searchSuccess..jsp";
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				dispatcher.forward(req, resp);
				
			}else {
				
				path = "/WEB-INF/views/searchFail.jsp";
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				dispatcher.forward(req, resp);
			}
			
			
			
			}catch (Exception e) {
				
			e.printStackTrace();
			
		}
	
	}
	
}
