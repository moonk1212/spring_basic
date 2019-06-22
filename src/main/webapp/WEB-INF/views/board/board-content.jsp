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

<h2>${boardNo}번 게시물 내용</h2>

<p>
	# 글번호: ${boardNo}<br>
	# 작성자: ${content.name}<br>
	# 제목: ${content.title}<br>
	# 내용: <textarea rows="3" disabled>${content.content}</textarea>	
</p>

<a href="<c:url value='/board/list'/>">글 목록보기</a>&nbsp;
<a href="<c:url value='/board/modify?boardNo=${boardNo}'/>">글 수정하기</a>

</body>
</html>



