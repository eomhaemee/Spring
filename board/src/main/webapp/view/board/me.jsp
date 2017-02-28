<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!-- 많이 쓰는jstl들 
 	1. c:if
 	2. c:foreach
 	3. c:choose ~ c:when ~ c: otherwise
 	4. c:set
 	5. c:out
 	6. c:import
 -->
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
	
	${introduce}
		<h3>${introduce.name} 소개zzz</h3>
		<dl>
			<dt>주소</dt>
			<dd>${introduce.addr} </dd>
			<dt>요즘나의 관심..</dt>
			<dd>${introduce.hobby}</dd>
			<dt>나이</dt>
			<dd>${introduce.age}</dd>
			<dt>다음생에 만나요</dt>
			<img src="공유.png" alt="Mr.gong" height="200" width="200"> 
		</dl>	
		<!--  items 에 정의된 list를 var변수에 담아 loop -->
		<c:forEach items = "${introduceList}" var = "intro">
		
			${intro.name }</br>
			${intro.age }</br>
			${intro.addr }</br>
			
		</c:forEach>

		
		<dl>${introduceList[0].name}</dl>
		<dl>${introduceList[0].addr}</dl>
		<dl>${introduceList[0].hobby}</dl>
		
		
		<h2>Programming</h2>
		<ul>
			<li>Java</li>
			<li>C</li>
			<li>C++</li>
			
		</ul>
	</body>
</html>