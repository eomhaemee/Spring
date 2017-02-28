<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<h2>글수정</h2>
<body>
	<form action="/book/doupdate" method="post">
		<input type="hidden" name = "bookId" value = "${book.bookId }" />
		<input type="text" name="bookNm" placeholder="책이릅을 입력하세요" value="${book.bookNm}"/><br />
		<input type="text" name="bookSubNm" placeholder="책세부내욕을 입력하세요" value="${book.bookSubNm}"/><br />
		<textarea name="idx" placeholder="목차를 입력하세요" rows="10" cols="20">${book.idx}</textarea><br /> 
		<input type="submit" value="수정"/>
	</form>
<a href="/book/list">목록으로 돌아가기</a>


</body>
</html>