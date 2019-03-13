<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
function tick() {
    var year,month,day,hours,minutes,seconds,ap;
    var intYear,intMonth,intDay,intHours,intMinutes,intSeconds;
    var today;
    today=new Date();
    intYear=today.getYear()+1900;
    intMonth=today.getMonth()+1;
    intDay=today.getDate();
    intHours=today.getHours();
    intMinutes=today.getMinutes();
    intSeconds=today.getSeconds();
    if(intHours==0){
        hours=intHours+":";
        ap="凌晨";
    }else if(intHours<12){
        hours=intHours+":";
        ap="早上好";
    }else if(intHours==12){
        hours=intHours+":";
        ap="中午好";
    }else{
        intHours=intHours-12;
        hours=intHours+":";
        ap="下午好";
    }
    if(intHours<10){
        hours="0"+intHours+":"
    }else{
        hours=intHours+":";
    }
     if(intMinutes<10){
         minutes="0"+intMinutes+":";
     }else{
         minutes=intMinutes+":";
         
     }
     if(intSeconds<10){
         seconds="0"+intSeconds+"";
     }else{
         seconds=intSeconds+"";
     }
     timeString="当前时间："+intYear+'年'+intMonth+'月'+intDay+'日'+"    "+hours+minutes+seconds+"   "+ap;
     window.setTimeout('tick()',1000);
     document.getElementById('Clock').innerHTML=timeString;//显示位置，获取id （<div id="Clock"></div>  此<body onload="tick()">）
}
</script>
</head>

<body onload="tick()">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.html">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b>尊敬的${loginName}，欢迎您使用碧桂园小区物业管理系统</b>
    <a href="Administrators!AdministratorsFindMe?me=${loginName}">帐号设置</a>
    </div>
    
    <div class="welinfo" >
    <span><img src="images/time.png" alt="时间" /></span>
    	<div id="Clock"></div>
    </div> 
    <!-- <i>您上次登录的时间：2013-10-09 15:22</i> （不是您登录的？<a href="#">请点这里</a>） -->
    <div class="xline"></div>
    
    <ul class="iconlist">
	    <li><img src="images/ico01.png" /><p><a href="Home!FreeHomeFindAll.action">出售房屋信息</a></p></li>
	    <li><img src="images/ico02.png" /><p><a href="jsp/add_ownerinfo.jsp">添加业主信息</a></p></li>
	    <li><img src="images/ico03.png" /><p><a href="Money!MoneyFindAll.action?page=1">水电缴费</a></p></li>
	    <li><img src="images/ico04.png" /><p><a href="Worker!WorkerFindAll.action">工作人员信息</a></p></li>
	    <li><img src="images/ico05.png" /><p><a href="Cars!CarsFindAll.action">业主车辆信息</a></p></li>
	    <li><img src="images/ico06.png" /><p><a href="Owner!OwnerFindAll.action">查询业主信息</a></p></li> 
	    <li><img src="images/ico03.png" /><p><a href="ContrastDiagram.jsp">车位及车辆对比信息图</a></p></li>
    </ul>
    
   <!-- <div class="ibox"></div> -->
   <!-- <a class="ibtn"><img src="images/iadd.png" />添加新的快捷功能</a> -->
    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="images/dp.png" alt="提醒" /></span>
    <b>物业管理系统使用指南</b>
    </div>
    
    <ul class="infolist">
    <li><span>如何快速对业主信息进行操作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><a href="jsp/information_one.jsp" class="ibtn">操作业主信息</a></li>
    <li><span>如何快速缴纳业主水费及电费&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><a href="jsp/information_two.jsp" class="ibtn">快速缴纳费用</a></li>
    <li><span>如何进行管理员账户密码修改&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><a href="jsp/information_three.jsp" class="ibtn">快速修改密码</a></li>
    </ul>
    
    <div class="xline"></div>
    
    <div class="uimakerinfo"><b>查看物业管理系统使用指南，您可以快速的学习如何操作本系统，以最优质的服务来对待每一位业主。来源：<a href="http://www.mycodes.net/" target="_blank">子夜紫叶</a></b></div>
    <ul class="umlist">
	    <li><a href="jsp/information_four.jsp">关于系统</a></li>
    </ul>
    </div>
    
    

</body>

</html>
