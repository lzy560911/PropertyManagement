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
	    <li>车辆及车位信息</li>
	    <li>业主车辆信息条件查询结果</li>
    </ul>
    </div>
    
<div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
	        <li><a href="jsp/add_carsinfo.jsp"><span><img src="<%=path %>/images/t01.png" /></span>添加</a></li>
        	<%
       			 if (exportToExcel == null) {
    		%>
	        <li><a href="carsinfo.jsp?exportToExcel=YES"><span><img src="<%=path %>/images/t01.png" /></span>导出本页为Excel</a></li>
        	<% 
       			 }
        	%>
        </ul>
    </div>
    
    <table class="tablelist">
    	<thead>
	    	<tr>
	    		<th>序号</th>
		        <th>编号<i class="sort"><img src="<%=path %>/images/px.gif" /></i></th>
		        <th>车辆品牌</th>
		        <th>车辆颜色</th>
		        <th>车牌号</th>
		        <th>操作</th>
	        </tr>
        </thead>
        
        <tbody>
         <s:iterator value="#session.conditioncars" var="cc" status="i">
				<tr>
					<td>${i.count }</td>
					<td><s:property value="#cc.oc_id"/></td>
					<td><s:property value="#cc.oc_name"/></td>
					<td><s:property value="#cc.oc_color"/></td>
					<td><s:property value="#cc.oc_licenseplate"/></td>
					<td>
				        <a class="tablelink"
				       		href="Cars!CarsFindById?id=${cc.oc_id }"
				         	onclick="javascript:return confirm('您确认修改当前数据么？');">修改</a>
				        <a class="tablelink"
				         	href="Cars!CarsDelete?id=${cc.oc_id }"
							onclick="javascript:return confirm('您确认删除当前数据么？');"> 删除</a>
			        </td>
				</tr>
			</s:iterator>
        </tbody>
       <%--  <tr align="center">
		        <td colspan="7">
					<a href="Cars!CarsFindAll.action?page=1">首页</a>
					<s:if test="#session.page>1">
						<a href="Cars!CarsFindAll.action?page=${page-1}">上一页</a>
					</s:if>
					<s:if test="#session.page<#session.size">
						<a href="Cars!CarsFindAll.action?page=${page+1}">下一页</a>
					</s:if>
					<a href="Cars!CarsFindAll.action?page=${size}">尾页</a>
				<s:iterator value="#session.fenye" var="m" status="i">
					<a href="Cars!CarsFindAll.action?page=${i.count}">第${i.count}页</a>
				</s:iterator>
				</td>
			</tr> --%>
    </table>
    <p align="center" style="color:red;font-size:10px;">注：未出售车位信息默认为0</p>
</div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
