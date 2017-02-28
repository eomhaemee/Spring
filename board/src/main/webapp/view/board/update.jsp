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
	<h1>글수정하기</h1>
	<hr />
	
	<form method="post" action="/board/doupdate">
	    <input type="hidden" name="boardId" value = "${board.boardId}" />
		<input type="text" name="writer" value = "${board.writer}"  placeholder="이름을 입력하세요"/><br /> 
		<input type="text" name="subject" value = "${board.subject}"  placeholder="제목을 입력하세요"/><br />
		<textarea name="content" rows="10" cols="30" placeholder="내용을 입력하세요">${board.content}</textarea><br/>
		<input type="submit" value="글수정">
	</form>
	<a href="/board/list">목록으로 돌아가기</a>

</body>
</html>