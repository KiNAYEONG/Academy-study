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
		pageContext.setAttribute("name", "박병관");
		pageContext.setAttribute("name2", "고수");
		pageContext.setAttribute("num", 100);
	%>
 	${num + 10} <br>
 	${num - 50} <br>
 	${num * 2 } <br>
	${num / 2 } ${num div 2}<br>
	${num % 2 } ${num mod 2}<br>


	<hr>
	${num > 50} <br>
	${num > 50 && num <200} ${num > 50 and num < 200 }<br>
	${num >= 100 } ${num ge 100 }${num gt 100 } <br>
	${num <= 100 } ${num le 100 }${num lt 100 } <br>
	${num == 100 } ${num eq 100 } <br>
	${num != 100 } ${num ne 100 } <br>
	
	<hr>
	<% session.setAttribute("love", "호두"); %>
	
	<%= session.getAttribute("love3") %>
	${love3}
	<br>
	${not empty love3}
	
	
	
	
	
	
</body>
</html>