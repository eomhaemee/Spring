<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/template/common_header.jsp" />
<link rel="stylesheet" type="text/css" href="/board/css/list_layout.css" />
<link rel="stylesheet" type="text/css" href="/board/css/update_layout.css" />
	<div class="update">	
		<h1>글수정하기</h1>
		<hr />
		<div class="updateform">
			<form method="post" action="/board/doupdate">
			    <input type="hidden" name="boardId" value = "${board.boardId}" />
				<input type="text" name="writer" value = "${board.writer}"  placeholder="이름을 입력하세요"/><br /> 
				<input type="text" name="subject" value = "${board.subject}"  placeholder="제목을 입력하세요"/><br />
				<textarea name="content" rows="10" cols="30" placeholder="내용을 입력하세요">${board.content}</textarea><br/>
				<input type="submit" value="글수정">
			</form>
			<div class="returnlist">
				<a href="/board/list">목록으로 돌아가기</a>
			</div>
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