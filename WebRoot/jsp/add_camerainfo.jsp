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
		var name = document.getElementById("name").value;
		var gbid = document.getElementById("gbid").value;
		var state =document.getElementById("state").value;
		var time = document.getElementById("time").value;
		var reg = /^[\u4e00-\u9fa5]+$/;					//限制输入只能是的中文的正则表达式
		
		if (name == "" || name == null) {
			alert("请填写生产厂家！");
			return false;
		}else if(!reg.test(name)){
			alert("厂家名称仅为中文！");
			return false;
		}else if (gbid == "" || gbid == null) {
			alert("请填写国标编号！");
			return false;
		}else if(isNaN(gbid)){
			alert("国标编号为纯数字！");
			return false;
		}else if(gbid.length != 20){
			alert("国标编号为20位纯数字！");
			return false;
		}else if (state == "" || state == null) {
			alert("请填写摄像头状态！");
			return false;
		} else if(state != "维修中"&&state != "运行中"&&state != "未开机"){
			alert("请按照要求填写状态！");
			return false;
		}else if (time == "" || time == null) {
			alert("请填写安装时间");
			return false;
		}
		return true;
	}
</script>
<!-- <script type="text/javascript">
	$(document).ready(function(){
	    $("#gbid").blur(function(){
	    	alert("hello 1");
	      var gbid = $("#gbid").val();	//通过id获取
	      	alert("gbid is "+gbid)
    	  $.post("${pageContext.request.contextPath}/Login!findGBNum.action",{gbid:gbid},
    		      function(data){
    		  		alert(data);
    		        if(data.indexOf("notcanuseid")==-1){     //data 就是从action返回来的数据
    		        	$('#message').text("该国标编号可以正常使用");
    		        }else{
    		        	$('#message').text("对不起该国标编号已存在，请核对后再试"); 
    		        	$("input[name='camera.c_gbid']").val("").focus();
    		        }
    		      }
    		      ,"text");
    		        
    		    });
    		});
</script> -->
</head>
<body style="background:#edf6fa;">
	
	<form action="Camera!CameraAdd.action" method="post" >
		<input type="hidden" name="type" value="add">
			<table border="1" align="center" width="350px"  cellpadding="0" cellspacing="0">
				<tr>
					<th align="center" colspan="2" height="30px">添加摄像头信息</th>
				</tr>
				<tr>
					<td align="center">摄像头生产商</td>
					<td><input type="text" name="camera.c_name" id="name"></td>
				</tr>
				<tr>
					<td align="center">国标编号</td>
					<td><input type="text" name="camera.c_gbid" id="gbid"></td>
				</tr>
				<tr>
					<td align="center">工作状态</td>
					<!-- <td><input type="text" name="camera.c_state" id="state"></td> -->
					<td>
						<select id="state" name="camera.c_state">
							    <option value="维修中" selected="selected">维修中</option>
							    <option value="运行中">运行中</option>
							    <option value="未开机">未开机</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center">安装时间</td>
					<td><input class="Wdate" type="text" name="camera.c_time" id="time" onClick="WdatePicker()" readonly></td>
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