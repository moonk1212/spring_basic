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

<h2>게시글 등록</h2>

<form action="<c:url value='/board/write'/>" method="post">

	<p>
		# 작성자: <input type="text" name="name"><br>
		# 제목: <input type="text" name="title"><br>
		# 내용: <textarea rows="3" name="content"></textarea>
		<br>
		<input type="submit" value="등록">
	</p>
</form>

<%-- 글 목록으로 이동하는 링크를 만드세요. --%>
<a href="<c:url value='/board/list'/>">글 목록보기</a>
</body>
</html>





