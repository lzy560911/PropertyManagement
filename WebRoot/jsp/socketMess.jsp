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
		var message = document.getElementById("message").value;
		
		if (message == "" || message == null) {
			alert("请填您所需要反馈的问题！");
			return false;
		}else{
			var url = "Socket!SocketSend?message="+message;
			alert("url is :"+url); 
			document.location.href =url;
		}
		
	}
</script>

</head>
<body class="main" style="background:#edf6fa;">
	<form action="Socket!SocketSend" method="post" >
		<input type="hidden" name="type" value="add">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<th align="center" colspan="2" height="30px">系统问题反馈</th>
			</tr>
			<tr>
				<td align="center">问题描述</td>
				<td><textarea id="message" name="message" cols="30" rows="3"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="40px"><input
					type="submit" value="反馈" id="submit1" onclick="return check()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置" id="submit1"></td>
			</tr>
		</table>
	</form>
</body>
</html>