<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="/template/common_header.jsp" />
<link rel="stylesheet" type="text/css" href="/board/css/list_layout.css" />
<link rel="stylesheet" type="text/css" href="/board/css/signIn_layout.css" />
	<div class="singIn">
	 <form method="post" action="/board/user/dosignin">
		 <input type="text" name="userId" placeholder="ID를 입력하세요" /><br/>
		 <input type="password" name="userPassword" placeholder="비밀번호를 입력하세요" /><br/>
		 <input type="submit" value="SignId!" />
	 </form>
	</div>
<jsp:include page="/template/common_footer.jsp" />