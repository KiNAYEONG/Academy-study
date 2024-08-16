<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:forEach var="i" begin="1" step="1" end="10">
		${i}<br>
	</c:forEach>
	
	
	<c:set var = "sum" value ="0"/>
	<c:forEach var="i" begin="1" step="1" end="100">
		<c:set var = "sum" value ="${sum+i}"/>
	</c:forEach><br>
	<br>
	1부터 100까지의 총합은 = <c:out value="${sum}"/>
</body>
</html>