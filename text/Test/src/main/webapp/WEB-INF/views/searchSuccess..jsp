<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
    tr{
        border:1px solid black;
    }
    td{
        border:1px solid black;
        text-align: center;
    }
    
</style>
</head>
<body>
	 <h1>회원정보</h1>

    <table>
        <tr>
            <td>회원번호</td>
            <td>회원아이디</td>
            <td>회원이름</td>
            <td>회원나이</td>
        </tr>
        <tr>
            <td>${user.memberNo}</td>
            <td>${user.memberId}</td>
            <td>${user.memberName}</td>
            <td>${user.memberAge}</td>
        </tr>
    </table>
    <a onclick="location.href='${contextPath}'">메인페이지로 돌아가기</a>
</body>
</html>