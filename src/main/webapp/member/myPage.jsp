<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" ></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="shortcut icon" href="${cpath}/static/images/playmovie.png" />

<link rel="stylesheet" href="${cpath}/static/css/style.css">
<link rel="stylesheet" href="${cpath}/static/css/myPage.css">
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>

	<div class="myinfoBg"></div>
	<div class="myinfoBg2"></div>
	<div class="myinfo_wrap inner">
		<h1>마이페이지</h1>
		<div class="myinfoBox">
			<!-- <img alt="회원사진" src=""> -->
			<div class="myImg"></div>
			<h2 class="user_name">${memberLogin.user_name}</h2>	
			<p>${memberLogin.user_age}</p>
			<a href="${cpath}/auth/logout.do">로그아웃</a>
		</div>
		<div class="myMovie_wrap">
			<ul>
				<h2 class="myPage_subTitle">나의 예매 내역</h2>
				<li>
					<table border="1" class="myMovie_table">
						<thead>
							<th>예약번호</th>
							<th>날짜</th>
							<th>상영시간</th>
							<th>영화제목</th>
							<th>예매 취소</th>
						</thead>
						<tbody>
							<c:choose>
						    <c:when test="${empty booklist}">
						        <tr>
						            <td colspan="5">예매 정보가 없습니다.</td>
						        </tr>
						    </c:when>
						    <c:otherwise>
						        <c:forEach items="${booklist}" var="book">
						            <tr>
						                <td class="bookId_td">
						                    <input id="bookId" class="bookId_input" name="book_id" value="${book.book_id}" readonly="readonly">
						                </td>
						                <td class="book_time_txt">
						                    ${book.book_time}
						                </td>
						                <td>
						                    ${book.start_time}
						                </td>
						                <td class="movie_titme_txt">
						                    ${book.movie_title}
						                </td>
						                <td>
						                    <button id="delete_btn" class="delete_btn" onclick="f_delete_btn(${book.book_id})" >예매 취소</button>
						                </td>
						            </tr>
						        </c:forEach>
						    </c:otherwise>
						</c:choose>
						</tbody>
					</table>
				</li>
			</ul>
			<ul>
				<h2 class="myPage_subTitle">기대 하는 영화 목록</h2>
				<c:choose>
			        <c:when test="${empty likeMovieList}">
			            <li class="my_list_empty">즐겨 찾기 한 영화가 없습니다. 
			            <a href="${cpath}/movie/movieList">영화 보러 가기</a>
			            </li>
			        </c:when>
			        <c:otherwise>
			            <li>
			                <ul class="mymovie">
			                    <c:forEach items="${likeMovieList}" var="movie">
			                        <li class="mymovie_list">
			                            <div class="mymovie_poster">
			                                <img src="${cpath}/static/images/poster/${movie.movie_id}.jpg" alt="${movie.movie_title}">
			                                <span onclick="f_delete_mymovie(${memberLogin.mcode},${movie.movie_id})">X</span>
			                            </div>
			                            <div class="mymovie_info">
			                                <p class="mymovie_name">${movie.movie_title}</p>
			                                <a href="${cpath}/book/reservation.do">예매</a>
			                            </div>
			                        </li>
			                    </c:forEach> 
			                </ul>
			            </li>
			        </c:otherwise>
			    </c:choose>
			</ul>
		</div>
	</div>

	<script type="text/javascript">
	$(function() {
		
	});
	//즐겨찾는 영화 삭제
	function f_delete_mymovie(mCode, movieId) {
		console.log(mCode,movieId);
		$.ajax({
			url:"deleteMyMovie.do",
			data : {"mCode" :mCode, "movieId":movieId},
			type : "post",
			success : function (resposeData) {
				alert(resposeData);
				location.reload();
			},
			
			error : function (data) {
				alert(data);
			}
		});
	}
	//예매 삭제
	function f_delete_btn(bid) {
		console.log(bid);
		$.ajax({
			url:"deleteReserve.do",
			data : {"bookId" :bid},
			type : "post",
			success : function (resposeData) {
				alert(resposeData);
				location.reload();
			},
			
			error : function (data) {
				alert(data);
			}
		});
	}
	</script>
</body>
</html>