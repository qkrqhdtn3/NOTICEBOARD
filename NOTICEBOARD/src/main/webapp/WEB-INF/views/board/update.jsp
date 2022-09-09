<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> -->
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
<script src="/js/board.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form id="frm">
		<input type="hidden" value="${view.boardId }" name="boardId" id="boardId">
		제목 : <input type="text" placeholder="제목" id="subject" name="subject"
			value="${view.subject }"> 작성자 : <input type="text"
			placeholder="작성자" id="name" name="name" readonly="readonly"
			value="${view.name }">
		<div>
			내용 : <input type="text" placeholder="내용" id="content" name="content"
				value="${view.content}">
		</div>
		<button type="button" onclick="fn_boardUpdate();">등록</button>
	</form>
</body>
</html>