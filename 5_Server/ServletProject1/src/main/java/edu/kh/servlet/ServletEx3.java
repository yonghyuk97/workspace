package edu.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx3 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("inputId");
		String pw1 = req.getParameter("inputPw1");
		String pw2 = req.getParameter("inputPw2");
		
		String name = req.getParameter("inputName");
		String email = req.getParameter("inputEmail");
		
		String[] color = req.getParameterValues("color");
		
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>회원 정보 제출 결과</title>");
		out.println("</head>");

		out.println("<body>");
		
		if(pw1.equals(pw2)) {
			out.println("<ul>");
			
			out.println("<li>아이디 : "+ id +"</li>");
			out.println("<li>이름 : "+ name +"</li>");
			out.println("<li>이메일 : "+ email +"</li>");
			
			if(color != null) {
				out.println("<li>좋아하는 색 : ");
				for(String c : color) {
					out.println(c + " ");
				}
				out.println("</li>");
				out.println("</ul>");
			}
		}else {
			out.println("<h1>비밀번호가 일치하지 않습니다.</h1>");
		}
		
		
		
		out.println("</body>");
		
		
		out.println("</html>");
	}
	

}
