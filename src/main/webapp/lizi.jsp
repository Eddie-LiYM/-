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
      <form class="form-horizontal" action="${pageContext.request.contextPath }/EmpServlet?cmd=aaa" method="post">
        <div id="n1" class="form-group" >
          <label for="inputEmail3" class="col-sm-2 control-label">Nickname</label>
          <div class="col-sm-8">
            <input type="text" class="form-control" id="nickname" name="nickname" placeholder="Nickname" onClick="nMsg()">
          </div>
          <span id="aaa"></span>
        </div>
        <div id="p1" class="form-group">
           <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
           <div class="col-sm-8">
             <input type="password" class="form-control" id="password" name="password" placeholder="Password" onClick="pMsg()">
           </div>
           <span id="bbb"></span>
        </div>
        <div id="p2" class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">Pwd again</label>
          <div class="col-sm-8">
            <input type="password" class="form-control" id="password" placeholder="Password Again" onClick="p2Msg()">
          </div>
          <span id="bbb2"></span>
        </div>
        <div id="g1" class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">Gender</label>
          <div class="col-sm-8">
            <input type="text" class="form-control" id="gender" placeholder="Gender" onClick="gMsg()">
          </div>
           <span id="ccc"></span>
        </div>
        <div id="s1" class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">Salary</label>
          <div class="col-sm-8">
            <input type="text" class="form-control" id="salary" placeholder="Salary" onClick="sMsg()">
          </div>
           <span id="ddd"></span>
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
        <div style="color:red">
           $(requestCode.nicknameMsg);
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Sign in</button>
          </div>
        </div>
      </form>
    </div> 
    <!-- /container -->
    <div style="text-align: center;">
    <h3 id="p1">这里的内容将被隐藏</h3>
    <button id="hideP" class="btn btn-primary">隐藏</button>
    <button id="showP" class="btn btn-success">显示</button>
    </div>
    
    
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
  <script type="text/javascript">
    $("#n1").click(function(){
        $("#aaa").show();
    });
    $("#p1").click(function(){
        $("#aaa").hide();
    });
    $("#p2").click(function(){
        $("#aaa").hide();
    });
    $("#s1").click(function(){
        $("#aaa").hide();
    });
    $("#g1").click(function(){
        $("#aaa").hide();
    });
    
    $("#p1").click(function(){
        $("#bbb").show();
    });
    $("#n1").click(function(){
        $("#bbb").hide();
    });
    $("#p2").click(function(){
        $("#bbb").hide();
    });
    $("#g1").click(function(){
        $("#bbb").hide();
    });
    $("#s1").click(function(){
        $("#bbb").hide();
    });
    
    $("#p2").click(function(){
        $("#bbb2").show();
    });
    $("#n1").click(function(){
        $("#bbb2").hide();
    });
    $("#p1").click(function(){
        $("#bbb2").hide();
    });
    $("#g1").click(function(){
        $("#bbb2").hide();
    });
    $("#s1").click(function(){
        $("#bbb2").hide();
    });
    
    $("#g1").click(function(){
        $("#ccc").show();
    });
    $("#n1").click(function(){
        $("#ccc").hide();
    });
    $("#p2").click(function(){
        $("#ccc").hide();
    });
    $("#p1").click(function(){
        $("#ccc").hide();
    });
    $("#s1").click(function(){
        $("#ccc").hide();
    });
    /* 当光标放入到nickname的输入框中，则提示输入内容*/
    function nMsg(){
    	//alert("点击了nickname输入框");
    	var nSpan=document.getElementById("aaa");
    	nSpan.innerHTML="<font color='blue'>昵称为8~16位</font>";
    }
    function pMsg(){
    	var nSpan=document.getElementById("bbb");
    	nSpan.innerHTML="<font color='blue'>密码为8~16位</font>";
    }
    function pMsg2(){
    	var nSpan=document.getElementById("bbb2");
    	nSpan.innerHTML="<font color='blue'>再次输入密码确认</font>";
    }
    function gMsg(){
    	var nSpan=document.getElementById("ccc");
    	nSpan.innerHTML="<font color='blue'>性别为‘男’或‘女’</font>";
    }
    function sMsg(){
    	var nSpan=document.getElementById("ddd");
    	nSpan.innerHTML="<font color='blue'>工资>=0</font>";
    }
  </script>
</html>
