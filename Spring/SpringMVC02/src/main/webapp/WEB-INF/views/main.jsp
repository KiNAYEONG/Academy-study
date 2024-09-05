,.,<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	  <div class="panel panel-default">
	    <div class="panel-heading">Board</div>
	    <div class="panel-body" id="list"><!--글쓰기 버튼 눌렀을 때 사라지게 만드려고 id 생성  -->
	    	<table class="table table-bordered table-hover">
	    		<thead> <!-- 제목과 본문을 구분하기 위한 태그[제목] -->
	    			<tr>
	    				<td>번호</td>
	    				<td>제목</td>
	    				<td>작성자</td>
	    				<td>작성일</td>
	    				<td>조회수</td>
	    			</tr>
	    		</thead>
	    		<tbody id="view"><!-- 제목과 본문을 구분하기 위한 태그[본문] -->
	    		</tbody>
	    	</table><!-- onclick 클릭감지하면 goForm 함수 작동시켜서 글쓰기 폼 보여준다. -->
	    	<button onclick="goForm()" class="btn btn-info">글쓰기</button>
	    </div>
	    
	    
	    <!-- 글쓰기 폼 --><!-- 글 작성할 때만 보이게 하려고 display : none 씀. -->
	    <div class="panel-body" id="wform" style="display: none;">
	    	<form id="frm">
	    		<table class="table">
	    			<tr>
						<td>제목</td>	    	
						<td><input type="text" name="title" class="form-control"></td>
	    			</tr>
	    			<tr>
	    				<td>내용</td>
	    				<td><textarea name="content" class="form-control" rows="7" cols=""></textarea></td>
	    			</tr>
	    			<tr>
	    				<td>작성자</td>
	    				<td><input type="text" name="writer" class="form-control" ></td>
	    			</tr>
	    			<tr>
						<td colspan="2" align="center">
							<button onclick="goInsert()" type="button" class="btn btn-success">등록</button>
							<button id="fclear" type="reset" class="btn btn-warning">취소</button>
							<button type="button" class="btn btn-info" onclick="goList()">리스트</button>
						</td>	    			
	    			</tr>
	    		</table>
	    	
	    	</form>
	    </div>
	    <div class="panel-footer">웹기반 인공지능 Track2(A) - 박병관</div>
	  </div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){ // HTML 다 로드되고 JS를 적용하겠다
			loadList();
		}); // ready함수 종료부분
		
		function loadList(){
			// 게시판 리스트 가져오는 기능
			
			// ajax : 비동기 요청을 할 수 있는 기능(함수)
			// 요청사항을 매개변수 안에 객체(JSON) {url : ""} 형태로 작성
			$.ajax({
				url : "board/all",
				type : "get",
				dataType : "json",
				success : makeView,
				error : function() { alert("error"); }
			});
		}
		
		function makeView(data){
			// ajax 게시글 목록 요청 성공시 실행되는 함수, 콜백함수
			console.log(data);
			
			let listHtml = "";
			/*J쿼리의 반복문 data에서 하나씩 꺼내서 vo에 담는다. index : for문의 반복횟수를 기억 */
			$.each(data, function(index, vo){
				listHtml += "<tr>";
				listHtml += "<td>" + (index + 1) + "</td>";
				listHtml += "<td id='t"+vo.idx+"'><a href='javascript:goContent("+vo.idx+")'>";
				listHtml += vo.title + "</a></td>";
				listHtml += "<td id='w"+vo.idx+"'>" + vo.writer + "</td>";
				listHtml += "<td>" + vo.indate + "</td>";
				listHtml += "<td>" + vo.count + "</td>";
				listHtml += "</tr>";
				
				// 상세보기
				listHtml += "<tr id='c"+ vo.idx +"' style='display:none;'>";
				listHtml += "<td>내용</td>";
				listHtml += "<td colspan='4'>";
				listHtml += "<textarea id='ta"+ vo.idx +"' readonly rows='7' class='form-control'>";
				// listHtml += vo.content;
				listHtml += "</textarea>";
				
				// 수정 삭제
				listHtml += "<br>";
				listHtml += "<span id='ub"+vo.idx+"'>";
				listHtml += "<button onclick='goUpdate("+vo.idx+")' class='btn btn-warning'>수정화면</button>&nbsp;";
				listHtml += "</span>";
				listHtml += "<button onclick='goDelete("+vo.idx+")' class='btn btn-danger'>삭제</button>";
				
				listHtml += "</td>";
				listHtml += "</tr>";
				
			});		
			$("#view").html(listHtml);/*불러온 게시글 적용  */
			goList();
		}
		
		function goForm(){
			$("#list").css("display", "none");/* 안보이게! */
			$("#wform").css("display", "block");/* 보이게! */
		}
		
		function goList(){
			$("#list").css("display", "block");
			$("#wform").css("display", "none");
		}
		
		function goInsert(){
			// title="안녕"&content="반가워"&writer="ㅇㅇㅇ"
			let fData = $("#frm").serialize();
			console.log(fData);
			
			$.ajax({
				url : "board/new",
				type : "post",
				data : fData,
				success : loadList,
				error : function() { alert("error"); }
			});
			
			$("#fclear").trigger("click");
			
		}
		
		function goContent(idx){
			if($("#c"+idx).css("display") == "none"){
				
				$.ajax({
					url : "board/" + idx,
					type : "get",
					dataType : "json",
					success : function(data){
						console.log(data);
						$("#ta"+idx).val(data.content);
					},
					error : function() { alert("error"); }
				});
				
				$("#c"+idx).css("display", "table-row");
				
			}else{
				$("#c"+idx).css("display", "none");
				
				$.ajax({
					url : "board/"+idx,
					type : "put",				
					success : loadList,
					error : function() { alert("error"); }
				});
				
			}
		}
		
		function goDelete(idx){
			$.ajax({
				url : "board/"+idx,
				type : "delete",				
				success : loadList,
				error : function() { alert("error"); }
			});
		}
		
		function goUpdate(idx){
			$("#ta"+idx).attr("readonly", false);
			
			let title = $("#t"+idx).text();
			let writer = $("#w"+idx).text();
			
			let nTitle = "<input id='nt"+idx+"' value='"+title+"' type='text' class='form-control'>";
			let nWriter = "<input id='nw"+idx+"' value='"+writer+"' type='text' class='form-control'>";
			
			$("#t"+idx).html(nTitle);
			$("#w"+idx).html(nWriter);
			
			let nButton = "<button onclick='goUpdatedo("+idx+")' class='btn btn-primary'>수정</button> &nbsp;";
			$("#ub"+idx).html(nButton);
		}
		
		function goUpdatedo(idx){
			
			let title = $("#nt"+idx).val();
			let content = $("#ta"+idx).val();
			let writer = $("#nw"+idx).val();
			
			$.ajax({
				url : "board/update",
				type : "put",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify({"idx" : idx, "title" : title, "content" : content, "writer" : writer}),
				success : loadList,
				error : function() { alert("error"); }
			});
			
		}
		
	
	
	</script>
	
	
</body>
</html>





<!--  
게시판 전체조회 
/board/list - get
게시글 전체삭제
/board/list - post
게시글 전체수정
/board/list - put
게시글 잠금
/board/list -delete

rest control처럼 상태를 전송하는 게 보안이 더 좋다.
-->




