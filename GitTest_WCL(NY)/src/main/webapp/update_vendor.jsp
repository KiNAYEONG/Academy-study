<%@page import="com.aischool.model.WCLMember_Vendor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    WCLMember_Vendor member = (WCLMember_Vendor) session.getAttribute("loginM");
    if (member == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .edit-form { 
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .edit-form h2 { 
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #5cb85c;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #4cae4c;
        }
    </style>
</head>
<body>
    <div class="edit-form"> 
        <h2>회원정보 수정</h2>
        <form action="UpdateService" method="post">           
            <div class="form-group">
                <label for="vendor_pw">비밀번호:</label>
                <input type="password" id="vendor_pw" name="vendor_pw" value="<%=member.getPw()%>" required>
            </div>
            <div class="form-group">
                <label for="vendor_name">기업명:</label>
                <input type="text" id="vendor_name" name="vendor_name" value="<%=member.getName()%>" required>
            </div>
            <div class="form-group">
                <label for="vendor_tel">전화번호:</label>
                <input type="text" id="vendor_tel" name="vendor_tel" value="<%=member.getTel()%>" required>
            </div>
            <div class="form-group">
                <label for="vendor_email">이메일:</label>
                <input type="email" id="vendor_email" name="vendor_email" value="<%=member.getEmail()%>" required readonly>
            </div>
            <div class="form-group">
                <label for="vendor_postcode">우편번호:</label>
                <input type="text" id="vendor_postcode" name="vendor_postcode" value="<%=member.getPostcode()%>" placeholder="우편번호">
                <input type="button" onclick="vendor_execDaumPostcode()" value="우편번호 찾기"><br>
                <label for="vendor_address">주소:</label>
                <input type="text" id="vendor_address" name="vendor_address" value="<%=member.getAddress()%>" placeholder="주소"><br>
                <label for="vendor_detailAddress">상세주소:</label>
                <input type="text" id="vendor_detailAddress" name="vendor_detailAddress" value="<%=member.getDetailAddress()%>" placeholder="상세주소">
                <label for="vendor_extraAddress">참고항목:</label>
                <input type="text" id="vendor_extraAddress" name="vendor_extraAddress" value="<%=member.getExtraAddress()%>" placeholder="참고항목">
            </div>
            <div class="form-group">
                <button type="submit">수정 완료</button>
            </div>
        </form>
    </div>

    <!-- 주소 API -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        function vendor_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    var addr = ''; 
                    var extraAddr = ''; 

                    if (data.userSelectedType === 'R') { 
                        addr = data.roadAddress;
                    } else { 
                        addr = data.jibunAddress;
                    }

                    if(data.userSelectedType === 'R'){
                        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                            extraAddr += data.bname;
                        }
                        if(data.buildingName !== '' && data.apartment === 'Y'){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        if(extraAddr !== ''){
                            extraAddr = ' (' + extraAddr + ')';
                        }
                        document.getElementById("vendor_extraAddress").value = extraAddr;
                    } else {
                        document.getElementById("vendor_extraAddress").value = '';
                    }

                    document.getElementById('vendor_postcode').value = data.zonecode;
                    document.getElementById("vendor_address").value = addr;
                    document.getElementById("vendor_detailAddress").focus();
                }
            }).open();
        }
    </script>
</body>
</html>
