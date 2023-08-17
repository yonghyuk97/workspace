package edu.kh.community.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.community.board.model.service.BoardService;
import edu.kh.community.board.model.vo.BoardDetail;
import edu.kh.community.board.model.vo.BoardImage;
import edu.kh.community.common.MyRenamePolicy;
import edu.kh.community.common.Util;
import edu.kh.community.member.model.vo.Member;

// 컨트롤러 : 요청에 따라 알맞은 Service를 호출하고 결과에 따라 응답을 제어
@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String mode = req.getParameter("mode"); // Insert / update 구분
			
			// insert는 별도 처리 없이 jsp로 위임
			
			// update는 기존 게시글 내용을 조회하는 처리가 필요함
			if(mode.equals("update")){
				
				int boardNo = Integer.parseInt(req.getParameter("no"));
				
				// 게시글 상세조회 서비스를 이용해서 기존 내용 조회
				// ( new BoardService() : 객체를 생성해서 변수에 저장 X -> 1회성 사용 )
				
				
				BoardDetail detail = new BoardService().selectBoardDetail(boardNo);
				
				// 개행문자 처리 해제 (<br> -> \n )
				detail.setBoardContent(detail.getBoardContent().replaceAll("<br>", "\n"));
				
				req.setAttribute("detail", detail); // jsp에서 사용할 수 있도록 req에 값 세팅
				
			}
			
			String path = "/WEB-INF/views/board/boardWriteForm.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// insert/update 구분 없이 전달 받은 파라미터 모두 꺼내서 정리하기
			
			// *** enctype="multipart/form-data" 인코딩 미지정 형식의 요청 ***
			// -> HttpServletRequest로 파라미터 얻어오기 불가능!
			// --> MultipartRequest를 이용(cos.jar 라이브러리 제공)
			// ---> 업로드 최대 용량, 저장 실제 경로, 파일명 변경 정책, 문자 파라미터 인코딩 설정
			
			int maxSize = 1024 * 1024 * 100; // 업로드 최대 용량
									
			HttpSession session = req.getSession(); // session 얻어오는 것은 지장 없음(사용 가능)
			String root = session.getServletContext().getRealPath("/"); //webapp폴더까지 경로
			String folderPath = "/resources/images/board/";	// 파일 저장 폴더 경로
			String filePath = root + folderPath;
			
			String encoding = "UTF-8"; // 파라미터 중 파일 제외 파라미터(문자열)의 인코딩 지정
		
			// ** MultipartRequest 객체 생성 **
			// -> 객체가 생성됨과 동시에 파라미터로 전달된 파일이 지정된 경로에 저장(업로드) 된다!
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
			
			// MultipartREqiest.getFileNames()
			// - 요청 파라미터 중 모든 file 타입 태그의 name 속성 값을 얻어와
			//   Enumeration 형태로 반환 (Iterator의 과거 버전)
			//	 --> 해당 객체에 여러 값이 담겨 있고 이를 순서대로 얻어오는 방법을 제공
			//		 (보통 순서가 없는 모음(Set과 같은 경우)에서 하나씩 꺼낼 때 사용)
			
			Enumeration<String> files = mpReq.getFileNames();
			// file 타입 태그의 name 속성 0,1,2,3,4가 순서가 섞인 상태로 얻어와짐
			
			
			// * 업로드된 이미지의 정보를 모아둘 List 생성
			List<BoardImage> imageList = new ArrayList<BoardImage>();
			
			while(files.hasMoreElements() ) { // 다음 요소가 있으면 true   // rs.next()랑 비슷한 친구
				String name = files.nextElement();
				
				// System.out.println("name : " + name);
				// file 타입 태그의 name 속성 값이 얻어와짐
				// + 업로드가 안된 file 타입 태그이 name도 얻어와짐
				
				String rename = mpReq.getFilesystemName(name); // 변경된 파일명
				String original = mpReq.getOriginalFileName(name); // 원본파일명
				
				// System.out.println("rename : " + rename);
				// System.out.println("original : " + original);
				
				if(rename != null /*original != null도 가능*/) { // 업로드된 파일이 있는 경우 == 
									 // 현재 files에서 얻어온 name속성을 이용해
									 // 원본 또는 변경을 얻어왔을 때 그 값이 null이 아닌 경우
					
					// 이미지 정보를 담은 객체(BoardImage)를 생성
					BoardImage image = new BoardImage();
					
					image.setImageOriginal( original ); // 원본명 (다운로드 시 사용)
					image.setImageReName( folderPath + rename ); // 폴더 경로 + 변경명 
					image.setImageLevel( Integer.parseInt(name) ); // 이미지 위치(0번 썸네일)
					
					imageList.add(image); // 리스트에 추가
				} // if문 끝
				
			}// while문 끝
			
			// * 이미지를 제외한 게시글 관련 정보 *
			String boardTitle = mpReq.getParameter("board-title");
			String boardContent = mpReq.getParameter("boardContent");
			int boardCode = Integer.parseInt( mpReq.getParameter("type") ); // hidden
			
			Member loginMember = (Member)(session.getAttribute("loginMember"));
			int memberNo = loginMember.getMemberNo(); // 회원 번호
			
			// 게시글 관련 정보를 하나의 객체(BoardDetail)에 담기
			BoardDetail detail = new BoardDetail();
			
			detail.setBoardTitle(boardTitle);
			detail.setBoardContent(boardContent);
			detail.setMemberNo(memberNo);
			// boardCode는 별도 매개변수로 전달 예정
			
			// --------------------------- 게시글 작성에 필요한 기본 파라미터 얻어오기 끝 ---------------
			
			BoardService service = new BoardService();
			
			// 모드(insert/update)에 따라서 추가 파라미터 얻어오기 및 서비스 호출
			String mode = mpReq.getParameter("mode"); // hidden
			
			if(mode.equals("insert")) { // 삽입
				
				// 게시글 삽입 서비스 호출 후 결과 반환 받기
				// -> 반환된 게시글 번호를 이용해서 상세조회로 리다이렉트 예정
				int boardNo = service.insertBoard(detail, imageList, boardCode);
				
				String path = null;
				
				if(boardNo > 0) { // 성공
					session.setAttribute("message", "게시글이 등록되었습니다.");
					
					path ="detail?no="+ boardNo + "&type=" + boardCode;
					
				}else { // 실패
					session.setAttribute("message", "게시글 등록 실패");
					
					path ="write?mode=" + mode + "&type=" + boardCode;
				}
				
				resp.sendRedirect(path); // 리다이렉트
			}
			
			if(mode.equals("update")) { // 수정
				// 앞선 코드는 동일(업로드된 이미지 저장, imageList 생성, 제목/내용 파라미터 동일
				
				// + update일 떄 추가된 내용
				// 어떤 게시글을 수정? -> 파라미터 no
				// 나중에 목록으로 버튼 만들 때 사용할 현재 페이지 -> 파라미터 cp 
				// 이미지 중 x버튼을 눌러서 삭제할 이미지 레벨 목록 -> 파라미터 deleteList
				int boardNo = Integer.parseInt(mpReq.getParameter("no"));
				
				int cp = Integer.parseInt(mpReq.getParameter("cp"));
				
				String deleteList = mpReq.getParameter("deleteList"); // 1,2,3 지운 이미지의 value
				
				// 게시글 수정 서비스 호출 후 결과 반환
				detail.setBoardNo(boardNo);
				
				// imageList, detail, deleteList
				int result = service.updateBoard(detail,imageList,deleteList);
				
				String path = null;
				String message = null;
				
				if(result > 0 ) { // 성공
					
					// detail?no=1000&type=1&cp=20
					path = "detail?no=" + boardNo + "&type=" + boardCode + "&cp=" + cp;
					
					message = "게시글이 수정되었습니다.";
					
				
					
				}else { // 실패
					
					// 수정 화면으로 이동
					
					// 상세조회 -> 수정화면 -> 수정 -> (성공)상세조회
					//						 -> (실패)수정화면 
					
					// write?mode=update&type=2&cp=1&no=1525
					path = req.getHeader("referer");
					// referer : HTTP 요청 흔적 ( 요청 바로 이전 페이지 주소 )
					
					message = "게시글이 수정 실패";
					
				}
				
				session.setAttribute("message", message);
				
				resp.sendRedirect(path);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
}
