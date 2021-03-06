<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/template/common_header.jsp"/>
<link rel="stylesheet" type="text/css" href="/board/css/list_layout.css" />
<script type="text/javascript" src="/board/js/jquery-3.1.1.min.js"></script>

			<!-- content 안쪽에서는 id말고 class.. -->
			<div class="grid">
				총 ${count }건의 게시글이 검색되었습니다.
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>좋아요</th>
					</tr>
					<c:forEach items="${articleList}" var="article">
						<tr>
							<td>${article.boardId}</td>
							<td><a href="/board/detail?boardId=${article.boardId}">${article.subject }</a></td>
							<td>${article.user.userName}(${article.writer })</td>
							<td>${article.writeDate }</td>
							<td>${article.likeCount }</td>
						</tr>
					</c:forEach>
				</table>
				
				<!-- 	상대주소,절대주소 가능
				<a href="http://localhost:8080/board/write">글쓰기</a> -->
				<a href="/board/write">글쓰기</a>
				<div>
					<!-- action을 안적으면 스스로에게 요청함 -->
				 	<form method="post" id="searchForm">
				 		${pager}
				 	</form>
				</div>	
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
<jsp:include page="/template/common_footer.jsp"/>		