<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录物业管理平台</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

<script type="text/javascript">
	function submit(){ 
	 	var Name = $("#loginuser").val();	//通过id获取
		var Pwd =$("#loginpwd").val();		//通过id获取
		if(Name==""||Name==null){
			alert("用户名不能为空！");
		}else if(Pwd==""||Name==null){
			alert("密码不能为空！");
			return;
		}else if(Name==" "&&Pwd==null){
	 		alert("用户名不能为空！");
	 		return;
		}else{		
			//判断密码是否存在
		    $.post("Login!Login.action",{UserName:Name,PassWord:Pwd},function(data){
		    	if(data.CheckPassword=="密码正确"){
		    	    location.href="main.jsp";
		    	}else{
		    		alert("账号或密码错误！");
		    	}	
			});
		} 
	}
</script>
</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>
	<div class="logintop">    
    	<span>欢迎登录紫夜小区物业管理平台</span>    
    	<ul>
    	<li><a href="#">联系我们</a></li>
   	 	<li><a href="#">帮助</a></li>
   	 	<li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    <span class="systemlogo"></span> 
    	<div class="loginbox">
    		<ul>
    			<li><input name="loginuser" id="loginuser" type="text" class="loginuser" placeholder="请输入您的账号"/></li>
    			<!-- placeholder="请输入您的账号" html5的属性，文本框内的提示语句 -->
    			<li><input name="loginpwd" id="loginpwd" type="password" class="loginpwd" placeholder="请输入您的密码"/></li>
   				 <li>
    				<input name="" type="button" class="loginbtn" value="登录"  onclick="submit()"  />
    				<label><a href="register.jsp">注册账号</a></label>
    				<label><a href="main_two.html">忘记密码？</a></label>
    			</li>
    		</ul>
    	</div>
    </div>
    <div class="loginbm">版权所有  2018 <a href="https://user.qzone.qq.com/502560911/infocenter">李子叶彡</a> </div>
	
</body>
</html>
