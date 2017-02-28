<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/book/dowrite" method="post">
		<input type="text" name="bookNm" placeholder="책이릅을 입력하세요"><br />
		<input type="text" name="bookSubNm" placeholder="책세부내욕을 입력하세요"><br />
		<textarea name="idx" placeholder="목차를 입력하세요" rows="10" cols="20"></textarea><br /> 
		<input type="submit" value="저장">
	</form>
<a href="/book/list">목록으로 돌아가기</a>

</body>
</html>