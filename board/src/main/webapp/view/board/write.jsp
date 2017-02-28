<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기</h1>
	<hr/>
	<!-- writer/subject/content 이런것들은 parameter request에서 가져올수있음 -->
	<form method="post" action="/board/dowrite" >
	<!-- 	<input type="text" name="writer"  placeholder="이름을 입력하세요"/><br/> -->
		<input type="text" name="subject" placeholder="제목을 입력하세요"/><br/>
		<textarea name = "content" placeholder="내용을 입력하세요" rows="10" cols="30"></textarea></br>
		<input type="submit" value="글쓰기">
	</form>
	<a href="/board/list">목록으로 돌아가기</a>
</body>
</html>