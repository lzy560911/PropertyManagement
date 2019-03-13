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
		var manufacturer = document.getElementById("manufacturer").value;
		var state =document.getElementById("state").value;
		var time = document.getElementById("time").value;
		var reg = /^[\u4e00-\u9fa5]+$/;					//限制输入只能是的中文的正则表达式
		
		if (name == "" || name == null) {
			alert("请填写健身器名称！");
			return false;
		} else if(!reg.test(name)){
			alert("厂家名称仅为中文！");
			return false;
		}else if (manufacturer == "" || manufacturer == null) {
			alert("请填写生产厂商！");
			return false;
		} else if(!reg.test(manufacturer)){
			alert("厂商名称仅为中文！");
			return false;
		}else if (state == "" || state == null) {
			alert("请填写健身器当前状态！");
			return false;
		} else if(state != "维修中"&&state != "使用中"&&state != "待安装"){
			alert("请按照要求填写状态！");
			return false;
		}else if (time == "" || time == null) {
			alert("请填写安装时间");
			return false;
		} 
		return true;
	}
</script>

</head>
<body class="main" style="background:#edf6fa;">
	<form action="Apparatus!ApparatusAdd.action" method="post" >
		<input type="hidden" name="type" value="add">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0"
		>
			<tr>
				<th align="center" colspan="2" height="30px">添加健身器材信息</th>
			</tr>
			<tr>
				<td align="center">健身器名称</td>
				<td><input type="text" name="apparatus.a_name" id="name"></td>
			</tr>
			<tr>
				<td align="center">当前状态</td>
				<!-- <td><input type="text" name="apparatus.a_state" id="state"></td> -->
				<td>
						<select id="state" name="apparatus.a_state">
							    <option value="维修中" selected="selected">维修中</option>
							    <option value="使用中">使用中</option>
							    <option value="待安装">待安装</option>
						</select>
				</td>
			</tr>
			<tr>
				<td align="center">生产厂商</td>
				<td><input type="text" name="apparatus.a_manufacturer" id="manufacturer"></td>
			</tr>
			<tr>
				<td align="center">安装时间</td>
				<td><input class="Wdate" type="text" name="apparatus.a_time" id="time" onClick="WdatePicker()" readonly></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center" height="40px"><input
					type="submit" value="添加" id="submit1" onclick="return check()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置" id="submit1"></td>
			</tr>
		</table>
	</form>
	<p align="center" style="color:red;font-size:16px;">注：健身器状态只能填写"维修中"、"使用中"、"待安装"</p>
</body>
</html>