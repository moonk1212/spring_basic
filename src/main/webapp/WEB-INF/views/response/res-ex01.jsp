<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Model 객체에 대해 알아보기</h2>

<a href="<c:url value='/response/page01?age=30' />">1번 페이지로~</a><br>
<a href="<c:url value='/response/page02' />">2번 페이지로~</a><br>
<a href="<c:url value='/response/page03?page=15' />">3번 페이지로~</a><br>


</body>
</html>




