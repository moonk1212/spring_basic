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

<h2>${boardNo}번 게시물 내용 수정</h2>
<form action="<c:url value='/board/modify'/>" method="post">
	<input type="hidden" name="boardNo" value="${boardNo}">
	<p>
		# 글번호: ${boardNo}<br>
		# 작성자: <input type="text" name="name" value="${content.name}"><br>
		# 제목: <input type="text" name="title" value="${content.title}"><br>
		# 내용: <textarea rows="3" name="content">${content.content}</textarea>	
		<br>
		<input type="submit" value="수정">
	</p>
</form>

<a href="<c:url value='/board/list'/>">글 목록보기</a>&nbsp;


</body>
</html>



