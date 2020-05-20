<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Object principal = auth.getPrincipal();
 
    String name = "";
    if(principal != null) {
        name = auth.getName();
    }
%>
<!--     영수) 5월12일 고객센터 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>고객센터</h2>
<sec:authorize access="isAnonymous()">
   <a href="/login/login">로그인</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
   <p><sec:authentication property="principal.username"/>님, 반갑습니다.</p>

   <a href="/login/logout">로그아웃</a>
</sec:authorize>
<hr>
<!-- <a href="/admin/allNotice">공지사항</a><br> -->
<!-- <a href="/admin/List">문의사항</a><br> -->
<sec:authorize access="hasRole('ADMIN')"> 
<li><a href="<c:url value='/MainPage' />">관리자 메뉴</a></li> 
</sec:authorize>
<a href="#">공지사항</a><br>
<a href="/admin/List">문의사항</a><br>
</body>
</html>