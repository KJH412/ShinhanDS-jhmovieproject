<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" ></c:set>

<ul class="movie_list">
	 <c:forEach items="${mlist}" var="movie">
		<li class="movie">
			<div class="movie_poster">
				<img src="${cpath}/static/images/poster/${movie.movie_id}.jpg" alt="${movie.movie_title}">
				<span class="star">⭐</span>
			</div>
			<p class="movie_name">${movie.movie_title}</p>
			<p><span>평점</span> ${movie.grade}</p>
			<div class="movieposterBtn_wrap">
				<a href="movieDetail">영화 정보</a>
				<a href="reservation.do">예매하기</a>
			</div>
		</li>
	</c:forEach>
</ul>