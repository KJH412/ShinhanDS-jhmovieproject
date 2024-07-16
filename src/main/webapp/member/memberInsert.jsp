<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath"
	value="${pageContext.request.servletContext.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="shortcut icon" href="${cpath}/static/images/playmovie.png" />
<link rel="stylesheet" href="${cpath}/static/css/style.css">
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="join-wrapper">
		<h1 class="page_title">회원가입</h1>
		<form method="post" action="join" id="join-form">
			<label for="">아이디 :</label> 
			<input type="text" name="userId"
				placeholder="Id" id="userIdCheck" required="required">
			<%-- 아이디 중복체크  --%>
			<input type="button" id="btnIdCheck" value="중복체크">
			<span id="idCheckMg"></span>
			</br>
			<label for="userPassword">비밀번호 :</label> 
			<input type="password" name="userPassword" placeholder="Password">
			</br>
			<label for="userName">이름 :</label> 
			<input type="text" name="userName" placeholder="Number"> 
			</br>
			<label for="userPhone">휴대번호 :</label> 
			<input type="text" name="userPhone" placeholder="Phone"> 
			</br><label
			for="userBirth">생년월일 :</label> 
			<input type="date" name="userBirth"> 
			<div class="join_btn_wrap">
				<input	value="회원가입" type="submit" id="btnJoin" class="join_btn">
			</div>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			//ID중복 체크
			$("#btnIdCheck").on("click", f_idCheck);
		});
		function f_idCheck() {
			var userid = $("#userIdCheck").val();
			if (userid == "") {
				document.querySelector("#userIdCheck").focus();
				return;
			}
			//Ajax-DB연결
			$.ajax({
				url : "userIdCheck.do",
				data : {
					"userid" : userid
				},
				type : "get",
				success : function(responseData) {
					//alert(responseData);
					var message = "";
					//이미 있는 id와 같을 때 사용가능
					if (responseData == "0") {
						message = "사용가능한 아이디입니다.";
					} else {
						message = "사용 불가능한 아이디";
						$("#userIdCheck").val("");
						document.querySelector("#userIdCheck").focus();
					}
					
					$("#idCheckMg").text(message);
				},
				error : function(data) {
					alert(data);
				}
	
			});
		}
	</script>


</body>
</html>