<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.io.*,java.util.*,java.sql.*"%>
<%@page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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
		var housenumber = document.getElementById("house_number").value;
		var licenseplate =document.getElementById("oc_licenseplate").value;
		var time = document.getElementById("time").value;
		var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
		var reg = /^[\u4e00-\u9fa5]+$/;					//限制输入只能是的中文的正则表达式
		if (name == "" || name == null) {
			alert("请填写车主姓名！");
			return false;
		}else if(name == "0"&&housenumber=="0"&&licenseplate=="0"&&time=="0"){
			return true;
		} else if(!reg.test(name)){
			alert("车主姓名仅为中文！");
			return false;
		}else if (housenumber == "" || housenumber == null) {
			alert("请填写车主门牌号！");
			return false;
		}else if (licenseplate == "" || licenseplate == null) {
			alert("请填写车牌号！");
			return false;
		}else if(licenseplate.length != 7){
			alert("请填写车牌号码长度有误！");
			return false;
		}else if(!express.test(licenseplate)){
			alert("车牌号码格式有误！");
			return false;
		}else if (time == "" || time == null) {
			alert("请填写时间");
			return false;
		} 
		return true;
	}
</script>

</head>
<body class="main" style="background:#edf6fa;">

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/lzy_property_manager" user="root"  password="root"/>
        <sql:query dataSource="${snapshot}" var="result">
        SELECT oc_licenseplate from a_owner_car;
</sql:query> 
<% 
    Calendar calendar=Calendar.getInstance();
    int month=calendar.get(Calendar.MONTH)+1;
 %>
	<form action="Parking!ParkingAdd?month=<%= month %>" method="post" >
		<input type="hidden" name="type" value="add">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<th align="center" colspan="2" height="30px">添加车位信息</th>
			</tr>
			<tr>
				<td align="center">所属业主姓名</td>
				<td><input type="text" value="0" name="parking.p_name" id="name"></td>
			</tr>
			<tr>
				<td align="center">门牌号</td>
				<td><input type="text" value="0" name="parking.h_house_number" id="house_number"></td>
			</tr>
			<tr>
				<td align="center">车牌号</td>
				<td>
					 <select size="1" name="parking.oc_licenseplate" id="oc_licenseplate">
					 		<option value="0">0</option>
	           			<c:forEach var="row" items="${result.rows}">
	           				<option  value="<c:out value="${row.oc_licenseplate}"/>">${row.oc_licenseplate}</option>
	           			</c:forEach>
       		 		</select>
       		 	</td> 
				<!-- <td><input type="text" value="0" name="parking.oc_licenseplate" id="oc_licenseplate"></td> -->
			</tr>
			<tr>
				<td align="center">出售时间</td>
				<td><input class="Wdate" type="text" value="0" name="parking.p_time" id="time" onClick="WdatePicker()" readonly></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="40px"><input
					type="submit" value="添加" id="submit1" onclick="return check()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置" id="submit1"></td>
			</tr>
		</table>
	</form>
	<p align="center" style="color:red;font-size:16px;">注：若添加的是空位车，直接点击添加即可</p>
	<p align="center" style="color:red;font-size:16px;">空车位的各个信息默认为0</p>
</body>
</html>