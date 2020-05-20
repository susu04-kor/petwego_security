<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- <%session.setAttribute("user_id", request.getParameter("user_id")); %> --%>
<%-- <%session.setAttribute("pwd", request.getParameter("pwd")); %>    --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login-Processing</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
  <script type="text/javascript">
	
  </script>
</head>
<body>
<!-- <h3>로그인 성공!!</h3> -->

<%-- <h3>Login ID : <%=(String)session.getAttribute("user_id") %></h3> --%>
<%-- <h3>Login Password: <%=(String)session.getAttribute("pwd") %></h3> --%>



<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Welcome You!</h1>
    <sec:authorize access="isRememberMe()">
        <h2># This user is login by "Remember Me Cookies".</h2>
    </sec:authorize>
    <sec:authorize access="isFullyAuthenticated()">
        <h2># This user is login by username / password.</h2>
    </sec:authorize>
                </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <button type="button" id="logout" class="btn btn-primary btn-lg btn-block">로그아웃</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>