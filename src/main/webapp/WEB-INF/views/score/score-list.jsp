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

<h2>학생들의 점수 목록</h2>
<c:forEach var="score" items="${scores}" varStatus="stuNo">
<p>
	# 번호: ${stuNo.index+1}, 이름: ${score.stuName}, 국어: ${score.kor}점, 
	영어: ${score.eng}점, 수학: ${score.math}점,
	총점: ${score.total}점, 평균: ${score.average}점
	&nbsp; <a href="<c:url value='/score/delete?stuNo=${stuNo.index+1}' />">[삭제]</a>
</p>
</c:forEach>

<a href="<c:url value='/score/register'/>">다른 점수 등록하러 가기</a>

<script type="text/javascript">
	const message = "${msg}";
	if(message === "insertSuccess") {
		alert("점수 등록 완료!");
	}
</script>

</body>

</html>








