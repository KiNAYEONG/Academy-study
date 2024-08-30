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
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">Board</div>
			<div class="panel-body">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
					</thead>
					<tbody>
						<!-- 게시글 내용 출력하기 -->
					</tbody>
					<c:forEach varStatus="i" var="vo" items="${list}" >
						<tr>
						<!--varStatus를 써서 삭제되어도 숫자가 이어지게 함.  -->
							<td><c:out value="${i.count}" /></td>						
							<td>
							<a href="boardContent.do?idx=${vo.idx}">
							<!--get방식으로 보내는 쿼리스트링 ?id값 띄어쓰기 절대 안돼!  -->
							<c:out value="${vo.title}" />
							</a>				
							</td> 
							<td><c:out value="${vo.writer}" /></td> 
							<td>
							${fn:split(vo.indate, " ")[0]}
							</td>
							<td><c:out value="${vo.count}" /></td>							
						</tr>
						<!--vo.get Name을 통해서 꺼내옴.  -->
					</c:forEach>
				</table>

				<a href="boardForm.do" class="btn btn-primary">글쓰기</a>

			</div>
			<div class="panel-footer">웹기반 인공지능 Track2(A) - 기나영</div>
		</div>
	</div>
</body>
</html>