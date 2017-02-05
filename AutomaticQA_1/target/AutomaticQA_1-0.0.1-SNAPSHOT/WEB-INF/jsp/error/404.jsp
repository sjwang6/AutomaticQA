<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%@ include file="../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>404 - 页面不存在</title>
	<%@ include file="../common/head.jsp" %>
	<link href="resource/css/error_page.css" rel="stylesheet"/>
	<style>
		*{ margin:0; padding:0; list-style:none;}
		table{border-collapse:collapse;border-spacing:0;}
		body,html{ height:100%; font-family:'微软雅黑'; overflow-y:hidden;}
		.main{ width:60%; margin-left:20%; margin-right:20%; margin-top:10%;}
		.main_left{ width:38%; margin-left:12%; margin-top:10%; float:left;}
		.main_right{width:50%; float:left;}
		.main_radius{ padding-top:4%; width:75%; height:130px; border-radius:50%; background:#fef2ec; font-size:18px;text-align:center;}
		.main_p{ font-family:'华文行楷';}
	</style>
</head>

<body>
<div class="main">
   <div class="main_left"><img src="resource/images/error_page.png" width="229" height="128"/></div>
   <div class="main_right">
      <div class="main_radius">
         <p class="main_p">404错误</p>
         <p class="main_p">您要找的页面不存在,或已被删除！</p>
      </div>
      <div class="text-left" style="margin-top:10%; margin-left:8%;">     
          <a href="" class="button bg-yellow">返回首页</a>
          <a href="" class="button">保证不打死管理员</a> 
      </div>
   </div>
</div>
</body>
</html>
