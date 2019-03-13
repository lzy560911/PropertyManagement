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
<title>业主信息</title>
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
		var search_name = document.getElementById("search_name").value;
		var search_cardnumber = document.getElementById("search_cardnumber").value;
		var search_house_number = document.getElementById("search_house_number").value;
		var url = "Owner!OwnerSearchByCondition?owner_name="+search_name+"&owner_cardnumber="+search_cardnumber+"&house_number="+search_house_number;
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
	    <li>业主及房屋信息</li>
	    <li>业主信息</li>
    </ul>
    </div>
    
<div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
    		<!-- Home!OwnerFindHomeNum.action -->
	        <li><a href="jsp/add_ownerinfo.jsp"><span><img src="<%=path %>/images/t01.png" /></span>添加</a></li>
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
	    <input type="text" id="search_name" name="search_name" placeholder="请输入业主姓名" style="border:1px solid #378888">
	    <input type="text" id="search_cardnumber" name="search_cardnumber" placeholder="请输业主身份证号" style="border:1px solid #378888">
	    <input type="text" id="search_house_number" name="search_house_number" placeholder="请输入门牌号" style="border:1px solid #378888">
	    <input type="button" value="多条件查询" style="height:32px;width:100px;background-image:url(<%=path %>/images/toolbg.gif);border-style:solid;border-width:1px;border-color:#d3dbde;" onclick="search();">
    </div>
    <table class="tablelist">
    	<thead>
	    	<tr>
		        <th>序号<i class="sort"><img src="<%=path %>/images/px.gif" /></i></th>
		        <th>业主编号</th>
		        <th>业主姓名</th>
		        <th>业主身份证号</th>
		        <th>门牌号</th>
		        <th>联系电话</th>
		        <th>入住时间</th>
		        <th>操作</th>
	        </tr>
        </thead>
        
        <tbody>
	        <s:iterator value="#session.owner" var="o" status="i">
				<tr>
					<td>${i.count }</td>
					<td><s:property value="#o.o_id"/></td>
					<td><s:property value="#o.o_name"/></td>
					<td><s:property value="#o.o_cardnumber"/></td>
					<td><s:property value="#o.h_house_number"/></td>
					<td><s:property value="#o.o_phone"/></td>
					<td><s:property value="#o.o_time"/></td>
					<td>
				        <a class="tablelink"
				         href="Owner!OwnerFindById?id=${o.o_id }"
				         onclick="javascript:return confirm('您确认修改当前数据吗？');">修改</a>
				        <a class="tablelink"
				        	href="Owner!OwnerDelete?id=${o.o_id }&house_number=${o.h_house_number}"
							onclick="javascript:return confirm('您确认删除当前数据吗？');"> 删除</a>
						<a class="tablelink"
				        	href="Owner!OwnerFindByIdToRepair?id=${o.o_id }"
							onclick="javascript:return confirm('您确认该用户需要保修吗？');"> 报修</a>
			        </td>
				</tr>
			</s:iterator>
        </tbody>
        
         <tr align="center">
		        <td colspan="8">
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