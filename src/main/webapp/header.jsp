<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" ></c:set>

<%-- jquery --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<header>
       <div class="inner">
	       <h1 class="logo" onclick="location.href='${cpath}/'"></h1>
	       <nav>
	         <ul class="menu">
	             <li><a href="${cpath}/book/reservation.do">예매</a></li>
	             <li><a href="${cpath}/movie/movieList">영화</a></li>
	             
	              <c:if test="${empty memberLogin}"> 
	              	<li><a href="${cpath}/auth/login.do">마이페이지</a></li>
	              </c:if>
	              <c:if test="${not empty memberLogin}">
	             	 <li><a href="${cpath}/member/myPage.do">마이페이지</a></li>
	             </c:if>
	             <li class="not"><a href="javascript:#void">고객센터</a></li>
	          </ul>
	          <ul class="loginmenu">
	             <c:if test="${empty memberLogin}"> 
	             	<li><a href="${cpath}/auth/login.do">로그인</a></li>
	          	    <li><a href="${cpath}/member/join">회원가입</a></li>
	             </c:if>
	             <c:if test="${not empty memberLogin}">
	          	   <li><a href="${cpath}/member/myPage.do">${memberLogin.user_name}님</a></li>
	          	   <li><a href="${cpath}/auth/logout.do">로그아웃</a></li>
	             </c:if>
	         </ul>
	       </nav>
       </div>
</header>
<script>
$(function() {
	$(".not").on("click",function(){
		alert("준비중입니다.");		
	});
})
</script>