<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="cpath" value="${pageContext.request.contextPath}" /> 

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<!-- /만 쓰면 컨택스트패스로 인식 -->
			<a class="navbar-brand" href="${cpath}/">웹기반 인공지능 Track2</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="${cpath}/">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Page 1-1</a></li>
					<li><a href="#">Page 1-2</a></li>
					<li><a href="#">Page 1-3</a></li>
				</ul></li>
			<li><a href="#">Page 2</a></li>
			<li><a href="boardMain.do">Board</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="${cpath}/joinForm.do"><span class="glyphicon glyphicon-user"></span>
					Sign Up</a></li>   <!--cpath 쓰면 상대경로 계산할 필요 X  -->
			<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
		</ul>
	</div>
</nav>
