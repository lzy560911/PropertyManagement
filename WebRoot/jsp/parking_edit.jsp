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
<title>Insert title here</title>

<script language="javascript" type="text/javascript"
	src="<%=path %>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	function check() {
		var name = document.getElementById("name").value;
		var housenumber = document.getElementById("house_number").value;
		var licenseplate =document.getElementById("oc_licenseplate").value;
		var time = document.getElementById("time").value;
		var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
		var reg = /^[\u4e00-\u9fa5]+$/;					//限制输入只能是的中文的正则表达式
		if (name == "" || name == null) {
			alert("请填写车主姓名！");
			return false;
		}else if(!reg.test(name)){
			alert("车主姓名仅为中文！");
			return false;
		}else if (housenumber == "" || housenumber == null) {
			alert("请填写车主门牌号！");
			return false;
		}else if (licenseplate == "" || licenseplate == null) {
			alert("请填写车牌号！");
			return false;
		}else if(licenseplate.length != 7){
			alert("请填写车牌号码长度有误！");
			return false;
		}else if(!express.test(licenseplate)){
			alert("车牌号码格式有误！");
			return false;
		}else if (time == "" || time == null) {
			alert("请填写时间");
			return false;
		} 
		return true;
	}
</script>
</head>
<body class="main" style="background:#edf6fa;">
	<h3 align="center">修改停车位信息22</h3>
	<form action="Parking!ParkingUpdate.action" method="post">
	<input type="hidden" name="parking.p_id" value="${p.p_id }">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">所属业主姓名</td>
				<td><input type="text" name="parking.p_name" value="${p.p_name }" id="name"></td>
			</tr>
			<tr>
				<td align="center">所属业主门牌号</td>
				<td><input type="text" name="parking.h_house_number" value="${p.h_house_number }" id="house_number"></td>
			</tr>
			<tr>
				<td align="center">车牌号</td>
				<td><input type="text" name="parking.oc_licenseplate" value="${p.oc_licenseplate }" id="oc_licenseplate"></td>
			</tr>
			<tr>
				<td align="center">出售时间</td>
				<td><input class="Wdate" id="time" type="text" name="parking.p_time" value="${p.p_time }" id="time"  onClick="WdatePicker()" ></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="40px">
				<input type="submit" value="提交" id="submit1" onclick="return check()">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="reset" value="重填" id="submit" ></td>
			</tr>
		</table>
	</form>
</body>
</html>