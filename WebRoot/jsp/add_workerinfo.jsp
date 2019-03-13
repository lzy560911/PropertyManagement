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


<link href="css/style.css" rel="stylesheet" type="text/css" />

<script language="javascript" type="text/javascript"
	src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>

<script type="text/javascript">
	function check() {
		var name = document.getElementById("name").value;
		var sex = document.getElementById("sex").value;
		var cardnumber =document.getElementById("cardnumber").value;
		var phone = document.getElementById("phone").value;
		var reg = /^[\u4e00-\u9fa5]+$/;					//限制输入只能是的中文的正则表达式
		
		if (name == "" || name == null) {
			alert("请填写员工姓名！");
			return false;
		}else if(!reg.test(name)){
			alert("员工姓名 仅为中文！");
			return false;
		}else if (sex == "" || sex == null) {
			alert("请填写性别！");
			return false;
		}else if(sex != "男" && sex != "女"){
			alert("性别有误");
			return false;
		}else if (cardnumber == "" || cardnumber == null) {
			alert("请填写身份证号码！");
			return false;
		}else if (! /^\d{15}|\d{18}|\d{17}(\d|X|x)$/i.test(cardnumber)){
            alert("身份证输入有误！");
            return false;
        } else if (phone == "" || phone == null) {
			alert("请填写联系电话！");
			return false;
		}else if(!(/^1[3|5][0-9]\d{4,8}$/.test(phone))){ 
	        alert("不是完整的11位手机号或者正确的手机号前七位"); 
	        return false; 
	    } 
		return true;
	}
</script>

</head>
<body style="background:#edf6fa;">

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/lzy_property_manager" user="root"  password="root"/>
        <sql:query dataSource="${snapshot}" var="result">
        SELECT d_name from a_department;
</sql:query> 
	<form action="Worker!WorkerAdd.action" method="post" >
		<input type="hidden" name="type" value="add">
			<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
				<tr>
					<th align="center" colspan="2" height="30px">添加工作人员信息</th>
				</tr>
				<tr>
					<td align="center">姓名</td>
					<td><input type="text" name="worker.w_name" id="name"></td>
				</tr>
				<tr>
					<td align="center">性别</td>
					<td>
						<select size="1" name="worker.w_sex" id="sex">
							<option  value=" "  selected>请选择员工性别</option>
							<option  value="男">男</option>
							<option  value="女">女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center">身份证号码</td>
					<td><input type="text" name="worker.w_cardnumber" id="cardnumber"></td>
				</tr>
				<tr>
					<td align="center">联系电话</td>
					<td><input  type="text" name="worker.w_phone" id="phone"></td>
				</tr>
				<tr>
					<td align="center">所属部门</td>
					 <td>
					 <select size="1" name="worker.d_name" id="d_name">
	           			<c:forEach var="row" items="${result.rows}">
	           				<option  value="<c:out value="${row.d_name}"/>">${row.d_name}</option>
	           			</c:forEach>
       		 		</select>
       		 		</td> 
					<!-- <td><input type="text" name="worker.d_name" id="d_name" ></td> -->
				</tr>
				<tr>
					<td colspan="2" align="center" height="40px"><input
						type="submit" value="添加" id="submit1" onclick="return check()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置" id="submit1"></td>
				</tr>
			</table>
	</form>
	<p align="center" style="color:red;font-size:16px;">紫夜出品,仿冒必究！</p>
</body>
</html>