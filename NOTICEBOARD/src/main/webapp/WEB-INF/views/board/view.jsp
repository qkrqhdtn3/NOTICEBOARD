<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <script src="https://code.jquery.com/jqeury-3.4.1.min.js"></script> -->
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
<script src="/js/board.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form id="frm">
		<input type="hidden" value="" name="boardId" id="boardId">
		<div>제목 : ${view.subject } 조회수 : ${view.readCount }</div>
		<div>작성자 : ${view.name }</div>
		<div>내용 : ${view.content }</div>
		<button type="button" onclick='location.href="/board/list"'>목록</button>
		<button type="button" onclick='fn_goUpdateView(${view.boardId})'>수정</button>
		<button type="button" onclick='fn_boardDelete(${view.boardId })'>삭제</button>
	</form>
</body>
</html>