<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改摄像头信息</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript"
	src="<%=path %>/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript">
	function check() {
		var name = document.getElementById("name").value;
		var gbid = document.getElementById("gbid").value;
		var state =document.getElementById("state").value;
		var time = document.getElementById("time").value;
		var reg = /^[\u4e00-\u9fa5]+$/;					//限制输入只能是的中文的正则表达式
		
		if (name == "" || name == null) {
			alert("请填写生产厂家！");
			return false;
		}else if(!reg.test(name)){
			alert("厂家名称仅为中文！");
			return false;
		}else if (gbid == "" || gbid == null) {
			alert("请填写国标编号！");
			return false;
		}else if(isNaN(gbid)){
			alert("国标编号为纯数字！");
			return false;
		}else if(gbid.length != 20){
			alert("国标编号为20位纯数字！");
			return false;
		}else if (state == "" || state == null) {
			alert("请填写摄像头状态！");
			return false;
		} else if(state != "维修中"&&state != "运行中"&&state != "未开机"){
			alert("请按照要求填写状态！");
			return false;
		}else if (time == "" || time == null) {
			alert("请填写安装时间");
			return false;
		}
		return true;
	}
</script>
</head>
<body class="main" style="background:#edf6fa;">
	<h3 align="center">修改摄像头信息</h3>
	<form action="Camera!CameraUpdate.action" method="post">
	<input type="hidden" name="camera.c_id" value="${c.c_id }">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">摄像头生产厂家</td>
				<td><input id="name" type="text" name="camera.c_name" value="${c.c_name }"></td>
			</tr>
			<tr>
				<td align="center">国标编号</td>
				<td><input id="gbid" type="text" name="camera.c_gbid" value="${c.c_gbid }"></td>
			</tr>
			<tr>
				<td align="center">当前状态</td>
				<td>
					<input type="text" id="state" name="camera.c_state" value="${c.c_state}">
					<%-- <select size="1" name="camera.c_state" id="state">
							<option  value="${c.c_state}"  selected>维修中</option>
							<option  value="${c.c_state}">运行中</option>
							<option  value="${c.c_state}">未开机</option>
					</select> --%>
				</td>
			</tr>
			<tr>
				<td align="center">安装时间</td>
				<td><input class="Wdate" type="text" name="camera.c_time" id="time" value="${c.c_time}" onClick="WdatePicker()" readonly></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="40px"><input
					type="submit" value="提交" id="submit1" onclick="return check()">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="reset" value="重填" id="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>