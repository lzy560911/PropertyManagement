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
	    <li>工作人员及部门信息</li>
	    <li>部门信息查询</li>
    </ul>
    </div>
    
<div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
	        <li><a href="jsp/add_departmentinfo.jsp"><span><img src="<%=path %>/images/t01.png" /></span>添加</a></li>
        	<%
       			 if (exportToExcel == null) {
    		%>
	        <li><a href="departmentinfo.jsp?exportToExcel=YES"><span><img src="<%=path %>/images/t01.png" /></span>导出本页为Excel</a></li>
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
		        <th>部门名称</th>
		        <th>部门主管</th>
		        <th>主管联系电话</th>
		        <th>操作</th>
	        </tr>
        </thead>
        
        <tbody>
	        <s:iterator value="#session.department" var="d" status="i">
				<tr>
					<td>${i.count }</td>
					<td><s:property value="#d.d_id"/></td>
					<td><s:property value="#d.d_name"/></td>
					<td><s:property value="#d.d_leader"/></td>
					<td><s:property value="#d.d_phone"/></td>
					<td>
				        <a class="tablelink"
				         href="Department!DepartmentFindById?id=${d.d_id}"
				         onclick="javascript:return confirm('您确认修改当前数据么？');">修改</a>
				        <a class="tablelink"
				        	href="Department!DepartmentDelete?id=${d.d_id }&departmentName=${d.d_name}"
							onclick="javascript:return confirm('您确认删除当前数据么？');"> 删除</a>
			        </td>
				</tr>
			</s:iterator>
        </tbody>
         <tr align="center">
		        <td colspan="7">
					<a href="Department!DepartmentFindAll.action?page=1">首页</a>
						<s:if test="#session.page>1">
					<a href="Department!DepartmentFindAll.action?page=${page-1}">上一页</a>
					</s:if>
					<s:if test="#session.page<#session.size">
						<a href="Department!DepartmentFindAll.action?page=${page+1}">下一页</a>
					</s:if>
					<a href="Department!DepartmentFindAll.action?page=${size}">尾页</a>
					<s:iterator value="#session.fenye" var="m" status="i">
						<a href="Department!DepartmentFindAll.action?page=${i.count}">第${i.count}页</a>
					</s:iterator>
				</td>
			</tr>
    </table>
</div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>
</html>