<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jqeury.com/jquery-3.4.1.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/resources/js/board.js"></script> --%>
<script src="/js/board.js"></script>
<title>insert title here</title>
</head>
<body>
<form id="frm">
<input type="text" placeholder="제목" id="subject" name="subject">
<input type="text" placeholder="작성자" id="name" name="name">
<input type="text" placeholder="내용" id="content" name="content">
<button type="button" onclick="fn_boardRegi();">등록</button>
</form>
</body>
</html>