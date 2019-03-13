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
		var house_number = document.getElementById("house_number").value;
		var name = document.getElementById("name").value;
		var phone = document.getElementById("phone").value;
		var message =document.getElementById("message").value;
		var time = document.getElementById("time").value;
		var reg = /^[\u4e00-\u9fa5]+$/;					//限制输入只能是的中文的正则表达式
		var pattern = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
		
		if(house_number == "" || house_number == null){
			alert("请填写门牌号！");
			return false;
		}else if (name == "" || name == null) {
			alert("请填写保修人姓名！");
			return false;
		}else if(!reg.test(name)){
			alert("姓名仅为中文！");
			return false;
		}else if (phone == "" || phone == null) {
			alert("请填写联系人手机号码");
			return false;
		}else if(!pattern.test(phone)){
			alert("手机号码格式有误！");
			return false;
		}else if (message == "" || message == null) {
			alert("请填写保修备注！");
			return false;
		}else if (time == "" || time == null) {
			alert("请选择保修时间");
			return false;
		}
		return true;
	}
</script>

</head>
<body style="background:#edf6fa;">
	
	<form action="Repair!RepairAdd.action" method="post" >
		<input type="hidden" name="type" value="add">
			<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
				<tr>
					<th align="center" colspan="2" height="30px">添加保修信息</th>
				</tr>
				<tr>
					<td align="center">门牌号</td>
					<td><input type="text" name="repair.h_house_number" id="house_number"></td>
				</tr>
				<tr>
					<td align="center">保修人姓名</td>
					<td><input type="text" name="repair.r_name" id="name"></td>
				</tr>
				<tr>
					<td align="center">保修人联系电话</td>
					<!-- <td><input type="text" name="camera.c_state" id="state"></td> -->
					<td><input type="text" name="repair.r_phone" id="phone"></td>
				</tr>
				
				<tr>
					<td align="center">保修内容(备注)</td>
					<!-- <td><input type="text" name="camera.c_state" id="state"></td> -->
					<td><input type="text" name="repair.r_message" id="message"></td>
				</tr>
				
				<tr>
					<td align="center">保修时间</td>
					<td><input class="Wdate" type="text" name="repair.r_time" id="time" onClick="WdatePicker()" readonly></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center" height="40px"><input
						type="submit" value="添加" id="submit1" onclick="return check()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置" id="submit1"></td>
				</tr>
			</table>
	</form>
</body>
</html>