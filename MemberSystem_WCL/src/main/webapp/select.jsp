<%@page import="com.aischool.model.WebMember"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	ArrayList<WebMember> members 
					=(ArrayList<WebMember>)request.getAttribute("getMembers");
	System.out.print(members.size());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body style="text-align: center;">
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>회원관리페이지</h2></caption>
							<tr>
								<td>Email</td>
								<td>Tel</td>
								<td>Address</td>							
							</tr>
							<!-- 2.모든 회원의 이메일(email),전화번호(tel),주소(address)를 출력하시오. -->
						      <%
                        if(!members.isEmpty()) {        
                           for(int i = 0; i < members.size(); i++) {
                        	 if(!members.get(i).getEmail().equals("admin")){
	                              out.print("<tr>");
	                              out.print("<td>" + members.get(i).getEmail() + "</td>");
	                              out.print("<td>" + members.get(i).getTel() + "</td>");
	                              out.print("<td>" + members.get(i).getAddress() + "</td>");
	                              out.print("<td><a href='MemberDeleteService?email="+members.get(i).getEmail()+"'>삭제</a></td>");
	                              
	                              out.print("<tr>");
                        	   }
                           }
                        }
                     %>
						</table>
					</nav>		
					<a href="index.jsp" class="button next scrolly">되돌아가기</a>	
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
	</body>
</html>

