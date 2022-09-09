<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<input type="hidden" value="" name="boardId" id="boardId">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list">
					<tr>
						<td>${list.boardId}</td>
						<td><a href="#" onclick="fn_goView(${list.boardId})">${list.subject }</a></td>
						<td>${list.content }</td>
						<td>${list.name }</td>
						<fmt:parseDate value="${list.reg_date }" var="dateValue"
							pattern="yyyyMMddHHmmss" />
						<td><fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd" /></td>
						<td>${list.readCount }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<button type="button" onclick="location.href='/board/regiView'">글쓰기</button>
	</form>
</body>
</html>