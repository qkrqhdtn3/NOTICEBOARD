<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/resources/js/board.js"></script> --%>
<script src="/js/board.js"></script>
<title>insert title here</title>
</head>
<body>
	<form id="frm">
		<input type="text" placeholder="제목" id="subject" name="subject"
			value="11"> <input type="text" placeholder="작성자" id="name"
			name="name" value="22"> <input type="text" placeholder="내용"
			id="content" name="content" value="33">
		<button type="button" onclick="fn_boardRegi();">등록</button>
	</form>
</body>
</html>