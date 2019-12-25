<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
    <h1 style="text-align: center;">登录</h1>
    <hr width="80%">
   <!--   <div style="padding: 20px 380px 10px;">-->
    <div class="login-form">
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
	    <div class="avtar">
		  <img src="images/avtar.png" />
	    </div>
     <form style="text-align: center;" action="${pageContext.request.contextPath }/EmpServlet?cmd=login" method="post">
        <input type="text" id="nickname"  name="nickname" placeholder="请输入昵称">    
        <input type="password" id="password" name="password" placeholder="请输入密码">  
      <div class="signin">
        <input type="submit" value="登录" style="width: 80%;">
      </div>
        <h3>还没有账号? <a href="http://localhost:8080/csi/register.jsp">立即注册</a> </h3>
        <br>
     </form>
    </div>
</body>
</html>