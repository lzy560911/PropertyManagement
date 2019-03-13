<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		  $(".click").click(function(){
		  $(".tip").fadeIn(200);
		  });
	});
</script>
<!-- 针对IE浏览器的打印 -->
<%-- <script language=javascript>   
	function printpreview(){
		  // 打印页面预览
		  WebBrowser.Execwb(7,1);
	}
	
	function printit(){
		 if (confirm('确定打印吗？')){
			WebBrowser.Execwb(6,1);
		 }
	}
</script> --%>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
	    <li>首页</li>
	    <li>水电费缴纳</li>
	    <li>打印缴费凭证</li>
    </ul>
    </div>
    
<div class="rightinfo">
<!-- 针对IE浏览器的打印界面 -->
   <!--  <div class="noprint" style="width:640px;height:20px;margin:100px auto 0 auto;font-size:12px;text-align:right;">
	    <OBJECT id="WebBrowser" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb"></OBJECT>
	    <input value="打印" type="button" onclick="javascript:printit();" />
	    <input type="button" name="button_setup" value="打印页面设置" onclick="javascript:printsetup();">
	    <input type="button" name="button_show" value="打印预览" onclick="javascript:printpreview();">
	    <input type="button" name="button_fh" value="关闭" onclick="javascript:window.close();">
	</div> -->
    <div class="tools">
    	<ul class="toolbar">
	        <li><a href="" onclick="window.print()"><span><img src="<%=path %>/images/t01.png" /></span>打印本页</a></li>
        </ul>       
    </div>
    <table class="tablelist">
    	<thead>
	    	<tr>
	    		<th>序号</th>
		        <th>业主姓名</th>
		        <th>业主门牌号</th>
		        <th>联系电话</th>
		        <th>应缴费用</th>
		        <th>实际缴纳费用</th>
		        <th>找零</th>
		        <th>缴费日期</th>
	        </tr>
        </thead>
        
        <tbody>
	        <s:iterator value="#session.printvoucher" var="p" status="i">
				<tr>
					<td>${i.count }</td>
					<td><s:property value="#p.p_name"/></td>
					<td><s:property value="#p.h_house_number"/></td>
					<td><s:property value="#p.p_phone"/></td>
					<td><s:property value="#p.p_should"/></td>
					<td><s:property value="#p.p_real"/></td>
					<td><s:property value="#p.p_real-#p.p_should"/></td>
					<td><s:property value="#p.p_time"/></td>
				</tr>
			</s:iterator>
        </tbody>
    </table>
</div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>
</html>