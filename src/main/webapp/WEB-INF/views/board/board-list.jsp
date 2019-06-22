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

<c:if test="${articles.size() <= 0}">
	<p>게시물이 존재하지 않습니다.</p>
</c:if>

<c:if test="${articles.size() > 0}">
<h2>게시글 목록</h2>

<table border="1">
	<tr>
		<td>번호</td>
		<td>작성자</td>
		<td>제목</td>
		<td>비고</td>
	</tr>
	
	<c:forEach var="article" items="${articles}" varStatus="num">
	<tr>
		<td>${num.index+1}</td>
		<td>${article.name}</td>
		<td>
			${article.title}
		</td>
		<td><a href="<c:url value='/board/delete?boardNo=${num.index+1}'/>">[삭제]</a></td>
	</tr>
	</c:forEach>
</table>
</c:if>
<%-- 게시글 작성페이지로 이동시키세요 --%>
<a href="<c:url value='/board/write'/>">게시글 작성</a>

</body>
</html>










