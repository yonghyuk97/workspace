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
	 <h1>ȸ������</h1>

    <table>
        <tr>
            <td>ȸ����ȣ</td>
            <td>ȸ�����̵�</td>
            <td>ȸ���̸�</td>
            <td>ȸ������</td>
        </tr>
        <tr>
            <td>${user.memberNo}</td>
            <td>${user.memberId}</td>
            <td>${user.memberName}</td>
            <td>${user.memberAge}</td>
        </tr>
    </table>
    <a onclick="location.href='${contextPath}'">������������ ���ư���</a>
</body>
</html>