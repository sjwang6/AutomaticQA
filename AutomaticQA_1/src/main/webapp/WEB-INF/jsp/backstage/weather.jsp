<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>AutoQA数据维护</title>
		<%@ include file="../common/head.jsp" %>
		<link type="text/css" rel="stylesheet" href="resource/css/backstage/style.css" />
		<link href="resource/css/backstage/all.css" rel="stylesheet" type="text/css" /> 
		<!-- EasyUI CSS -->
		<link rel="stylesheet" type="text/css" href="resource/jquery-easyui-1.3.6/themes/default/easyui.css">   
		<link rel="stylesheet" type="text/css" href="resource/jquery-easyui-1.3.6/themes/icon.css"> 
		<script type="text/javascript" src="resource/js/backstage/menu.js"></script>
		<!-- EasyUI JS -->
		<script type="text/javascript" src="resource/js/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="resource/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>  
		<script type="text/javascript" src="resource/js/backstage/datalist.js"></script>
	</head>
<body>
<div class="top"></div>
<div id="header">
	<div class="logo">AutoQA数据维护</div>
	<div class="navigation">
		<ul>
		 	<li>今天是</li>
		    <li><div id="time"></div></li>
		 	<li>欢迎您！</li>
			<li><a href="${common}/toShowUserInfo?userId=${User.getUserId()}">${User.getUserName()}</a></li>
			<li><a href="">修改密码</a></li>
			<li><a href="">设置</a></li>
			<li><a href="toLoginOut">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
		<ul id="nav_dot">
	      	<li>
		        <h4 class="M1"><span></span>Automatic</h4>
		        <div class="list-item none">
		            <a href='${common}/toBackstage'>首页</a>
		        </div>
	        </li>
        	<li>
          		<h4 class="M2"><span></span>天气信息</h4>
          		<div class="list-item none">
		            <a href='${common}/showAllWeatherInfo'>查看所有</a>
		            <a href='${common}/checkweather'>查漏补缺</a>
		            <a href=''>工单处理3</a>
		            <a href=''>工单处理4</a>
		            <a href=''>工单处理5</a>          
           		</div>
        	</li>
        	<li>
          		<h4 class="M3"><span></span>百科信息</h4>
          		<div class="list-item none">
		            <a href=''>展示数据</a>
		            <a href=''>获取数据</a>
		            <a href=''>基础教学3</a>
          		</div>
        	</li>
			<li>
          		<h4 class="M4"><span></span>QA信息</h4>
          		<div class="list-item none">
		            <a href=''>查看QA</a>
		            <a href=''>评论管理2</a>
		            <a href=''>评论管理3</a>
          		</div>
        	</li>
			<li>
          		<h4 class="M5"><span></span>设置</h4>
          		<div class="list-item none">
		            <a href=''>用户信息</a>
		            <a href=''>修改密码</a>
		            <a href=''>退出</a>
	          	</div>
	        </li>
  		</ul>
	</div>
	<div class="m-right">
		<div class="right-nav">
			<ul>
				<li><img src="resource/images/backstage/muban/home.png"></li>
				<li style="margin-left:25px;">您当前的位置：</li>
				<li><a href="#">天气信息</a></li>
				<li>></li>
				<li><a href="#">查看所有</a></li>
			</ul>
		</div>
		<div class="main" style="background: #e1e9eb;">
			<form action="${common}/showAllWeatherInfo" id="mainForm" method="post">
				<input type="hidden" name="currentPage" id="currentPage" value="${currentPage}"/>
				<div class="right">
					<div class="rightCont">
						<p class="g_title fix">内容列表<a class="btn09" href="javascript:getWeatherInfo();">获取天气</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn11" href="javascript:deleteBatch('');">删 除</a></p>
						<table class="tab1">
							<tbody>
								<tr>
									<td width="90" align="right">地区名称：</td>
									<td>
										<input name="command" type="text" class="allInput" value="${command}"/>
									</td>
									<td width="90" align="right">日期：</td>
									<td>
										<input name="description" type="text" class="allInput" value="${description}"/>
									</td>
		                            <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
		       					</tr>
							</tbody>
						</table>
						<div class="zixun fix">
							<table class="tab2" width="100%">
								<tbody>
									<tr>
									    <th><input type="checkbox" id="all" onclick="javascript:void(0);"/></th>
									    <th>天气编号</th>
									    <th>日期</th>
									    <th>风速</th>
									    <th>现象</th>
									    <th>温度</th>
									    <th>风向</th>
									    <th>地区</th>
									    <th>操作</th>
									</tr>
									<c:forEach items="${All_Weather_List}" var="weather" varStatus="status">
										<tr <c:if test="${status.index % 2 != 0}">style='background-color:#ECF6EE;'</c:if>>
											<td><input type="checkbox"  name="id" value="${weather.weatherId}"/></td>
											<td>${weather.weatherId}</td>
											<td>${weather.weatherDate}</td>
											<td>${weather.weatherWind}</td>
											<td>${weather.weatherPhenomenon}</td>
											<td>${weather.weatherSmallTemperature}/${weather.weatherBigTemperature}</td>
											<td>${weather.weatherWindRun}</td>
											<td>${weather.fkAreaId}</td>
											<td>
												<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
												<a href="${basePath}DeleteOneServlet.action?id=${weather.weatherId}">删除</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class='page fix'>
								共 <b>${size}</b> 条
								<c:if test="${currentPage != 1}">
									<a href="javascript:changeCurrentPage('1')" class='first'>首页</a>
									<a href="javascript:changeCurrentPage('${currentPage-1}')" class='pre'>上一页</a>
								</c:if>
								当前第<span>${currentPage}/${totalPage}</span>页
								<c:if test="${currentPage != totalPage}">
									<a href="javascript:changeCurrentPage('${currentPage+1}')" class='next'>下一页</a>
									<a href="javascript:changeCurrentPage('${totalPage}')" class='last'>末页</a>
								</c:if>
								跳至&nbsp;<input id="currentPageText" type='text' value='${currentPage}' class='allInput w28' />&nbsp;页&nbsp;
								<a href="javascript:changeCurrentPage($('#currentPageText').val())" class='go'>GO</a>
							</div>
						</div>
					</div>
				</div>
	    	</form>	   
		</div>
	</div>
</div>
<div class="bottom"></div>
<div id="footer"><p>Copyright@ AutomaticQA_1</p></div>
<script>navList(12);</script>
</body>
</html>
