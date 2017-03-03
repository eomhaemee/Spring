<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/board/css/common_layout.css" />
<link rel="stylesheet" type="text/css" href="/board/css/list_layout.css" />
</head>
<body>
	<!-- wrapper: content의 사이즈를 제한하는 용도 -->
	<div id="wrapper">
		<div id="nav">
			<a href="/board/user/login">로그인</a> | <a href="/board/user/signup">회원가입</a>
			| <a href="/board/user/logout"> 로그아웃</a>

		</div>
		<div id="content">
			<!-- content 안쪽에서는 id말고 class.. -->
			<div class="grid">
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
							<td><a href="/board/detail?boardId=${article.boardId}">
									${article.subject } </a></td>
							<td>${article.user.userName}(${article.writer })</td>
							<td>${article.likeCount }</td>
							<td>${article.writeDate }</td>
						</tr>

					</c:forEach>

				</table>
				<!-- 	상대주소,절대주소 가능
				<a href="http://localhost:8080/board/write">글쓰기</a> -->
				<a href="/board/write">글쓰기</a>
			</div><!-- 
			 --><div class="login">
			    <!-- sessionScope : session 가져오는 jsp 내장객체, null체크 : empty c에는 else가 없음 -->
			 	<c:if test="${empty sessionScope._USER_}">
					<jsp:include page="/view/users/signIn.jsp"/>
				</c:if>
				<c:if test="${not empty sessionScope._USER_ }">
					${sessionScope._USER_.userName}님 , 환영합니다.
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>