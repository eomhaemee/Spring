<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/melon/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		
		
		$("input[type=button]").click(function(){	
		 var writeDiv = $("<div id='writeDiv'></div>");
		 //writeDiv
		 //position: absolute (0.0) 부터 위치 시작 거기부터 위에서 20, 왼쪽에 20 띄어져있는곳
		 //			 relative는 해당 객체가 속해있는 곳부터
		 /* z축을 상위로 올림 즉, 겹치도록 처리: 1보다 큰수로 주면됨  */
		 writeDiv.css({
			 position : 'absolute',
			 top : '50%',
			 left :'50%',
			 width:'150px',
			 height:'100px',
			 'margin-top':'-57.5px',
			 'margin-left':'-82.5px',
			 border: '1px solid #333333',
			 padding: '15px',
			 'z-index': 3 ,
			 'background-color' : '#FFFFFF'
		 });
		 
		 //writepage를 이자리(writeDiv)에 로드시켜보여줌
		 writeDiv.load("/melon/artist/write");
		 $(this).before(writeDiv);
		});
		
	});
</script>
<title>Artist List</title>
</head>
<body>
	<!-- 아래버튼을 누르면 요기div추가 되고 그공간에 write페이지를 보여줌 -->	
	<input type="button" value="아티스트 등록"/>
	
	<p>${artistCount}명의 아티스트가 검색되었습니다.</p>
	<table>
		<tr>
			<th>번호</th>
			<th>아티스트 명</th>
			<th>데뷔 일자</th>
		</tr>
		<c:forEach items="${artistList}" var="artist">
		<tr>
			<%-- <td>${artist.artistId}</td> --%>
			<td>
				<fmt:parseNumber>
					${fn:split(artist.artistId,'-')[2]}
				</fmt:parseNumber>
			</td>
			<td>${artist.member}</td>
			<td>${artist.debutDate}</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<form id="searchForm">
			${pager}
		</form>
	</div>
</body>
</html>