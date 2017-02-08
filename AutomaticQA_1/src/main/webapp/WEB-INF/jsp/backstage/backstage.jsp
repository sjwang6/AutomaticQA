<%@page import="com.aiit.graduationproject.entity.User"%>
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
		<link href="resource/css/backstage/default.css" rel="stylesheet" type="text/css" /> 
		<!-- EasyUI CSS -->
		<link rel="stylesheet" type="text/css" href="resource/jquery-easyui-1.3.6/themes/default/easyui.css">   
		<link rel="stylesheet" type="text/css" href="resource/jquery-easyui-1.3.6/themes/icon.css"> 
		<script type="text/javascript" src="resource/js/backstage/menu.js"></script>
		<!-- EasyUI JS -->
		<script src="resource/js/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="resource/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>  
		<script src="resource/js/backstage/datalist.js"></script>
		<script src="resource/js/backstage/QAajax.js"></script>
	</head>
<body>
<div class="top"></div>
<div id="header">
	<div class="logo">AutoQA数据维护</div>
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
		            <a href=''>基础教学1</a>
		            <a href=''>基础教学2</a>
		            <a href=''>基础教学3</a>
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
  		</ul>
	</div>
	<div class="m-right">
		<div class="right-nav">
			<ul>
				<li><img src="resource/images/backstage/muban/home.png"></li>
				<li style="margin-left:25px;">您当前的位置：</li>
				<li><a href="#">Automatic</a></li>
				<li>></li>
				<li><a href="#">question</a></li>
			</ul>
		</div>
		<div class="main" style="background: #e1e9eb;">
			<div class="topNav">
			    小二
			</div>
			<div class="main1">
			    <div class="content1">
			        <div class="chatbot" style="margin-left: 200px">
			            <img src="resource/images/backstage/shour.png" alt="shour">
			        </div>
			        <div class="dialog">
			            <div class="history">
			                <textarea id="history" rows="12" cols="60" disabled="true"></textarea>
			            </div>
			            <div class="question">
			                <input id="question" type="text" style="height: 25px;" size="50px">
			                <button style="height: 30px; width: 50px;" onclick="question()">提问</button>
			            </div>
			        </div>
			    </div>
			</div>
		</div>
	</div>
</div>
<div class="bottom"></div>
<div id="footer"><p>Copyright@ AutomaticQA_1</p></div>
<script>navList(12);</script>
</body>
</html>
