<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- name 를 키로 가지고 있는 attribute를 가져옴 ${} =>  getAttribute의 기능 --%>
	<h1>${name}</h1>
	<h2>${name2}</h2>
	<h3>${param.keyword}</h3>
<h2>여긴..수업시간게시판</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>좋아요</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${articleList}" var="article">

			<tr>
				<td>${article.boardId }</td>
				<td>
					<a href="/board/detail?boardId=${article.boardId}"> ${article.subject } </a>
				</td>
				<td>${article.user.userName}(${article.writer })</td>
				<td>${article.likeCount }</td>
				<td>${article.writeDate }</td>
			</tr>

		</c:forEach>

	</table>
<!-- 	상대주소,절대주소 가능
	<a href="http://localhost:8080/board/write">글쓰기</a> -->
	<a href="/board/write">글쓰기</a>

	
</body>
</html>