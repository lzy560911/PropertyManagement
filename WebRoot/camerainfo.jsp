<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="java.net.URLEncoder" %>
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
<script type="text/javascript">
	/* 高级查询 */
	function search(){
		alert("welcome to the search ！");
		var search_gbid = document.getElementById("search_gbid").value;
		var search_name = document.getElementById("search_name").value;
		var search_time = document.getElementById("search_time").value;
		var url = "Camera!CameraSearchByCondition?camera_gbid="+search_gbid+"&camera_name="+search_name+"&camera_time="+search_time;
		alert("url is :"+url); 
		document.location.href =url;
	}
	/* 高级查询div显示与隐藏 */
	function DisplayAdvancedQuery(){
		var searchDiv = document.getElementById('search');
		var val = searchDiv.style.display;
		if(val == 'none'){
			searchDiv.style.display = 'block'; //显示
	    }else{
	    	searchDiv.style.display = 'none'; //隐藏
	    }
}
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
	    <li>公共设施信息</li>
	    <li>摄像头信息</li>
    </ul>
    </div>
    
<div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
	        <li><a href="jsp/add_camerainfo.jsp"><span><img src="<%=path %>/images/t01.png" /></span>添加</a></li>
	        <%
       			 if (exportToExcel == null) {
    		%>
	        <li><a href="camerainfo.jsp?exportToExcel=YES"><span><img src="<%=path %>/images/t01.png" /></span>导出本页为Excel</a></li>
        	<% 
       			 }
        	%>
        	<li><a href="javascript:void(0)" onclick="DisplayAdvancedQuery()"><span><img src="<%=path %>/images/t01.png" /></span>高级查询</a></li>
        </ul>
    </div>
    <div id="search" style="display:none;">
	    <input type="text" id="search_gbid" name="search_gbid" placeholder="请输入国标ID" style="border:1px solid #378888">
	    <input type="text" id="search_name" name="search_name" placeholder="请输入生产厂家" style="border:1px solid #378888">
	    <input type="text" id="search_time" name="search_time" placeholder="请输入安装日期" style="border:1px solid #378888">
	    <input type="button" value="多条件查询" style="height:32px;width:100px;background-image:url(<%=path %>/images/toolbg.gif);border-style:solid;border-width:1px;border-color:#d3dbde;" onclick="search();">
    </div>
    <table class="tablelist">
    	<thead>
	    	<tr>
	    		<th>序号</th>
		        <th>编号<i class="sort"><img src="<%=path %>/images/px.gif" /></i></th>
		        <th>国标ID</th>
		        <th>生产厂家</th>
		        <th>安装时间</th>
		        <th>当前状态</th>
		        <th>操作</th>
	        </tr>
        </thead>
        
        <tbody>
	        <s:iterator value="#session.cameras" var="c" status="i">
				<tr>
					<td>${i.count }</td>
					<td><s:property value="#c.c_id"/></td>
					<td><s:property value="#c.c_gbid"/></td>
					<td><s:property value="#c.c_name"/></td>
					<td><s:property value="#c.c_time"/></td>
					<td><s:property value="#c.c_state"/></td>
					<td>
				        <a class="tablelink"
				         href="Camera!CameraFindById?id=${c.c_id }"
				         onclick="javascript:return confirm('您确认修改当前数据么？');">修改</a>
				        <a class="tablelink"
				        	href="Camera!CameraDelete?id=${c.c_id }"
							onclick="javascript:return confirm('您确认删除当前数据么？');"> 删除</a>
			        </td>
				</tr>
			</s:iterator>
        </tbody>
        
	        <tr align="center">
		        <td colspan="7" rowspan="2">
					<a href="Camera!CameraFindAll.action?page=1">首页</a>
					<s:if test="#session.page>1">
						<a href="Camera!CameraFindAll.action?page=${page-1}">上一页</a>
					</s:if>
					<s:if test="#session.page<#session.size">
						<a href="Camera!CameraFindAll.action?page=${page+1}">下一页</a>
					</s:if>
					<a href="Camera!CameraFindAll.action?page=${size}">尾页</a>
				<s:iterator value="#session.fenye" var="m" status="i">
					<a href="Camera!CameraFindAll.action?page=${i.count}">第${i.count}页</a>
				</s:iterator>
					<a href="Camera!FindAll" style="margin-left:10px;color:#A0522D;"><b>显示全部信息</b></a>
				</td>
			</tr>
    </table>
</div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>
</html>