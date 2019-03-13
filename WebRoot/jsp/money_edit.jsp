<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script language="javascript" type="text/javascript"
	src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>

<script type="text/javascript">
	function check() {
		var should = document.getElementById("should").value;
		var real = document.getElementById("real").value;
		
		if (should == "" || should == null) {
			alert("请填写应缴纳金额！");
			return false;
		}else if(isNaN(should)){
			alert("缴费金额为数字！");
			return false;
		}else if (real == "" || real == null) {
			alert("请填写实际缴纳金额！");
			return false;
		}else if(isNaN(real)){
			alert("缴费金额为数字！");
			return false;
		}else if(parseFloat(real) < parseFloat(should)){
			alert("实际缴费金额应大于或等于应缴纳金额！");
			return false;
		}
		return true;
	}
</script>
</head>
<body class="main" style="background:#edf6fa;">
	<h3 align="center">水电费缴纳</h3>
	<form action="Pay!PayAdd.action" method="post">
	<input type="hidden" name="pay.p_id" value="${m.o_id }">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">业主姓名</td>
				<td><input type="text" name="pay.p_name" value="${m.o_name }" readonly></td>
			</tr>
			<tr>
				<td align="center">门牌号</td>
				<td><input type="text" name="pay.h_house_number" value="${m.h_house_number }" readonly></td>
			</tr>
			<tr>
				<td align="center">联系电话</td>
				<td><input type="text" name="pay.p_phone" value="${m.o_phone }" readonly></td>
			</tr>
			<tr>
				<td align="center">应缴金额</td>
				<td><input type="text" name="pay.p_should" id="should"></td>
			</tr>
			<tr>
				<td align="center">实缴金额</td>
				<td><input type="text" name="pay.p_real" id="real"></td>
			</tr>
			<tr>
				<td align="center">缴费时间</td>
				<td><input class="Wdate" id="time" type="text" name="pay.p_time" value=<%=sdf.format(new Date())%> readonly></td>
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