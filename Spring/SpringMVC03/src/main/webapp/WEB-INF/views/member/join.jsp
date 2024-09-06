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

	<c:set var="cpath" value="${pageContext.request.contextPath }" />

	<div class="container">

		<jsp:include page="../common/header.jsp"></jsp:include>

		<div class="panel panel-default">
			<div class="panel-heading">Member</div>
			<div class="panel-body">
				<form action="${cpath}/join.do" method="post">

					<input type="hidden" name="pw" id="pw" value="">

					<table class="table table-bordered table-hover">
						<tr>
							<td style="width: 110px; vertical-align: middle;">아이디</td>
							<td><input type="text" id="id" name="id"
								class="form-control" placeholder="아이디를 입력하세요" maxlength="20"></td>
							<td style="width: 110px;"><button onclick="registerCheck()"
									type="button" class="btn btn-primary">중복확인</button></td>
						</tr>

						<tr>
							<td style="width: 110px; vertical-align: middle;">비밀번호</td>
							<td colspan="2"><input onkeyup="passwordCheck()" id="pw1"
								name="pw1" type="password" class="form-control"
								placeholder="비밀번호를 입력하세요." maxlength="20"></td>
						</tr>

						<tr>
							<td style="width: 110px; vertical-align: middle;">비밀번호 확인</td>
							<td colspan="2"><input onkeyup="passwordCheck()" id="pw2"
								name="pw2" type="password" class="form-control"
								placeholder="비밀번호를 확인하세요." maxlength="20"></td>
						</tr>

						<tr>
							<td style="width: 110px; vertical-align: middle;">이름</td>
							<td colspan="2"><input id="name" name="name" type="text"
								class="form-control" placeholder="이름을 입력하세요." maxlength="20"></td>
						</tr>
						<tr>
							<td colspan="3" align="center"><span id="passMsg"></span> <br>
								<button type="submit" class="btn btn-success">등록</button>
								<button type="reset" class="btn btn-warning">취소</button></td>
						</tr>
					</table>
				</form>
			</div>

			<div class="panel-footer">웹기반 인공지능 Track2(A) - 박병관</div>
		</div>
	</div>


	<!-- 다이얼로그창 (모달) -->
	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content panel-info">
				<div class="modal-header panel-heading">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">메세지 확인</h4>
				</div>
				<div class="modal-body">
					<p id="checkMessage"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>





	<script type="text/javascript">
		function passwordCheck() {

			let pw1 = $("#pw1").val();
			let pw2 = $("#pw2").val();

			if (pw1 != pw2) {
				$("#passMsg").text("비밀번호가 서로 일치하지 않습니다.");
				$("#passMsg").css("color", "red");
			} else {
				$("#passMsg").text("");
				$("#pw").val(pw1);
			}

		}

		function registerCheck() {
			let id = $("#id").val();

			$.ajax({
				url : "${cpath}/registerCheck.do",
				type : "get",
				data : {
					"id" : id
				},
				success : function(data) {

					if (data == 0) {
						$("#checkMessage").text(id + "(은)는 사용 불가능 합니다.");
						$("#checkMessage").css("color", "red");
					} else {
						$("#checkMessage").text(id + "(은)는 사용 가능 합니다.");
						$("#checkMessage").css("color", "blue");
					}

					$("#myModal").modal("show");

				},
				error : function() {
					alert("error");
				}
			});

		}
	</script>
</body>
</html>