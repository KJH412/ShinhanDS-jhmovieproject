<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" ></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>영화 홈</title>
    <link rel="shortcut icon" href="${cpath}/static/images/playmovie.png" />
    
    <link rel="stylesheet" href="${cpath}/static/css/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <%-- 슬릭 슬라이더 --%>
	<script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script> 
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
    
    <div id="container" class="inner">
        <div class="mainbanner">
            <ul class="bannerWrap">
                <li>                
                    <div class="bannerImg">
                          <img src="${cpath}/static/images/poster/poster0.png" alt="영화">  
                    </div>
                </li>
                <li>
                    <div class="bannerImg">
                          <img src="${cpath}/static/images/poster/poster3.png" alt="영화"> 
                    </div>
                </li>
            </ul>
        </div>
 		<div class="sub_bannerWrap">
        	<h1>상영 영화 <a href="${cpath}/movie/movieList">전체보기</a></h1>
        	<ul id="sub_banner">
				<li class="sub">
					<img alt="1" src="${cpath}/static/images/poster/1.jpg">
					<p><a href="${cpath}/book/reservation.do">예매하기</a></p>
				</li>
				<li>
					<img alt="2" src="${cpath}/static/images/poster/2.jpg">
					<p><a href="${cpath}/book/reservation.do">예매하기</a></p>
				</li>
				<li>
					<img alt="3" src="${cpath}/static/images/poster/3.jpg">
					<p><a href="${cpath}/book/reservation.do">예매하기</a></p>
				</li>
				<li>
					<img alt="4" src="${cpath}/static/images/poster/4.jpg">
					<p><a href="${cpath}/book/reservation.do">예매하기</a></p>
				</li>
				<li>
					<img alt="5" src="${cpath}/static/images/poster/5.jpg">
					<p><a href="${cpath}/book/reservation.do">예매하기</a></p>
				</li>
				<li>
					<img alt="6" src="${cpath}/static/images/poster/6.jpg">
					<p><a href="${cpath}/book/reservation.do">예매하기</a></p>
				</li>
        	</ul>
        </div> 
    </div>
    <script>
		$(function() {
			$.noConflict(); //제이쿼리 충돌방지
			$(".bannerWrap").slick({
				 rows: 1,                   
			  	 dots: true,  
			  	 autoplay: true,             
			  	 autoplaySpeed: 2000
			});
			$("#sub_banner").slick({
				 slidesToShow: 5,
				 slidesToScroll: 1,
			  	 //dots: true,  
			  	 autoplay: true,             
			  	 autoplaySpeed: 4000
			});
			
		});
	</script>
</body>
</html>