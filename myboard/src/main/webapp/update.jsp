<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글수정</h1>
	<hr />
	<form method="post" action="/myboard/doupdate">
		<input type="hidden" name= "boardId" value="${ board.boardId}"/>
		<input type="text" name="writer" value="${ board.writer}" placeholder="이름을 입력하세요" /><br />
		<input type="text" name="subject" value="${board.subject}"  placeholder="주제를 입력하세요" /><br /> 
		<textarea name="content" placeholder="내용을 입력하세요" rows="20" cols="50">${board.content}</textarea><br />
		<input type="submit" value="글수정">
	</form>
</body>
</html>