<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<%--<script src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>--%>
<script src="/js/member.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form id="frm">
		<div>
			아이디 : <input type="text" id="memberName" name="memberName" value="memberName1">
		</div>
		<div>
			비밀번호 : <input type="text" id="password" name="password" value="password">
		</div>
		<button type="button" onclick="fn_login();">로그인</button>
		<button type="button" onclick='location.href="/member/join"'>회원가입</button>
	</form>
</body>
</html>