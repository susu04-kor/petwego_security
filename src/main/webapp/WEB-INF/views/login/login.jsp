<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!--  <script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>-->
  <!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>
<div class="container">
	<div class="row" style="padding-top:10%">
		<div class="col-md-4"></div>
		<div class="col-md-4" style="flex-align:center">
			<div class="card">
				<h5 class="card-header">로그인</h5>
				<div class="card-body">
					<form action="/login/login" method="POST"><!-- /login-processing --> <!-- /MainPage -->
  						<input type="hidden" id="token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  				<!--  	<input type="text" name="_csrf" value="${_csrf}"/>-->	
  						<!--<sec:csrfInput/>-->
						<div class="form-group">
							<label for="InputId">아이디</label>
							<input type="text" class="form-control" id="user_id" name="user_id" placeholder="ID">
						</div>
						<div class="form-group">
							<label for="InputPassword">비밀번호</label>
							<input type="password" class="form-control" id="pwd" name="pwd" placeholder="PASSWORD">
						</div>
						<div class="checkbox">
							<label>
								<input type="checkbox" name="remember-me">아이디 기억하기 <!-- 로그인 유지 기능 -->
							</label>
						</div>
						<button id="login-button" name="submit" type="submit" class="btn btn-block btn-primary text-light">로그인</button>
						<!-- type="submit"  -->
<%-- 						<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">  --%>
<%-- 							<p class="error">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>  --%>
<%-- 							<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>  --%>
<%-- 						</c:if> --%>
						<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						    <font color="red">
						        <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
						        <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
						    </font>
						</c:if>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js">

$(function(){
	$("#login-button").click(function(){
		login();
		//window.location.href="/MainPage";
	})		
})

/*
function login(){
	$.ajax({
		url:"/login",
		type :  "POST",
		dataType : "json",
		data : {
			user_id : $("#user_id").val(),
			pwd : $("#pwd").val();
		},
		beforeSend : function(xhr)
        {
			//이거 안하면 403 error
			//데이터를 전송하기 전에 헤더에 csrf값을 설정한다
			var $token = $("#token");
			xhr.setRequestHeader($token.data("name"), $token.val());
        },
		success : function(response){
			if(response.code == "200"){
				// 정상 처리 된 경우
			//	window.location = response.item.url;	//이전페이지로 돌아가기
				window.location.href = "/MainPage";	//????
			} else {
				alert(response.message);
			}
		},
		error : function(a,b,c){
			console.log(a,b,c);
		}
		
	})
}
*/
</script>
</html>