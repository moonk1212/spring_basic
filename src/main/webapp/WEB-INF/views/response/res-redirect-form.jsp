<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- ResponseController 사용 --%>
<form id="login-form" action="login" method="post">
	<p>
		# ID: <input id="input-id" type="text" name="userId" size="10"><br>
		# 비밀번호: <input id="input-pw" type="password" name="userPw" size="10"><br>
		# 비밀번호 확인: <input id="input-pw-chk" type="password" name="userPwChk" size="10"><br>
		<input type="button" value="로그인" onclick="loginCheck()">
	</p>
</form>
<%-- <p style="color: red;">${msg}</p> --%>

<script type="text/javascript">
function loginCheck() {
	//자바스크립의 변수를 선언할 때는 타입에 let을 붙입니다.
	//상수를 선언할 때는 const를 사용합니다.	
	const loginForm = document.getElementById("login-form");
	const inputId = document.getElementById("input-id");
	const inputPw = document.getElementById("input-pw");
	const inputPwChk = document.getElementById("input-pw-chk");
	
	if(inputId.value === "") {
		alert("아이디는 필수값입니다!!");
		return;
	} else if(inputPw.value !== inputPwChk.value) {
		alert("비밀번호 확인란을 다시 확인하세요!");
		return;
	} else {
		loginForm.submit();
	}
	
}
</script>

</body>
</html>











