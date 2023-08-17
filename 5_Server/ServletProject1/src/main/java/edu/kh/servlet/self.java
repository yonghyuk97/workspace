package edu.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class self extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("Id");
		String pw = req.getParameter("password");
	
	resp.setContentType("text/html; charset=UTF-8");
	PrintWriter r =resp.getWriter();	
	
	r.println("<!doctype html>");
	r.println("<html>");
	r.println("<head>");
	r.println("<title>"+id+" 님의 정보</title>");
	r.println("</head>");
	r.println("<body>");
	r.println("<p>아이디는 "+id+"입니다.");
	r.println("비밀번호는 "+ pw +"입니다.");
	r.println("</body>");
	r.println("</html>");
	
	}
}
