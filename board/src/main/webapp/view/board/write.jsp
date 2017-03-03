<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/common_header.jsp" />
<link rel="stylesheet" type="text/css" href="/board/css/list_layout.css" />
<link rel="stylesheet" type="text/css" href="/board/css/write_layout.css" />
	<div class="write">	
		<h1>글쓰기</h1>
		<hr/>
		<!-- writer/subject/content 이런것들은 parameter request에서 가져올수있음 -->
		<div class="inputform">
			<form method="post" action="/board/dowrite" >
			<!-- 	<input type="text" name="writer"  placeholder="이름을 입력하세요"/><br/> -->
				<input type="text" name="subject" placeholder="제목을 입력하세요"/><br/>
				<textarea name = "content" placeholder="내용을 입력하세요" rows="10" cols="30"></textarea><br/>
				<input type="submit" value="글저장">
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