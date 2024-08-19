<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">WebSiteName</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Page 1</a></li>
					<li><a href="#">Page 2</a></li>
					<li><a href="#">Page 3</a></li>
				</ul>
			</div>
		</nav>
		<div class="jumbotron">
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">로그인</div>
			<div class="panel-body">

				<form action="LoginService" method="post">
					<div class="form-group">
						<label for="email">ID:</label> 
						<input name="id" type="text" class="form-control" id="email">
					</div>
					<div class="form-group">
						<label for="pwd">PW:</label> 
						<input name="pw" type="password" class="form-control" id="pwd">
					</div>
					<button type="reset" class="btn btn-info">RESET</button>
					<button type="submit" class="btn btn-warning">LOGIN</button>
				</form>

			</div>
			<div class="panel-footer">웹기반 인공지능 Track2 (A) - 기나영</div>
		</div>
	</div>

</body>
</html>