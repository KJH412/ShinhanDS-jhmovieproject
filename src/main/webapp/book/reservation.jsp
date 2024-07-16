<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" ></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>영화 예매</title>
     <link rel="shortcut icon" href="${cpath}/static/images/playmovie.png" />
     <link rel="stylesheet" href="${cpath}/static/css/style.css">
     <link rel="stylesheet" href="${cpath}/static/css/reservation.css">
</head>
<body>
   <jsp:include page="../header.jsp"></jsp:include>
   
<div class="reserveBg">
    <div class="reservation-wrapper">
	    <h1 class="page_title">예매하기</h1>
        <form method="post" action="reservation.do" id="reservationFrm">
        	
       		<%-- 영화 선택 --%>
            <div class="movie_title-wrap">
               <label for="movie_title" class="book_label">영화 선택하기</label>
	            <select id="movie-title" name="movie_id">
	                <c:forEach var="movie" items="${mlist}">
		                <option value="${movie.movie_id}">
		                	${movie.movie_title}
		                </option>
	                </c:forEach>
	            </select>
            </div>
   		    <%-- 선택한 영화 이미지 나타내기 --%>
            <div class="movie_img">
            	<img id="selImg" src="${cpath}/static/images/poster/1.jpg">
            </div>
			
        	
        	<%-- 예매할 날짜 선택 --%>
       		<div class="book_date">
	            <label for="book_time" class="book_label">날짜 선택 : </label>
	            <input type="date" name="book_time" class="book_time_input">
	            
	            <%-- 타임 --%>
	     		<div class="movie_time_wrap">
	     			<label for="movie_time" class="book_label">시간 선택: </label>
		            <select name="movie_time">
		                <option>15시</option>
		                <option>16시</option>
		                <option>17시</option>
		                <option>18시</option>
		                <option>19시</option>
		                <option>20시</option>
		            </select>
	            </div>
     		</div>
     	
            <%-- 좌석 선택(좌석행,열번호) --%>
            <div class="seat_select_wrap">
             <p class="info">&#8251;좌석은 1개만 선택 가능합니다.</p>
             <label for="seat_wrap"  class="book_label">좌석 선택: </label>
             <p id="mySeat"></p>
            
             <ul id="seat_wrap" class="seat-wrap">
                 <c:forEach items="${seatlist}" var="seat" varStatus="status">
                    <li class="seat_list">
		            	<div id="s_row" class="sRow">${seat.s_row}</div> 
             			<div id="s_num"> 
	             			<span>${seat.s_num}</span>  <%-- 선택 span --%>
	             			<span id="seat_id" class="hidden">${seat.s_id}</span>
	             			<span id="theater_id" class="hidden">${seat.theater_id}</span>
	             		</div> 
             		</li>
             		<c:if test="${status.count%3==0 }"><br></c:if>
                 </c:forEach>
             </ul>
            </div>
            
            <div id="here"></div>
             
            <div class="btn_reserve_wrap">
	            <input type="button" value="예매" id="btn_reserve" class="btnReserve">
            </div>
        </form>
        <script type="text/javascript">
        $(function () {
        	//선택한 영화로 포스터 이미지 변경
        	$("#movie-title").change(function() {
				var v = $("option:selected", this).val();
				console.log(v);
				var imgSrc = "${cpath}/static/images/poster/"+ v +  ".jpg";
				console.log(imgSrc);
				$("#selImg").attr("src", imgSrc);
				$("#selImg").attr("alt", v);
			});
        	
        	//좌석 선택 style
        	$(".seat_list").on("click", function() {
     			   $(this).siblings(".clicked").removeClass("clicked");
     			   $(this).addClass("clicked");
			});
        	
        	var sId;
        	//선택한 좌석 값
        	$("#s_num>span").click(function() {
        		var sNum = $(this).text();
        		var sRow = $(this).parent().siblings().text();
        		sId = $(this).next().text();
        		var theaterId = $(this).siblings().last().text();

        		$("#mySeat").text(sRow + sNum + "  (상영관" + theaterId + "관)" );
        		//console.log("s_id: " + sId);
        		
        	});
        	
        	//예매 버튼 클릭------------------------------
        	$("#btn_reserve").on("click", function(){
        		var param = $("#reservationFrm").serialize() + "&seatId=" + sId;;
        		//alert(param);
        		
        		$.ajax({
        			url:"reservation.do?"+param,
        			type:"post",
        			success:function(responseData){
        				 alert(responseData);
        				 if(responseData == "예매완료!"){
	        				 location.href = "${cpath}/member/myPage.do";
        				 }else{
        					 location.reload();
        				 }
        			},
        			error:function(xhr, status, error) {
        		        // 오류가 발생한 경우의 코드
        		        var errorMessage = xhr.status + ': ' + xhr.statusText;
        		        alert("좌석을 다시 선택해 주세요.");
        		    }
        		});
        	})
		});
        
        </script>
    </div>
</div>
</body>
</html>
