<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 
- jstl core라이브러리의 <c:url>태그는
  컨텍스트 루트를 제외하고 절대경로를 작성할 수 있게 도와줍니다.
  ex) <c:url value="컨텍스트를 제외한 경로" />
--%>
<h2>요청 파라미터값 테스트!!</h2>
<form action="<c:url value='/request/join'/>" method="post">
	<fieldset>
		<legend>회원가입 양식</legend>
		<p>
			- ID: <input type="text" name="userId" size="10"><br>
			- PW: <input type="password" name="userPw" size="10"><br>
			- NAME: <input type="text" name="userName" size="10"><br>
			- HOBBY:
			<input type="checkbox" name="hobby" value="축구">축구&nbsp;
			<input type="checkbox" name="hobby" value="독서">독서&nbsp;
			<input type="checkbox" name="hobby" value="음악">음악&nbsp;
			<br>
			<input type="submit" value="회원가입">
		</p>
	</fieldset>
</form>

</body>
</html>











