<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${oneBoard.subject}</h1>
	<hr />
	<span>${oneBoard.writer }</span>
	<span>${oneBoard.writeDate }</span>
	<hr />
	<p>${oneBoard.content}</p>

	<a href = "/myboard/list">목록으로</a>|
	<a href = "/myboard/delete?boardId=${oneBoard.boardId }">삭제</a>|
	<a href = "/myboard/update?boardId=${oneBoard.boardId }">수정</a>
	
</body>
</html>