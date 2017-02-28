<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>여긴..과제게시판</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>좋아요</th>
			<th>작성일</th>
		</tr>
	<c:forEach items="${myBoardList}" var="board">
		<tr>
			<td>${board.boardId}</td>
			<td><a href = "/myboard/detail?boardId=${board.boardId}"> ${board.subject}</a></td>
			<td>${board.writer}</td>
			<td>${board.likeCount}</td>
			<td>${board.writeDate}</td>
		</tr>
	</c:forEach>
	</table>
	<a href ="/myboard/write">글쓰기</a> 
</body>
</html>