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
 <form method="post" action="/board/user/dosignin">
 <input type="text" name="userId" placeholder="ID를 입력하세요" /><br/>
 <input type="password" name="userPassword" placeholder="비밀번호를 입력하세요" /><br/>
 <input type="submit" value="SignId!" />
 </form>
</body>
</html>