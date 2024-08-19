<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setAttribute("id", "호두아빠");
		session.setAttribute("id", "박병관");
		
		// EL 찾는 영역 순서
		// page -> request -> session -> application
	%>
	로그인 한 ID :  ${id} <br> <!-- 기본적으로 페이지에 저장됨. -->
	이름 : ${sessionScope.id} <!-- 같은 이유로 sessionScope써야 session꺼 가져옴.-->
</body>
</html>