<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" ></c:set>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="1;${cpath}/auth/login.do">
<title>회원가입</title>
<link rel="stylesheet" href="${cpath}/static/css/style.css">
<style type="text/css">
.result_wrap{
	width: 100%;
    margin: 300px 0;
}
.join_text{
	font-size: 40px;
	text-align: center;	
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="result_wrap">
		<h1 class="join_text">${message}</h1>
	</div>
</body>
</html>