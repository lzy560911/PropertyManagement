<%@ page import="java.util.*"%>
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
<script type="text/javascript">
	$(document).ready(function(){
		alert("11");
	    $("#oc_licenseplate").blur(function(){
	      var carNum = $("#oc_licenseplate").val();	//通过id获取
	      alert("carNum");
    	  $.post("${pageContext.request.contextPath}/Cars!findCarsNum.action",{carNum:carNum},
    		      function(data){
    		        if(data.indexOf("ruolin")==-1){     //data 就是从action返回来的数据
    		        	$('#message').text("车牌号已存在");
    		        	$("input[name='cars.oc_licenseplate']").val("").focus();
    		        }else{
    		        	$('#message').text("可以使用"); 
    		        }
    		      }
    		      ,"text");
    		        
    		    });
    		});
</script>
<script type="text/javascript">
	function check() {
		var name = document.getElementById("name").value;
		var color = document.getElementById("color").value;
		var licenseplate =document.getElementById("oc_licenseplate").value;
		var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
		var reg = /^[\u4e00-\u9fa5]+$/;					//限制输入只能是的中文的正则表达式
		
		if (name == "" || name == null) {
			alert("请填写车辆品牌！");
			return false;
		} else if(!reg.test(name)){
			alert("品牌仅为中文！");
			return false;
		}else if (color == "" || color == null) {
			alert("请填写车辆颜色！");
			return false;
		}else if (!reg.test(color)) {
			alert("车辆颜色仅为汉字！");
			return false;
		}else if (licenseplate == "" || licenseplate == null) {
			alert("请填写车牌号！");
			return false;
		}else if(licenseplate.length != 7){
			alert("车牌号码长度有误！");
			return false;
		}else if(!express.test(licenseplate)){
			alert("车牌号码格式有误！");
			return false;
		}
		return true;
	}
	
</script>

</head>
<body class="main" style="background:#edf6fa;">
<!-- <input type="button" onclick="showMonth()" value="查看当前月份"> -->
<% 
    Calendar calendar=Calendar.getInstance();
    int month=calendar.get(Calendar.MONTH)+1;
 %> 
	<form action="Cars!CarsAdd?month=<%=month%>" method="post" >
		<input type="hidden" name="type" value="add">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<th align="center" colspan="2" height="30px">添加业主车辆信息</th>
			</tr>
			<tr>
				<td align="center">车辆品牌</td>
				<td><input type="text" value="0" name="cars.oc_name" id="name"></td>
			</tr>
			<tr>
				<td align="center">车辆颜色</td>
				<td><input type="text" value="0" name="cars.oc_color" id="color"></td>
			</tr>
			<tr>
				<td align="center">车牌号</td>
				<td><input type="text" value="0" name="cars.oc_licenseplate" id="oc_licenseplate"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="40px">
				<input type="submit" value="添加" id="submit1" onclick="return check()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置" id="submit1"></td>
			</tr>
		</table>
	</form>
	<p align="center"><span style="color:red;" id="message"></span></p>
</body>
</html>