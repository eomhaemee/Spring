<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>책번호</th>
<th>책이름</th>
<th>상세</th>
<th>목차</th>
</tr>
<tr>
<td>${book.bookId }</td>
<td>${book.bookNm }</td>
<td>${book.bookSubNm }</td>
<td>${book.idx }</td>
</tr>
</table>
<a href = "/book/write">글쓰기</a>|
<a href = "/book/dodelete?bookId=${book.bookId }">삭제</a>|
<a href = "/book/update?bookId=${book.bookId }">수정</a>|
<a href="/book/list">책목록</a>
</body>
</html>