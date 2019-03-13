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
		var search_oname = document.getElementById("search_oname").value;
		var search_ophone = document.getElementById("search_ophone").value;
		var search_rname = document.getElementById("search_rname").value;
		var url = "Repair!PaymentSearchByCondition?search_oname="+search_oname+"&search_ophone="+search_ophone+"&search_rname="+search_rname;
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
	    <li>报修</li>
	    <li>打印维修凭证</li>
    </ul>
    </div>
    
<div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
    		<!-- Home!OwnerFindHomeNum.action -->
	        
        	<%
       			 if (exportToExcel == null) {
    		%>
	        <li><a href="ownerinfo.jsp?exportToExcel=YES"><span><img src="<%=path %>/images/t01.png" /></span>导出本页为Excel</a></li>
        	<% 
       			 }
        	%>
        	<li><a href="javascript:void(0)" onclick="DisplayAdvancedQuery()"><span><img src="<%=path %>/images/t01.png" /></span>高级查询</a></li>
        </ul>       
    </div>
    <div id="search" style="display:none;">
	    <input type="text" id="search_oname" name="search_name" placeholder="请输入报修人姓名" style="border:1px solid #378888">
	    <input type="text" id="search_ophone" name="search_cardnumber" placeholder="请输报修人电话" style="border:1px solid #378888">
	    <input type="text" id="search_rname" name="search_house_number" placeholder="请输入维修人姓名" style="border:1px solid #378888">
	    <input type="button" value="多条件查询" style="height:32px;width:100px;background-image:url(<%=path %>/images/toolbg.gif);border-style:solid;border-width:1px;border-color:#d3dbde;" onclick="search();">
    </div>
    <table class="tablelist">
    	<thead>
	    	<tr>
		        <th>序号<i class="sort"><img src="<%=path %>/images/px.gif" /></i></th>
		        <th>凭证编号</th>
		        <th>门牌号</th>
		        <th>保修人姓名</th>
		        <th>联系电话</th>
		        <th>维修人姓名</th>
		        <th>维修费</th>
		        <th>维修时间</th>
		        <th>操作</th>
	        </tr>
        </thead>
        
        <tbody>
	        <s:iterator value="#session.Messprint" var="m" status="i">
				<tr>
					<td>${i.count }</td>
					<td><s:property value="#m.m_id"/></td>
					<td><s:property value="#m.h_house_number"/></td>
					<td><s:property value="#m.m_name"/></td>
					<td><s:property value="#m.m_phone"/></td>
					<td><s:property value="#m.m_work"/></td>
					<td><s:property value="#m.m_money"/></td>
					<td><s:property value="#m.m_time"/></td>
					<td>
				        <a class="tablelink"
				         href="Repair!Printvoucher?id=${m.m_id }"
				         onclick="javascript:return confirm('您确认要打印保修凭证吗？');">打印凭证</a>
			        </td>
				</tr>
			</s:iterator>
        </tbody>
        
         <tr align="center">
		        <td colspan="9">
					<a href="Owner!OwnerFindAll.action?page=1">首页</a>
					<s:if test="#session.page>1">
						<a href="Owner!OwnerFindAll.action?page=${page-1}">上一页</a>
					</s:if>
					<s:if test="#session.page<#session.size">
						<a href="Owner!OwnerFindAll.action?page=${page+1}">下一页</a>
					</s:if>
					<a href="Owner!OwnerFindAll.action?page=${size}">尾页</a>
				<s:iterator value="#session.fenye" var="m" status="i">
					<a href="Owner!OwnerFindAll.action?page=${i.count}">第${i.count}页</a>
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