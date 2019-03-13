<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>业主报修界面</title>
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript">
	function check() {
		var name = document.getElementById("name").value;
		var phone = document.getElementById("phone").value;
		var message =document.getElementById("message").value;
		var reg = /^[\u4e00-\u9fa5]+$/;					//限制输入只能是的中文的正则表达式
		var pattern = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;//限制手机号码格式
		
		if (name == "" || name == null) {
			alert("请填写报修人姓名！");
			return false;
		} else if(!reg.test(name)){
			alert("姓名仅为中文！");
			return false;
		}else if (phone == "" || phone == null) {
			alert("请填写联系电话！");
			return false;
		}else if(!pattern.test(phone)){
			alert("联系电话格式有误");
			return false;
		}else if (message == "" || message == null) {
			alert("请填写备注！");
			return false;
		}
		return true;
	}
	
</script>
</head>
<body class="main" style="background:#edf6fa;">
	<h3 align="center">用户保修</h3>
	<form action="Repair!RepairAdd.action" method="post">
	<%-- <input type="hidden" name="apparatus.a_id" value="${a.a_id }"> --%>
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">报修门牌号</td>
				<td><input type="text" name="repair.h_house_number" value="${r.h_house_number }" readonly></td>
			</tr>
			<tr>
				<td align="center">报修人姓名</td>
				<td><input type="text" name="repair.r_name" id="name" value="${r.o_name }"></td>
			</tr>
			<tr>
				<td align="center">报修人联系方式</td>
				<td><input type="text" name="repair.r_phone" id="phone" value="${r.o_phone}"></td>
			</tr>
			<tr>
				<td align="center">报修时间</td>
				<td><input type="text" name="repair.r_time" id="time" value="<% out.print(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())); %>" readonly></td>
			</tr>
			<tr>
				<td align="center">报修备注</td>
				<td><input type="text" name="repair.r_message" id="message" value=""></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="40px"><input
					type="submit" value="提交" id="submit1" onclick="return check()">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
					value="重填" id="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>