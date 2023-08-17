<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 조회</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>성별</th>
				<th>가입일</th>
				<th>탈퇴여부</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="member" items ="${requestScope.list}" >
			
				<tr>
					<td>${ member.memberNo }</td>
					<td>${ member.memberId }</td>
					<td>${ member.memberPw }</td>
					<td>${ member.memberName }</td>
					<td>${ member.memberGender }</td>
					<td>${ member.enrollDate }</td>
					<td>${ member.secessionFlag }</td>
				</tr>
				
			</c:forEach>
		</tbody>
		
		<!-- <tfoot></tfoot> -->
	</table>	

</body>
</html>