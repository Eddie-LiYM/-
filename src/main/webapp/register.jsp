<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>Signin Template for Bootstrap</title>
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
    <style type="text/css">
      input{
          width:200px;
      }
    </style>
  </head>

  <body>
    <div class="container">
      <br><h1 style="text-align: center;">注册</h1>
      <hr width="100%">
      <form class="form-horizontal" action="${pageContext.request.contextPath }/EmpServlet?cmd=register" method="post">
        <div id="n" class="form-group" >
          <label for="inputEmail3" class="col-sm-2 control-label">Nickname</label>
          <div class="col-sm-8">
            <input type="text" class="form-control" id="nickname" name="nickname" placeholder="Nickname" onClick="nMsg()">
          </div>
          <span id="name"></span>
        </div>
        <div id="p1" class="form-group">
           <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
           <div class="col-sm-8">
             <input type="password" class="form-control" id="password" name="password" placeholder="Password" onClick="pMsg()">
           </div>
           <span id="pwd"></span>
        </div>
        <div id="p2" class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">Pwd again</label>
          <div class="col-sm-8">
            <input type="password" class="form-control" id="password2" name="password2" placeholder="Password Again" onClick="pMsg2()">
          </div>
          <span id="pwd2"></span>
        </div>
        <div id="g" class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">Gender</label>
          <div class="col-sm-8">
            <input type="text" class="form-control" id="gender" name="gender"placeholder="Gender" onClick="gMsg()">
          </div>
           <span id="gen"></span>
        </div>
        <div id="s" class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">Salary</label>
          <div class="col-sm-8">
            <input type="text" class="form-control" id="salary" name="salary" placeholder="Salary" onClick="sMsg()">
          </div>
           <span id="sa"></span>
        </div>
  <!-- <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>-->
        <!-- 显示请求域中的信息 -->
		<div id="name1" style="color: red">
			${requestScope.nicknameMsg }
		</div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Sign in</button>
          </div>
        </div>
      </form>
    </div> 
    <!-- /container -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
  <script type="text/javascript">
    $("#n").click(function(){
        $("#name").show();
    });
    $("#p1").click(function(){
        $("#name").hide();
    });
    $("#p2").click(function(){
        $("#name").hide();
    });
    $("#s").click(function(){
        $("#name").hide();
    });
    $("#g").click(function(){
        $("#name").hide();
    });
    

    $("#n").click(function(){
        $("#pwd").hide();
    });
    $("#p1").click(function(){
        $("#pwd").show();
    });
    $("#p2").click(function(){
        $("#pwd").hide();
    });
    $("#g").click(function(){
        $("#pwd").hide();
    });
    $("#s").click(function(){
        $("#pwd").hide();
    });
    
    
    $("#n").click(function(){
        $("#pwd2").hide();
    });
    $("#p1").click(function(){
        $("#pwd2").hide();
    });
    $("#p2").click(function(){
        $("#pwd2").show();
    });
    $("#g").click(function(){
        $("#pwd2").hide();
    });
    $("#s").click(function(){
        $("#pwd2").hide();
    });
    
    $("#n").click(function(){
        $("#gen").hide();
    });
    $("#p1").click(function(){
        $("#gen").hide();
    });
    $("#p2").click(function(){
        $("#gen").hide();
    });
    $("#g").click(function(){
        $("#gen").show();
    });
    $("#s").click(function(){
        $("#gen").hide();
    });
    
    $("#n").click(function(){
        $("#sa").hide();
    });
    $("#p1").click(function(){
        $("#sa").hide();
    });
    $("#p2").click(function(){
        $("#sa").hide();
    });
    $("#g").click(function(){
        $("#sa").hide();
    });
    $("#s").click(function(){
        $("#sa").show();
    });
    
    $("#n").click(function(){
        $("#name1").hide();
    });
    $("#p1").click(function(){
        $("#name1").hide();
    });
    $("#p2").click(function(){
        $("#name1").hide();
    });
    $("#g").click(function(){
        $("#name1").hide();
    });
    $("#s").click(function(){
        $("#name1").hide();
    });
    /* 当光标放入到nickname的输入框中，则提示输入内容*/
    function nMsg(){
    	//alert("点击了nickname输入框");
    	var nSpan=document.getElementById("name");
    	nSpan.innerHTML="<font color='blue'>昵称为8~16位</font>";
    }
    function pMsg(){
    	var nSpan=document.getElementById("pwd");
    	nSpan.innerHTML="<font color='blue'>密码不允许为空</font>";
    }
    function pMsg2(){
    	var nSpan=document.getElementById("pwd2");
    	nSpan.innerHTML="<font color='blue'>再次输入密码确认</font>";
    }
    function gMsg(){
    	var nSpan=document.getElementById("gen");
    	nSpan.innerHTML="<font color='blue'>性别为‘男’或‘女’</font>";
    }
    function sMsg(){
    	var nSpan=document.getElementById("sa");
    	nSpan.innerHTML="<font color='blue'>工资>=0</font>";
    }
  </script>
</html>
