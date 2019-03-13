<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script language="javascript" type="text/javascript"
	src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>

</head>
<body class="main" style="background:#edf6fa;">
	<h3 align="center">修改部门信息</h3>
	<form action="Department!DepartmentUpdate.action" method="post">
	<input type="hidden" name="department.d_id" value="${d.d_id }">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">部门名称</td>
				<td><input type="text" name="department.d_name" value="${d.d_name }" readonly></td>
			</tr>
			<tr>
				<td align="center">部门负责人</td>
				<td><input type="text" name="department.d_leader" value="${d.d_leader }"></td>
			</tr>
			<tr>
				<td align="center">负责人联系电话</td>
				<td><input type="text" name="department.d_phone" value="${d.d_phone }"></td>
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