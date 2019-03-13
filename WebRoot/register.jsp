<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>欢迎注册物业管理平台</title>
<link href="css/style2.css" rel="stylesheet" type="text/css" />
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
	$(document).ready(function(){
	    $("#loginuser").blur(function(){
	      var Name = $("#loginuser").val();	//通过id获取
	      if(Name == "" || Name == null){
	    	  $('#message').text("账号不可为空!");
	      }else{
    	  $.post("${pageContext.request.contextPath}/Login!findUserName.action",{UserName:Name},
    		      function(data){
    		        if(data.indexOf("false")==-1){     //data 就是从action返回来的数据
    		        	$('#message').text("恭喜您账号可以注册");
    		        }else{
    		        	$('#message').text("对不起该账号已经被注册"); 
    		        	$("input[name='administrators.A_name']").val("").focus();
    		        }
    		      }
    		      ,"text");
	      }
    		    });
    		});
	      
	$(document).ready(function(){
	    $("#loginphone").blur(function(){
	      var Phone = $("#loginphone").val();	//通过id获取
	      if(Phone == "" || Phone == null){
	    	  $('#message').text("手机号不可为空!");
	      }else{
    	  $.post("${pageContext.request.contextPath}/Login!findPhone.action",{Phone:Phone},
    		      function(phone){
    		        if(phone.indexOf("not")==-1){     //data 就是从action返回来的数据
    		        	$('#message').text("恭喜您该手机号可以注册");
    		        }else{
    		        	$('#message').text("对不起该手机号已经被注册"); 
    		        	$("input[name='administrators.A_phone']").val("").focus();
    		        }
    		      }
    		      ,"text");
	      }   
    		    });
    		});
		
</script>
<script type="text/javascript">
	function check() {
		var name = document.getElementById("loginuser").value;
		var pass = document.getElementById("loginpwd").value;
		var phone =document.getElementById("loginphone").value;
		var security = document.getElementById("security").value;
		var pattern = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
		var usern = /^[a-zA-Z0-9]{1,}$/; 
		if (name == "" || name == null) {
			alert("请填账号！");
			return false;
		}else if(name.length<4||name.length>8){
			alert("账号位数为4-8位");
			return false;
		}else if(!usern.test(name)){
			alert("账号仅支持字母数字!");
			return false;
		}else if (pass == "" || pass == null) {
			alert("请填写密码！");
			return false;
		}else if(pass.length<4||pass.length>8){
			alert("密码位数为4-8位");
			return false;
		}else if(!usern.test(pass)){
			alert("密码仅支持字母数字!");
			return false;
		}else if (phone == "" || phone == null) {
			alert("请填写注册手机号！");
			return false;
		}else if(phone.length != 11){
			alert("手机号码长度有误！");
			return false;
		}else if(!pattern.test(phone)){
			alert("手机号码格式有误！");
			return false;
		}else if (security == "" || security == null) {
			alert("请填密保问题！");
			return false;
		}else if(security.length=0||security.length>8){
			alert("密保位数为1-8位");
			return false;
		}
		return true;
	}
</script>
</head>
  <body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
     <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>
	<div class="logintop">    
    	<span>欢迎注册紫夜小区物业管理平台</span>    
    	<ul>
    	<li><a href="#">联系我们</a></li>
   	 	<li><a href="#">帮助</a></li>
   	 	<li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <form action="Administrators!AdministratorsAdd.action" method="post" >
	    <div class="loginbody">
	    <span class="systemlogo"></span> 
	    	<div class="registerbox">
	    		<ul>
	    			<li><span style="color:red;" id="message"></span></li>
	    			<li>请输入账号：<input name="administrators.A_name" id="loginuser" type="text" class="loginuser" placeholder="请输入您的账号" autocomplete="off"/></li>
	    			<!-- placeholder="请输入您的账号" html5的属性，文本框内的提示语句 -->
	    			<li>请输手机号：<input name="administrators.A_phone" id="loginphone" type="text" class="loginphone" placeholder="请输入您的手机号码" autocomplete="off"/></li>
	    			<li>请输入密码：<input name="administrators.A_password" id="loginpwd" type="password" class="loginpwd" placeholder="请输入您的密码" autocomplete="off"/></li>
	    			<li>请输入密保：<input name="administrators.A_security" id="security" type="text" class="security" placeholder="您母亲的名字是什么？" autocomplete="off"/></li>
	   				 <li class="login">
	    				<input name="" type="submit" class="loginbtn" value="注册"  onclick="return check()"/>
	    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    				<input name="" type="reset" class="loginbtn" value="重填"  onclick=""  />
	    			</li>
	    		</ul>
	    	</div>
	    </div>
    </form>
    <div class="loginbm">版权所有  2018 <a href="https://user.qzone.qq.com/502560911/infocenter">李子叶彡</a> </div>
	
  </body>
</html>
