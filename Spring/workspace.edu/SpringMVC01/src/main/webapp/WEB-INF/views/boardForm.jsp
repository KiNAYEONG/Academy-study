<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<form action="boardInsert.do" method="post">
					<table class="table">
						<tr>
							<td>제목</td>
							<td><input type="text" name="title" class="form-control"</td>
						</tr>
						<tr>
							<td>내용</td>
							<!--textarea는 절대 빈공간 주면 안됨 그것도 문자로 인식해버림!!!  -->
							<td><textarea name="content" class="form-control" rows="7"
									cols=""></textarea></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input type="text" name="writer" class="form-control"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<button type="submit" class="btn btn-success">등록</button>
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