<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加出售房屋信息</title>
<script type="text/javascript" src="../js/jquery.js"></script>
<script language="javascript" type="text/javascript"
	src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		    $("#housenumber").blur(function(){
		      var houseNum = $("#housenumber").val();	//通过id获取
	    	  $.post("${pageContext.request.contextPath}/Home!findHouseNum.action",{houseNum:houseNum},
	    		      function(hm){
	    		        if(hm.indexOf("yicunzai")==-1){     //data 就是从action返回来的数据
	    		        	$('#message').text("");
	    		        }else{
	    		        	$('#message').text("对不起该门牌号已存在"); 
	    		        	$("input[name='home.h_house_number']").val("").focus();
	    		        }
	    		      }
	    		      ,"text");
	    		        
	    		    });
	    		});
</script>

<script type="text/javascript">
	function check() {
		var housenumber = document.getElementById("housenumber").value;
		var state = document.getElementById("state").value;
		var houseNumRule = /[0-9][0-9]-[0-9][1-9]-[1-9][0-9][1-9]/;
		if (housenumber == "" || housenumber == null) {
			alert("请填写房屋门牌号！");
			return false;
		}else if(!houseNumRule.test(housenumber)){
			alert("请输入正确的门牌号");
			return false;
		}
		else if (state == "" || state == null) {
			alert("请填写房屋状态！");
			return false;
		}else if (state != "待出售") {
			alert("房屋状态只能是“待出售”状态！");
			return false;
		}
		return true;
	}
	
</script>

</head>
<body class="main" style="background:#edf6fa;">
	<form action="Home!HomeAdd.action" method="post" >
		<input type="hidden" name="type" value="add">
		<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
			<tr>
				<th align="center" colspan="2" height="30px">添加小区房屋信息</th>
			</tr>
			<tr>
				<td align="center">房屋门牌号</td>
				<td><input type="text" placeholder="XX-XX-XXX" class="housenumber" name="home.h_house_number" id="housenumber"></td>
			</tr>
			<tr>
				<td align="center">房屋当前状态</td>
				<!-- <td><input type="text" value="0" name="home.h_state" id="state" readonly>待出售</td> -->
				<td>
					<select id="state" name="home.h_state" >
						    <option value="待出售" selected="selected">待出售</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="40px"><input
					type="submit" value="添加" id="submit1" onclick="return check()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置" id="submit1"></td>
			</tr>
		</table>
	</form>
	<p style="color:red;" align="center" id="message"></p>
	<p align="center" style="color:red;font-size:16px;">注：添加房屋信息默认状态为待入住</p>
	<p align="center" style="color:red;font-size:16px;">房屋门牌号格式为xx(楼号)-xx(单元号)-xxx(门牌号)</p>
</body>
</html>