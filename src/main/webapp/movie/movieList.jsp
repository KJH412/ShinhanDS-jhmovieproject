<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" ></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상영 영화</title>
<link rel="shortcut icon" href="${cpath}/static/images/playmovie.png" />
<link rel="stylesheet" href="${cpath}/static/css/style.css">
<link rel="stylesheet" href="${cpath}/static/css/movie.css">
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="inner">
		<div class="movie_list_wrap">
			<h1 class="page_title">전체 상영 영화 목록</h1>
			<p>⭐를 누르면 즐겨찾기 목록에 추가됩니다.</p>
			<div class="search_wrap">
				<input id="movieTitle" type="text" name="movieSearch" value="듄">
	      		<button id="btnMovieSearch" type="submit" class="search_icon">검색</button> 
			</div>
			
			<div id="searchMovieList">
				<ul class="movie_list">
					<c:forEach items="${mlist}" var="movie">
							<li class="movie">
							<div class="movie_poster">
								<img id="poster" src="${cpath}/static/images/poster/${movie.movie_id}.jpg" alt="${movie.movie_id}">
								<span class="star">⭐</span>
							</div>
							<p class="movie_name">${movie.movie_title}</p>
							<p><span>평점</span> ${movie.grade}</p>
							<div class="movieposterBtn_wrap">
								<a href="javascript:#void" class="movie_info_page">영화 정보</a>
								<a href="${cpath}/book/reservation.do">예매하기</a>
							</div>
						</li>
					</c:forEach> 
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function() {
		$("#btnMovieSearch").on("click", movieSearch);
		$(".star").on("click", myMovieUpdate);
		
		$(".movie_info_page").on("click",function(){
			alert("준비중입니다.");
		});
	});
	
	//영화 검색창
	function movieSearch() {
		var movie_title = $("#movieTitle").val();
		
		$.ajax({
			url:"movieList",
			type:"post",
			data:{"movie_title" : movie_title},
			success: function(responseData) {
				$("#searchMovieList").html(responseData);
			},
			error:function(xhr, status, error){
				alert(xhr, status, error); 
			}
		});
		
	}
	//즐겨찾기
	function myMovieUpdate() {
		//영화ID
		var movie_id = $(this).siblings("img").attr("alt");
		console.log(movie_id);
		$.ajax({
			url:"insertMyMovie.do",
			type:"post",
			data:{"movie_id" : movie_id},
			success: function(responseData) {
				alert(responseData)
				location.reload();
			},
			error:function(xhr, status, error){
				alert(xhr, status, error); 
			}
		});
	}
	</script>
</body>
</html>