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
    <h1 class="page_title">예매 완료</h1>
</body>
</html>
