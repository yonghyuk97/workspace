package edu.kh.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//Tomcate(WAS==Servlet Container)에서 제공 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//WebServlet("요청주소") : Servlet 클래스 등록 + 요청 주소 매핑
@WebServlet("/signUp")

//Servlet : 웹서비스(요청,응답)를 위한 자바 클래스
public class SignUpServlet extends HttpServlet{

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      // *** POST 방식의 한글 깨짐 문제 ***
      // - 데이터 전달 방식 차이점 
      // GET  : 주소(URL)를 통해서 데이터가 전달
      //       이때, 문자 인코딩은 제출된 HTML 파일의 문자 인코딩(charset)을 따름 
      
      // POST : HTTP Body를 통해서 데이터 전달
      //        이 때, 문자 인코딩은 서버의 기본 문자 인코딩을 따름 
      //         우리 서버(Tomcat) -> ISO-8859-1이 기본 문자 인코딩 
      
      // * 해결 방법 * 
      // - POST 방식으로 전달 받은 데이터의 문자 인코딩을 변경
      req.setCharacterEncoding("UTF-8");
      // -> 문자 인코딩을 UTF-8로 변경 
      // -> 한글이 깨지지 않음 

      
      String memberId = req.getParameter("memberId"); 
      String message = memberId + "님의 가입을 환영합니다!";
      
      //클라이언트 연결된 출력 스트림을 이용해서 응답 화면 출력
//      PrintWriter out = resp.getWriter();
//      out.println("<!DOCTYPE html>");
//      out.println("<html>");
//      // ...
//      out.println("</html>");
      
      //Servlet으로 응답 화면 만들기 너무 어렵다ㅠㅠ
      //-> 응답화면 만드는 부분의 표기법만 HTML 로 변경하자!
      //--> 이것이 JSP!!
      //     (눈에 보이는 코드는 HTML,해석은 Java)
      
      //Servlet -> RequestDispatcher -> forward(req,resp) -> JSP
      //              (요청 발송자)         (전송)
      
      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUpResult.jsp");
            //JSP 경로 작성 시 webapp 폴더를 기준으로 작성 
      
      //HttpServletRequest 객체에 message 변수 값 추가 
      req.setAttribute("msg", message);
      dispatcher.forward(req, resp);
      
      
   }
   
}