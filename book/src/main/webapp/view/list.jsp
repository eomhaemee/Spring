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
<h2>책목록</h2>
	<table>
		<tr>
			<th>책 번호</th>
			<th>책이름</th>
		</tr>
		<tr>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.bookId}</td>
					<td><a href = "/book/detail?bookId=${book.bookId}">${book.bookNm}</a></td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<a href = "/book/write">책등록</a>
</body>
</html>