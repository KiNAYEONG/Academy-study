<%@page import="com.MemberVO"%>
<%@page import="java.util.ArrayList"%>
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

	<%
	 	ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		//1.객체 만들고
		MemberVO m1 = new MemberVO("박병관","010-1111-2222");
		MemberVO m2 = new MemberVO("기나영","010-1221-2222");
		MemberVO m3 = new MemberVO("이연주","010-1133-2222");
		//2.리스트에 추가하고
		list.add(m1);
		list.add(m2);
		list.add(m3);
		//3.arraylist에 추가하기
		session.setAttribute("list",list);
	%>
	
	<!--  list에 있는 내용이 vo에 저장됨. -->  -->
	<c:forEach items="${list}" var = "vo">
		${vo.name} : ${vo.phone}<br>
		<!--vo.get Name을 통해서 꺼내옴.  -->
	</c:forEach>

</body>
</html>