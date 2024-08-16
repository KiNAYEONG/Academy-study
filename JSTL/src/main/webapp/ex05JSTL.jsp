<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--JSTL을 사용하기 위해서는 taglib 지시자 필요-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 변수 생성 위, 아래 완전 똑같음. -->
	<!-- JSTL로 생성한 변수는 scope 영역 안에 저장된다. 따로 지정 안하면 page에 저장됨. -->
	<% session.setAttribute("name", "<script>alert('메롱!');</script>"); %> 
	<%-- <c:set var="name" value="기나영" scope="session"/> --%>
	<%-- 나의 이름 : ${name} --%>
	나의 이름 : 
	${name}
	<%-- <c:out value="${name}"/> --%>
	

</body>
</html>