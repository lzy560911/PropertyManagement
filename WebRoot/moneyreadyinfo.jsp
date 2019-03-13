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
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		  $(".click").click(function(){
		  $(".tip").fadeIn(200);
		  });
	});
</script>
</head>

<body>
<%
        String exportToExcel = request.getParameter("exportToExcel");
        if (exportToExcel != null
                && exportToExcel.toString().equalsIgnoreCase("YES")) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "inline; filename="
                    + "excel.xls");
 
        }
%>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
	    <li>首页</li>
	    <li>水电费缴纳</li>
	    <li>缴纳水电费</li>
    </ul>
    </div>
    
<div class="rightinfo">
    <div class="tools">
    	<ul class="toolbar">
	        <%
       			 if (exportToExcel == null) {
    		%>
	        <li><a href="moneyreadyinfo.jsp?exportToExcel=YES"><span><img src="<%=path %>/images/t01.png" /></span>导出本页为Excel</a></li>
        	<% 
       			 }
        	%>
        </ul>       
    </div>
    <table class="tablelist">
    	<thead>
	    	<tr>
	    		<th>序号</th>
		        <th>业主编号</th>
		        <th>业主姓名</th>
		        <th>门牌号</th>
		        <th>联系电话</th>
		        <th>是否缴费</th>
		        <th>操作</th>
	        </tr>
        </thead>
        
        <tbody>
         <s:iterator value="#session.moneyready" var="m" status="i">
				<tr>
					<td>${i.count }</td>
					<td><s:property value="#m.o_id"/></td>
					<td><s:property value="#m.o_name"/></td>
					<td><s:property value="#m.h_house_number"/></td>
					<td><s:property value="#m.o_phone"/></td>
					<td><s:property value="#m.o_state"/>已缴费</td>
					<!--#m.o_state  -->
					<td>
				        <a class="tablelink"
				       		href="Pay!Printvoucher?h_house_number=${m.h_house_number}"
				         	onclick="javascript:return confirm('您确定打印凭证吗？');">打印凭证</a>
			        </td>
				</tr>
			</s:iterator>
        </tbody>
          <tr align="center">
		        <td colspan="7">
					<a href="Money!MoneyAlready.action?page=1">首页</a>
					<s:if test="#session.page>1">
						<a href="Money!MoneyAlready.action?page=${page-1}">上一页</a>
					</s:if>
					<s:if test="#session.page<#session.size">
						<a href="Money!MoneyAlready.action?page=${page+1}">下一页</a>
					</s:if>
					<a href="Money!MoneyAlready.action?page=${size}">尾页</a>
				<s:iterator value="#session.fenye" var="m" status="i">
					<a href="Money!MoneyAlready.action?page=${i.count}">第${i.count}页</a>
				</s:iterator>
				</td>
			</tr>
    </table>
    <p align="center" style="color:red;font-size:10px;">注：1代表已缴费</p>
</div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>
</html>
