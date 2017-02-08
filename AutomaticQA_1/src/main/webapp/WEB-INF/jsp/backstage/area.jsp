<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>AutoQA数据维护</title>
		<%@ include file="../common/head.jsp" %>
		<link type="text/css" rel="stylesheet" href="resource/css/backstage/style.css" />
		<link href="resource/css/backstage/all.css" rel="stylesheet" type="text/css" /> 
		<!-- EasyUI CSS -->
		<link rel="stylesheet" type="text/css" href="resource/jquery-easyui-1.3.6/themes/default/easyui.css">   
		<link rel="stylesheet" type="text/css" href="resource/jquery-easyui-1.3.6/themes/icon.css"> 
		<script type="text/javascript" src="resource/js/backstage/menu.js"></script>
		<!-- EasyUI JS -->
		<script src="resource/js/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="resource/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>  
		<script src="resource/js/backstage/datalist.js"></script>
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
		            <a href='javascript:updatePwd();'>修改密码</a>
		            <a href='toLoginOut'>退出</a>
	          	</div>
	        </li>
			<li>
          		<h4  class="M6"><span></span>数据统计</h4>
          		<div class="list-item none">
		            <a href=''>数据统计</a>
		            <a href=''>数据统计</a>
		            <a href=''>数据统计</a>
	          	</div>
	        </li>
			<li>
          		<h4  class="M7"><span></span>奖励管理</h4>
          		<div class="list-item none">
            		<a href=''>奖励管理1</a>
            		<a href=''>奖励管理2</a>
            		<a href=''>奖励管理3</a>
          		</div>
        	</li>
			<li>
	        	<h4   class="M8"><span></span>字典维护</h4>
	          	<div class="list-item none">
		            <a href=''>字典维护1</a>
		            <a href=''>字典维护2</a>
		            <a href=''>字典维护3</a>
					<a href=''>字典维护4</a>
		            <a href=''>字典维护5</a>
		            <a href=''>字典维护6</a>
					<a href=''>字典维护7</a>
		            <a href=''>字典维护8</a>
		            <a href=''>字典维护9</a>
					<a href=''>字典维护4</a>
		            <a href=''>字典维护5</a>
		            <a href=''>字典维护6</a>
					<a href=''>字典维护7</a>
          		</div>
        	</li>
			<li>
	          	<h4  class="M9"><span></span>内容管理</h4>
	          	<div class="list-item none">
		            <a href=''>内容管理1</a>
		            <a href=''>内容管理2</a>
		            <a href=''>内容管理3</a>
          		</div>
        	</li>
			<li>
          		<h4   class="M10"><span></span>系统管理</h4>
          		<div class="list-item none">
		            <a href=''>系统管理1</a>
		            <a href=''>系统管理2</a>
		            <a href=''>系统管理3</a>
          		</div>
        	</li>
  		</ul>
	</div>
	<div class="m-right">
		<div class="right-nav">
			<ul>
				<li><img src="resource/images/backstage/muban/home.png"></li>
				<li style="margin-left:25px;">您当前的位置：</li>
				<li><a href="#">系统公告</a></li>
				<li>></li>
				<li><a href="#">最新公告</a></li>
			</ul>
		</div>
		<div class="main" style="background: #e1e9eb;">
			<form action="" id="mainForm" method="post">
				<input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
				<div class="right">
					<div class="rightCont">
						<p class="g_title fix">内容列表<a class="btn09" href="javascript:getAreaInfo();">获取地区</a>&nbsp;&nbsp;&nbsp;&nbsp;</p>
						<table class="tab1">
							<tbody>
								<tr>
									<td width="90" align="right">地区名称：</td>
									<td>
										<input name="command" type="text" class="allInput" value="${command}"/>
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
									    <th>地区编号</th>
									    <th>地区url</th>
									    <th>地区名称</th>
									    <td>操作</td>
									</tr>
									<c:forEach items="${All_Area_List}" var="area" varStatus="status">
										<tr <c:if test="${status.index % 2 != 0}">style='background-color:#ECF6EE;'</c:if>>
											<td><input type="checkbox"  name="id" value="${area.areaId}"/></td>
											<td>${area.areaId}</td>
											<td>${area.areaUrl}</td>
											<td>${area.areaName}</td>
											<td>
												<a href="#">下载</a>&nbsp;&nbsp;&nbsp;
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
