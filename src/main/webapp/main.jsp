<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.lqq.ems.pojo.Emp"%>
    <%@page import="com.lqq.ems.dao.EmpDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
 <div class="container">
  <br><h1 style="text-align: center;">用户信息</h1>
  <hr width="100%">
  <!-- <form class="form-horizontal" action="${pageContext.request.contextPath }/EmpServlet?cmd=list" method="post">
   --> 
   <table class="table table-bordered">
    <thead>
        <tr>
          <th>#</th>
          <th>昵称</th>
          <th>密码</th>
          <th>性别</th>
          <th>工资</th>
          <th>操作</th>
        </tr>
    </thead>
     <%
          EmpDao xm=new EmpDao();
          List<Emp> list=xm.list();
          for(Emp s:list)
          {%>
        <tr>
          <th scope="row"><%=s.getId()%></th>
          <td><%=s.getNickname()%></td>
          <td><%=s.getPassword()%></td>
          <td><%=s.getGender()%></td>
          <td><%=s.getSalary()%></td>
          <td>
            <a href="#">修改</a>
            <a href="#">删除</a>
          </td>
        </tr>
         <%}
          %>
   </table>
 </div>
</body>
</html>