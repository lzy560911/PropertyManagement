<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>


<link href="css/style.css" rel="stylesheet" type="text/css" />

<script language="javascript" type="text/javascript"
	src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>

<script type="text/javascript">
	function check() {
		var name = document.getElementById("name").value;
		var leader = document.getElementById("leader").value;
		var phone =document.getElementById("phone").value;
		var reg = /^[\u4e00-\u9fa5]+$/;					//限制输入只能是的中文的正则表达式
		var pattern = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
		
		if (name == "" || name == null) {
			alert("请填写部门名称！");
			return false;
		}else if(!reg.test(name)){
			alert("部门名称仅为中文！");
			return false;
		}else if (leader == "" || leader == null) {
			alert("请填写部门主管！");
			return false;
		}else if(!reg.test(name)){
			alert("部门主管名字仅为中文！！");
			return false;
		}else if (phone == "" || phone == null) {
			alert("请填写手机号码！");
			return false;
		}else if (phone.length != 11) {
			alert("手机号码位数有误！");
			return false;
		}else if(!pattern.test(phone)){
			alert("手机号码格式有误！");
			return false;
		} 
		return true;
	}
</script>

</head>
<body style="background:#edf6fa;">
	
	<form action="Department!DepartmentAdd.action" method="post" >
		<input type="hidden" name="type" value="add">
			<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
				<tr>
					<th align="center" colspan="2" height="30px">添加部门信息</th>
				</tr>
				<tr>
					<td align="center">部门名称</td>
					<td><input type="text" name="department.d_name" id="name"></td>
				</tr>
				<tr>
					<td align="center">部门负责人</td>
					<td><input type="text" name="department.d_leader" id="leader"></td>
				</tr>
				<tr>
					<td align="center">负责人联系电话</td>
					<td><input type="text" name="department.d_phone" id="phone"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center" height="40px"><input
						type="submit" value="添加" id="submit1" onclick="return check()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置" id="submit1"></td>
				</tr>
			</table>
	</form>
	<p align="center" style="color:red;font-size:16px;">注：摄像头工作状态只能填写"维修中"、"运行中"、"未开机"</p>
</body>
</html>