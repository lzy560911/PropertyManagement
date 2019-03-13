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
<script type="text/javascript" src="../js/jquery.js"></script>

</head>
<body class="main" style="background:#edf6fa;">
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/lzy_property_manager" user="root"  password="root"/>
        <sql:query dataSource="${snapshot}" var="result">
        SELECT d_name from a_department;
</sql:query>
	<h3 align="center">修改工作人员信息</h3>
	<form action="Worker!WorkerUpdate.action" method="post">
	<input type="hidden" name="worker.w_id" value="${w.w_id}">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">员工姓名</td>
				<td><input type="text" name="worker.w_name" value="${w.w_name }" readonly></td>
			</tr>
			<tr>
				<td align="center">员工性别</td>
				<td><input type="text" name="worker.w_sex" value="${w.w_sex }" readonly></td>
			</tr>
			<tr>
				<td align="center">员工身份证号码</td>
				<td><input type="text" name="worker.w_cardnumber" value="${w.w_cardnumber }" readonly></td>
			</tr>
			<tr>
				<td align="center">员工联系电话</td>
				<td><input type="text" name="worker.w_phone" value="${w.w_phone }"></td>
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