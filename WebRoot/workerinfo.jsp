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
<script type="text/javascript">
	/* 高级查询 */
	function search(){
		alert("welcome to the search ！");
		var search_wname = document.getElementById("search_wname").value;
		var search_cardnumber = document.getElementById("search_cardnumber").value;
		var search_dname = document.getElementById("search_dname").value;
		var url = "Worker!WorkerSearchByCondition?worker_name="+search_wname+"&work_cardnumber="+search_cardnumber+"&work_dname="+search_dname;
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
	    <li>工作人员及部门信息</li>
	    <li>工作人员信息</li>
    </ul>
    </div>
    
<div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
	        <li><a href="<%=path %>/jsp/add_workerinfo.jsp"><span><img src="<%=path %>/images/t01.png" /></span>添加</a></li>
	        <%
       			 if (exportToExcel == null) {
    		%>
	        <li><a href="workerinfo.jsp?exportToExcel=YES"><span><img src="<%=path %>/images/t01.png" /></span>导出本页为Excel</a></li>
        	<% 
       			 }
        	%>
        	<li><a href="javascript:void(0)" onclick="DisplayAdvancedQuery()"><span><img src="<%=path %>/images/t01.png" /></span>高级查询</a></li>
        </ul>       
    </div>
    <div id="search" style="display:none;">
	    <input type="text" id="search_wname" name="search_wname" placeholder="请输入员工姓名" style="border:1px solid #378888">
	    <input type="text" id="search_cardnumber" name="search_cardnumber" placeholder="请输员工身份证号" style="border:1px solid #378888">
	    <input type="text" id="search_dname" name="search_dname" placeholder="请输入部门名称" style="border:1px solid #378888">
	    <input type="button" value="多条件查询" style="height:32px;width:100px;background-image:url(<%=path %>/images/toolbg.gif);border-style:solid;border-width:1px;border-color:#d3dbde;" onclick="search();">
    </div>
    <table class="tablelist">
    	<thead>
	    	<tr>
	    		<th>序号</th>
		        <th>员工编号<i class="sort"><img src="<%=path %>/images/px.gif" /></i></th>
		        <th>姓名</th>
		        <th>性别</th>
		        <th>身份证号</th>
		        <th>手机号码</th>
		        <th>所属部门名称</th>
		        <th>操作</th>
	        </tr>
        </thead>
        
        <tbody>
	        <s:iterator value="#session.worker" var="w" status="i">
				<tr>
					<td>${i.count }</td>
					<td><s:property value="#w.w_id"/></td>
					<td><s:property value="#w.w_name"/></td>
					<td><s:property value="#w.w_sex"/></td>
					
					<td><s:property value="#w.w_cardnumber"/></td>
					<td><s:property value="#w.w_phone"/></td>
					<td><s:property value="#w.d_name"/></td>
					<td>
				        <a class="tablelink"
				         href="Worker!WorkerFindById?id=${w.w_id }"
				         onclick="javascript:return confirm('您确认修改当前数据么？');">修改</a>
				        <a class="tablelink"
				        	href="Worker!WorkerDelete?id=${w.w_id }"
							onclick="javascript:return confirm('您确认删除当前数据么？');"> 删除</a>
			        </td>
				</tr>
			</s:iterator>
        </tbody>
        <tr align="center">
		        <td colspan="8">
					<a href="Worker!WorkerFindAll.action?page=1">首页</a>
					<s:if test="#session.page>1">
						<a href="Worker!WorkerFindAll.action?page=${page-1}">上一页</a>
					</s:if>
					<s:if test="#session.page<#session.size">
						<a href="Worker!WorkerFindAll.action?page=${page+1}">下一页</a>
					</s:if>
					<a href="Worker!WorkerFindAll.action?page=${size}">尾页</a>
				<s:iterator value="#session.fenye" var="m" status="i">
					<a href="Worker!WorkerFindAll.action?page=${i.count}">第${i.count}页</a>
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