<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>生成维修凭证</title>


<link href="<%=path %>css/style.css" rel="stylesheet" type="text/css" />

<script language="javascript" type="text/javascript"
	src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>

<script type="text/javascript">
	function check() {
		var workname = document.getElementById("workname").value;
		var money = document.getElementById("money").value;
		var time = document.getElementById("time").value;
		var reg = /^[\u4e00-\u9fa5]+$/;					//限制输入只能是的中文的正则表达式
		var num =  /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/;//限制输入只能是大于0且小于99999999.99的数字
		//限制时间格式
		var reDateTime = /^(?:19|20)[0-9][0-9]-(?:(?:0[1-9])|(?:1[0-2]))-(?:(?:[0-2][1-9])|(?:[1-3][0-1])) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]:[0-5][0-9]$/;
		if (workname == "" || workname == null) {
			alert("请填维修人员姓名！");
			return false;
		}else if(!reg.test(workname)){
			alert("姓名为中文！");
			return false;
		}else if (money == "" || money == null) {
			alert("请填写维修费用");
			return false;
		}else if(!num.test(money)){
			alert("维修费用仅为数字！");
			return false;
		}else if (time == "" || time == null) {
			alert("请填完成时间");
			return false;
		}
		return true;
	}
</script>

</head>
<body style="background:#edf6fa;">
	
	<form action="Repair!RepairPrint.action" method="post" >
		<input type="hidden" name="type" value="add">
			<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
				<tr>
					<th align="center" colspan="2" height="30px">添加凭证信息</th>
				</tr>
				<tr>
					<td align="center">维修门牌号</td>
					<td><input type="text" name="maintenancePayment.h_house_number" id="housenum" value="${repair.h_house_number}" readonly></td>
				</tr>
				<tr>
					<td align="center">报修人姓名</td>
					<td><input type="text" name="maintenancePayment.m_name" id="name" value="${repair.r_name}" readonly></td>
				</tr>
				<tr>
					<td align="center">报修人联系方式</td>
					<td><input type="text" name="maintenancePayment.m_phone" id="phone" value="${repair.r_phone}" readonly></td>
				</tr>
				<tr>
					<td align="center">维修工人姓名</td>
					<td><input type="text" name="maintenancePayment.m_work" id="workname"></td>
				</tr>
				<tr>
					<td align="center">维修费用</td>
					<td><input type="text" name="maintenancePayment.m_money" id="money"></td>
				</tr>
				<tr>
					<td align="center">完成时间</td>
					<td><input type="text" name="maintenancePayment.m_time" id="time" value="<% out.print(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); %>"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center" height="40px"><input
						type="submit" value="添加" id="submit1" onclick="return check()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置" id="submit1"></td>
				</tr>
			</table>
	</form>
	<p align="center" style="color:red;font-size:16px;"></p>
</body>
</html>