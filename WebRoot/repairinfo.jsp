<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
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
	function search(){
		alert("welcome to the search ！");
		var search_name = document.getElementById("search_name").value;
		var search_mess = document.getElementById("search_mess").value;
		var search_phone = document.getElementById("search_phone").value;
		var url = "Repair!RepairSearchByCondition?search_name="+search_name+"&search_mess="+search_mess+"&search_phone="+search_phone;
		alert("url is :"+url); 
		document.location.href =url;
}

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
	    <li>保修</li>
	    <li>查询全部报修信息</li>
    </ul>
    </div>
    
<div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
	        <%
       			 if (exportToExcel == null) {
    		%>
	        <li><a href="repairinfo.jsp?exportToExcel=YES"><span><img src="<%=path %>/images/t01.png" /></span>导出本页为Excel</a></li>
        	<% 
       			 }
        	%>
        	<li><a href="javascript:void(0)" onclick="DisplayAdvancedQuery()"><span><img src="<%=path %>/images/t01.png" /></span>高级查询</a></li>
        </ul>       
    </div>
    <div id="search" style="display:none;">
	    <input type="text" id="search_name" name="search_name" placeholder="请输入报修人姓名" style="border:1px solid #378888">
	    <input type="text" id="search_mess" name="search_mess" placeholder="请输保修备注" style="border:1px solid #378888">
	    <input type="text" id="search_phone" name="search_phone" placeholder="请输入报修人联系方式" style="border:1px solid #378888">
	    <input type="button" value="多条件查询" style="height:32px;width:100px;background-image:url(<%=path %>/images/toolbg.gif);border-style:solid;border-width:1px;border-color:#d3dbde;" onclick="search();">
    </div>
    <p></p>
    <table class="tablelist">
    	<thead>
	    	<tr>
	    		<th>序号</th>
	    		<th>报修信息编号</th>
		        <th>报修门牌号<i class="sort"><img src="<%=path %>/images/px.gif" /></i></th>
		        <th>报修人姓名</th>
		        <th>报修人联系方式</th>
		        <th>备注</th>
		        <th>报修时间</th>
		        <th>当前状态</th>
		        <th>操作</th>
	        </tr>
        </thead>
        
        <tbody>
	        <s:iterator value="#session.repair" var="r" status="i">
				<tr>
					<td>${i.count }</td>
					<td><s:property value="#r.r_id"/></td>
					<td><s:property value="#r.h_house_number"/></td>
					<td><s:property value="#r.r_name"/></td>
					<td><s:property value="#r.r_phone"/></td>
					<td><s:property value="#r.r_message"/></td>
					<td><s:property value="#r.r_time"/></td>
					<td><s:property value="#r.r_state"/></td>
					
					<c:if test="${r.r_state=='true'}">
    					<td>
					        <a class="tablelink"
					         href="#"
					         onclick="javascript:return confirm('已维修完成，无需再次确认！谢谢！');">维修已完成</a>
			        	</td>
					</c:if>
					<c:if test="${r.r_state=='false'}">
					    <td>
					        <a class="tablelink"
					         href="Repair!RepairFindById?id=${r.r_id }"
					         onclick="javascript:return confirm('您确认维修完成了吗？');">维修中,点击确认完成</a>
			        	</td>
					</c:if>
					
<%-- 					<% 
						ArrayList list = (ArrayList)session.getAttribute("repair");
						String state = list.get(xxx).toString();
						System.out.println("state is "+state);
						if(state.indexOf("ture")!=-1){
					%> 
					<c:if test="${r.r_state == 'ture'}">
						
			        </c:if>
			       <% }else{%>
			       
						<td>
					        <a class="tablelink"
					         href="Repair!RepairFindById?id=${r.r_id }"
					         onclick="javascript:return confirm('您确认维修完成了吗？');">维修完成</a>
			        	</td> 
			 
					<%} %> --%>
				</tr>
			</s:iterator>
        </tbody>
        
	        <tr align="center">
		        <td colspan="9">
					<a href="Repair!RepairFindAll.action?page=1">首页</a>
					<s:if test="#session.page>1">
						<a href="Repair!RepairFindAll.action?page=${page-1}">上一页</a>
					</s:if>
					<s:if test="#session.page<#session.size">
						<a href="Repair!RepairFindAll.action?page=${page+1}">下一页</a>
					</s:if>
					<a href="Repair!RepairFindAll.action?page=${size}">尾页</a>
				<s:iterator value="#session.fenye" var="m" status="i">
					<a href="Repair!RepairFindAll.action?page=${i.count}">第${i.count}页</a>
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