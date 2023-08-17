<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 문자열 관련 함수(메소드) 제공 JSTL (EL형식으로 작성) --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>my page</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">

    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">
    
    <script src="https://kit.fontawesome.com/c5332d6cb1.js" crossorigin="anonymous"></script>
</head>

<body>

    <main>
    
       <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <!-- 마이페이지 - 내 정보 -->
        <section class="myPage-content">
        
		 <!-- 사이드메뉴 include -->
         <jsp:include page="/WEB-INF/views/member/sideMenu.jsp"/>

            <!-- 오른쪽 마이페이지 주요 내용 부분 -->
            <section class="myPage-main">

                <h1 class="myPage-title">회원 탈퇴</h1>
                <span class="myPage-explanation">현재비밀번호가 일치하는 경우 탈퇴할 수 있습니다.</span>

				<!-- 
					http://localhost:8080/community/member/myPage/secession (GET)
					http://localhost:8080/community/member/myPage/secession (POST)
				 -->
				
                <form action="secession" method="post" name="myPage-form" onsubmit="return secessionValidate()">

                    <div class="myPage-row">
                        <label>비밀번호</label>
                        <input type="password" name="memberPw" maxlength="30"> 
                    </div>

                    <div class="myPage-row info-title">
                        <label>회원 탈퇴 약관</label>
                    </div>

                    <pre id="secession-terms">
제1조
이 약관은 샘플 약관입니다.

① 약관 내용 1

② 약관 내용 2

③ 약관 내용 3

④ 약관 내용 4


제2조
이 약관은 샘플 약관입니다.

① 약관 내용 1

② 약관 내용 2

③ 약관 내용 3

④ 약관 내용 4                        
                    </pre>

                    <div>
                        <input type="checkbox" name="agree" id="agree">
                        <label for="agree">위 약관에 동의합니다.</label>
                    </div>


                    <button id="info-update-btn">탈퇴</button>
                </form>


            </section>


        </section>

    </main>

 	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <script src="${contextPath}/resources/js/member/myPage.js"></script>

</body>

</html>
</body>
</html>