<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% pageContext.setAttribute("ln", "\n"); %>


	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">Board</div>
			<div class="panel-body">				
					<table class="table">
						<tr>
							<td>제목</td>
							<td><c:out value="${vo.title}" /></td>						
						</tr>
						<tr>
							<td>내용</td>
							<td><!--엔터는 <br>태그를 넣어줘서 엔터로 만들어준다.  -->
							${fn:replace(vo.content, ln,"<br>") }
							</td>							
						</tr>
						<tr>
							<td>작성자</td>
							<td><c:out value="${vo.writer}" /></td>
							<td></td>
						</tr>
						<tr>
							<td>작성일</td>
							<td><!--fn 쓰려면 태그라이브러리 필요.  -->
							${fn:split(vo.indate, " ")[0]} <!-- 쉼표 기준으로 나눠진 배열의 1번째 가져올거니까 0 -->
							</td>
							<td></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<a href="boardUpdateForm.do?idx=${vo.idx}" class="btn btn-warning">수정</a>
							<a href="boardDelete.do?idx=${vo.idx}" class="btn btn-danger">삭제</a>
							<a href="boardList.do" class="btn btn-info">목록</a>
							</td>
						</tr>
					</table>
				
				
			</div>
			<div class="panel-footer">웹기반 인공지능 Track2(A) - 기나영</div>
		</div>
	</div>
</body>
</html>