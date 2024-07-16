<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" ></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="shortcut icon" href="${cpath}/static/images/playmovie.png" />
    
    <link rel="stylesheet" href="${cpath}/static/css/style.css">
</head>
<body>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" ></c:set>
	
	<jsp:include page="../header.jsp"></jsp:include>
    <div class="login-wrapper">
        <h2>Login</h2>
        <form method="post" action="login.do" id="login-form">
           
            <input type="text" name="userId" placeholder="Id" value="test1"
            pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{4,16}$]" />
         
            <input type="password" name="userPassword" placeholder="Password" value="111" />
           	<p id="loginStateMessage">
           	<c:if test="${loginState == -1 || loginState == -2}">
		   		<p class="login_state_mg">${message}</p>
			</c:if>
           	</p>
            
            <label for="remember-check">
                <input type="checkbox" id="remember-check">아이디저장
            </label>
           
            <input value="login" type="submit" id="btnLogin">
        </form>
    </div>
    <script type="text/javascript">
    	
    </script>
</body>
</html>