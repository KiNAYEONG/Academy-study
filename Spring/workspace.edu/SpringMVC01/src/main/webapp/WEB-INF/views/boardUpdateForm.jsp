<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				<form action="boardUpdate.do" method="post">
					<input type="hidden" name="idx" value="${vo.idx}">
					<table class="table">
						<tr>
							<td>제목</td>
							<td><input value="${vo.title}" class="form-control"
								type="text" name="title"></td>
						</tr>
						<tr>
							<td>내용</td>
							<!-- 내용은 textarea를 써준다. 줄바꿈 된 값은 알아서 줄바꿈해줌. br태그 필요X -->
							<td><textarea name="content" class="form-control" rows="7"
									cols="">${vo.content}</textarea></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input value="${vo.writer}" class="form-control"
								type="text" name="writer"></td>

						</tr>
						<tr>
							<td>작성일</td>
							<td>${fn:split(vo.indate, " ")[0]}</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button type="submit" class="btn btn-danger">수정</button>
								<button type="reset" class="btn btn-warning">취소</button> 
								<a href="boardList.do" class="btn btn-info">목록</a>
							</td>
						</tr>
					</table>
				</form>

			</div>
			<div class="panel-footer">웹기반 인공지능 Track2(A) - 기나영</div>
		</div>
	</div>
</body>
</html>