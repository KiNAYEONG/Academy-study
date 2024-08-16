<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		EL(Expression Language) : 표현언어
		JSP에서 <%= $> 표현식을 사용하는 것보다 간결하게 사용하는 방법
		EL은 기본적으로 Scope 영역만을 사용한다.
	    내장객체 중 영역을 갖고 있음.(page, request, session, application)
	--%>
	<!--key : name, value = object 모든 클래스의 부모 upcasting -->
	<%
	session.setAttribute("name", "기나영");
	%>
	<!-- 다운캐스팅 (String) -->
	<%--<% String name = (String)session.getAttribute("name"); %> --%>
	<%--<%= name %> --%>
	나의 이름은
	${name}
	입니다.



</body>
</html>