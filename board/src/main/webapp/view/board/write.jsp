<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/common_header.jsp" />
<link rel="stylesheet" type="text/css" href="/board/css/list_layout.css" />
<link rel="stylesheet" type="text/css" href="/board/css/write_layout.css" />
<script type="text/javascript">

	$().ready(function(){
		//1. jquery방식으로 전달
		/* type이 button인 애를 클릭했을때 작동 */
		$("#writeForm").find("input[type=button]").click(function(){
			/* attr() 속성을 제어함 */
			/* 아래처럼 두줄로 추가해도 되지만,,
			/* $("#writeForm").attr("mothod","post");
			   $("#writeForm").attr("action","/board/dowrite" );  */
			/* 객체리터럴{} 로 세팅함 
			   여러버튼을 다른 URL로 넘길수도 있겠군   */
			$("#writeForm").attr({
				"mothod" : "post",
				"action" : "/board/dowrite"
			});
			/* submit을 이렇게 변경함 */
			$("#writeForm").submit();
		});
		
		//2.AJAX 방식으로 전달
		//AJAX 는 아래 Form으로 data를 보내지 않고 여기 위에서 ajax부분에서 처리
		// 단, 파일은 보낼수 없어서 이건 form으로 보냄
		$("#writeForm").find("img").click(function(){
			//AJAX로 POST보내기 (요청을보낼주소,전달할 parameter,콜백함수(아무변수명)))
			//콜백: 전달한 parameter로 처리한 응답을 받은부분이 처리
			//전달할 parameter 보내기방법 1. 객체 리터럴 방식으로 보내기 [name태그명 : 값]
			$.post("/board/dowrite",{
				"subject" :$(".subject").val(),
				"content" :$(".content").val()
			}, function(response){
				alert("글쓰기가 잘 완료되었습니다.");
			});
		});
		
	});
</script>
	<div class="write">	
		<h1>글쓰기</h1>
		<hr/>
		<!-- writer/subject/content 이런것들은 parameter request에서 가져올수있음 -->
		<div class="inputform">
			<!-- <form>태그에서 method, action, submit 을 더이상 사용하지 않음 jquery로 올림-->
			<!-- <form method="post" action="/board/dowrite" > -->
			<form id="writeForm">
			<!-- 	<input type="text" name="writer"  placeholder="이름을 입력하세요"/><br/> -->
				<input type="text" class="subject" name="subject" placeholder="제목을 입력하세요"/><br/>
				<textarea name = "content"  class="content"  placeholder="내용을 입력하세요" rows="10" cols="30"></textarea><br/>
				<!-- <input type="submit" value="글저장"> -->
				<input type="button" value="글저장">
				<img src="/board/img/ic_note_add_black_24dp_2x.png">
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