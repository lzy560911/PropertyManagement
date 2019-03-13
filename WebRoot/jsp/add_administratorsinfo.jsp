<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script language="javascript" type="text/javascript"
	src="../js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	function check() {
		var name = document.getElementById("name").value;
		var pass = document.getElementById("pass").value;
		var phone =document.getElementById("phone").value;
		var pattern = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
		if (name == "" || name == null) {
			alert("请填账号！");
			return false;
		}else if (pass == "" || pass == null) {
			alert("请填写密码！");
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
		}
		return true;
	}
</script>

</head>
<body class="main">
	<form action="Administrators!AdministratorsAdd.action" method="post" >
		<input type="hidden" name="type" value="add">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<th align="center" colspan="2" height="30px">添加管理员信息</th>
			</tr>
			<tr>
				<td align="center">登陆账号</td>
				<td><input type="text" value="0" name="administrators.A_name" id="name"></td>
			</tr>
			<tr>
				<td align="center">登陆密码</td>
				<td><input type="text" value="0" name="administrators.A_password" id="pass"></td>
			</tr>
			<tr>
				<td align="center">注册手机号</td>
				<td><input type="text" value="0" name="administrators.A_phone" id="phone"></td>
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