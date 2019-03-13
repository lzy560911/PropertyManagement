<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
	$(document).ready(function(){
	    $("#cardnumber").blur(function(){
	      var carNum = $("#cardnumber").val();	//通过id获取
    	  $.post("${pageContext.request.contextPath}/Login!findCardNum.action",{carNum:carNum},
    		      function(data){
    		        if(data.indexOf("notcanuse")==-1){     //data 就是从action返回来的数据
    		        	$('#message').text("该身份证号可以正常使用");
    		        }else{
    		        	$('#message').text("对不起该身份证号码已存在，请核对后再试"); 
    		        	$("input[name='owner.o_cardnumber']").val("").focus();
    		        }
    		      }
    		      ,"text");
    		        
    		    });
    		});
</script>
<script type="text/javascript">
	function check() {
		var name = document.getElementById("name").value;
		var cardnumber = document.getElementById("cardnumber").value;
		var phone =document.getElementById("phone").value;
		var time = document.getElementById("time").value;
		var house_number = document.getElementById("h_house_number").value;
		var reg = /^[\u4e00-\u9fa5]+$/;					//限制输入只能是的中文的正则表达式
		
		if (name == "" || name == null) {
			alert("请填写业主姓名！");
			return false;
		}else if(!reg.test(name)){
			alert("业主姓名仅为中文！");
			return false;
		}else if (cardnumber == "" || cardnumber == null) {
			alert("请填写业主身份证号码！");
			return false;
		}else if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(cardnumber)) ){
            alert("身份证输入有误！");
            return false;
        } else if (phone == "" || phone == null) {
			alert("请填写业主联系电话！");
			return false;
		}else if(!(/^1[3|5][0-9]\d{4,8}$/.test(phone))){ 
	        alert("不是完整的11位手机号或者正确的手机号前七位"); 
	        return false; 
	    } else if (time == "" || time == null) {
			alert("请填写入住时间");
			return false;
		}else if (house_number == "" || house_number == null) {
			alert("请填写门牌号");
			return false;
		}
		return true;
	}
</script>

</head>
<body style="background:#edf6fa;">
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/lzy_property_manager?characterEncoding=utf-8" user="root"  password="root"/>
       <sql:query dataSource="${snapshot}" var="result">
       SELECT h_house_number from a_house where h_state = "待出售"
</sql:query>
	<form action="Owner!OwnerAdd.action" method="post" >
		<input type="hidden" name="type" value="add">
			<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
				<tr>
					<th align="center" colspan="2" height="30px">添加业主信息</th>
				</tr>
				<tr>
					<td align="center">业主姓名</td>
					<td><input type="text" name="owner.o_name" id="name"></td>
				</tr>
				<tr>
					<td align="center">身份证号码</td>
					<td><input type="text" name="owner.o_cardnumber" id="cardnumber"></td>
				</tr>
				<tr>
					<td align="center">门牌号</td>
					<!-- <td><input type="text" name="owner.h_house_number" id="house_number"></td> -->
					<td>
						 <select size="1" name="owner.h_house_number" id="h_house_number">
		           			<c:forEach var="row" items="${result.rows}">
		           				<option  value="<c:out value="${row.h_house_number}"/>">${row.h_house_number}</option>
		           			</c:forEach>
	       		 		</select>
       		 		</td> 
				</tr>
				<tr>
					<td align="center">联系电话</td>
					<td><input type="text" name="owner.o_phone" id="phone"></td>
				</tr>
				<tr>
					<td align="center">入住时间</td>
					<td><input class="Wdate" type="text" name="owner.o_time" id="time" onClick="WdatePicker()" readonly></td>
				</tr>
				<tr>
					<td align="center">水电费缴纳</td>
					<td><input type="text" name="owner.o_state" id="state" value="0" readonly></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center" height="40px"><input
						type="submit" value="添加" id="submit1" onclick="return check()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置" id="submit1"></td>
				</tr>
			</table>
	</form>
	<p align="center"><span style="color:red;" id="message"></span></p>
</body>
</html>