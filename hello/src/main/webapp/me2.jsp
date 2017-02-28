<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, java.util.List"%>

<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			//Screptlet : 문서중간에 JAVA Code를 작성할수 있는 영역
			String name = "엄혜미";
			String addr  = "서울시 동대문구 이문동";
		%>
		<h3><% out.print(name); %> 소개</h3>
		<dl>
			<dt>주소</dt>
			<dd><%out.print(addr); %></dd>
			<dt>요즘 나의 관심..</dt>
			<dd>피아노</dd>
			<dt>다음생에 만나요</dt>
			<img src="공유.png" alt="Mr.gong" height="200" width="200"> 
		</dl>	
		
		<%
			List<String> subjects = new ArrayList<String>();
			subjects.add( "JAVA");
			subjects.add( "C");
			subjects.add( "C++");
		%>
		<h2>Programming</h2>
		<ul>
		<%
			for(String subject : subjects) {
		%>
			<li><%= subject %></li>			
		<% } %>

		</ul>
	</body>
</html>