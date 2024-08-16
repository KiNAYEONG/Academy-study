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
	<c:set var = "money" value ="15000"/>
	<c:set var = "menu" value ="100"/>

	<c:if test="${money > 10000 }">
		짬뽕을 시킨다
	</c:if>
	<br>
	
	<c:choose>
		<c:when test="${menu == 1}">
			아이스 아메리카노
		</c:when>
		<c:when test="${menu == 2 }">
			카라멜 마끼야또
		</c:when>
		<c:when test="${menu == 3 }">
			카푸치노
		</c:when>
		<c:otherwise>
			안시킬래요
		</c:otherwise>
	</c:choose>


</body>
</html>