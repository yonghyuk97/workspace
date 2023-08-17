package kkk.member.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kkk.member.service.MemberService;
import kkk.member.vo.Member;

@WebServlet("/login.do")
public class Servlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		String Id = req.getParameter("id");
		String pw = req.getParameter("pwd");
		
		Member member = new Member();
		member.setId(Id);
		member.setPwd(pw);
		
		MemberService service = new MemberService();
		String path = null;
		
		
		try {
			
			Member mem = service.login(member);
			
			if(mem != null) {
				
				path = req.getContextPath();
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				dispatcher.forward(req, resp);
				
			}else {
				
				path = "/WEB-INF/views/common/errorPage.jsp";
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				dispatcher.forward(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
