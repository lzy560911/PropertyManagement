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

</head>
<body class="main" style="background:#edf6fa;">
	<h3 align="center">修改管理员信息</h3>
	<form action="Administrators!AdministratorsUpdate.action" method="post">
	<input type="hidden" name="administrators.A_id" value="${a.a_id }">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">管理员账号</td>
				<td><input type="text" name="administrators.A_name" value="${a.a_name }" readonly></td>
			</tr>
			<tr>
				<td align="center">管理员密码</td>
				<td><input type="text" name="administrators.A_password" value="${a.a_password }"></td>
			</tr>
			<tr>
				<td align="center">注册手机号</td>
				<td><input type="text" name="administrators.A_phone" value="${a.a_phone }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="40px"><input
					type="submit" value="提交" id="submit1">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
					value="重填" id="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>