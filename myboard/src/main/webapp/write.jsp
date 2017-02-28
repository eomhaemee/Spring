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
	<h1>글쓰기</h1>
	<hr />
	<form method="post" action="/myboard/dowrite">
		<input type="text" name="writer" placeholder="이름을 입력하세요"><br />
		<input type="text" name="subject" placeholder="주제를 입력하세요"><br /> 
		<textarea name="content" placeholder="내용을 입력하세요"></textarea><br />
		<input type="submit" value="글저장">
	</form>

</body>
</html>