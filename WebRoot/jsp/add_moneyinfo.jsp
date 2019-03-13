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
		var should = document.getElementById("should").value;
		var real = document.getElementById("real").value;
		if (should == "" || should == null) {
			alert("请填写应激金额！");
			return false;
		}else if(isNaN(should)){
			alert("金额仅为数字！");
			return false;
		}else if (real == "" || real == null) {
			alert("请填写实际缴费金额！");
			return false;
		}else if(isNaN(real)){
			alert("金额仅为数字！");
			return false;
		}else if(real < should){
			alert("实际缴费金额应大于或等于应缴金额");
			return false;
		}
		return true;
	}
</script>
</head>
<body style="background:#edf6fa;">
	
	<form action="Camera!CameraAdd.action" method="post" >
		 <input type="hidden" name="type" value="add">
			<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
				<tr>
					<th align="center" colspan="2" height="30px">水电费缴纳</th>
				</tr>
				<tr>
					<td align="center">业主姓名</td>
					<td><input type="text" name="" id="name" value="${m.o_name }" readonly></td>
				</tr>
				<tr>
					<td align="center">门牌号</td>
					<td><input type="text" name="" id="gbid" value="${m.h_house_number }" readonly></td>
				</tr>
				<tr>
					<td align="center">联系电话</td>
					<td><input type="text" name="" id="state" value="${m.o_phone }" readonly></td>
				</tr>
				<tr>
					<td align="center">应缴金额</td>
					<td><input type="text" name="" id="should"></td>
				</tr>
				<tr>
					<td align="center">实缴金额</td>
					<td><input type="text" name="" id="real"></td>
				</tr>
				<tr>
					<td align="center">缴费时间</td>
					<td><input class="Wdate" type="text" name="" id="time" onClick="WdatePicker()" readonly></td>
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