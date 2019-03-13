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
	<h3 align="center">修改业主信息</h3>
	<form action="Owner!OwnerUpdate.action" method="post">
	<input type="hidden" name="owner.o_id" value="${o.o_id }">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">业主姓名</td>
				<td><input type="text" name="owner.o_name" value="${o.o_name }" ></td>
			</tr>
			<tr>
				<td align="center">业主身份证号</td>
				<td><input type="text" name="owner.o_cardnumber" value="${o.o_cardnumber }" ></td>
			</tr>
			<tr>
				<td align="center">门牌号</td>
				<td><input type="text" name="owner.h_house_number" value="${o.h_house_number }"></td>
			</tr>
			<tr>
				<td align="center">联系电话</td>
				<td><input type="text" name="owner.o_phone" value="${o.o_phone }"></td>
			</tr>
			<tr>
				<td align="center">入住时间</td>
				<td><input class="Wdate" id="time" type="text" name="owner.o_time" value="${o.o_time }" onClick="WdatePicker()" ></td>
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