<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%@ include file="../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>500 - 系统内部错误</title>
	<%@ include file="../common/head.jsp" %>
	<link href="resource/css/error_page.css" rel="stylesheet"/>
</head>

<body>
	<div class="container" style=" margin-top:8%;"> 
	   <div class="panel margin-big-top">
	      <div class="text-center">
	         <br />
	         <h2 class="padding-top"><strong>500错误！抱歉系统发生内部错误. </strong> </h2>
	         <div class=""> 
	            <div class="float-left">
	                <img src="http://www.pintuer.com/images/ds-1.gif"/>
	                <div class="alert"> 卧槽！系统发生内部错误！ </div>
	            </div>
	            <div class="float-right">
	               <img src="http://www.pintuer.com/images/ds-2.png" width="260"/> 
	            </div>
	          </div>
	          <div class="padding-big">
	               <a href="" class="button bg-yellow">返回首页</a>
	               <a href="" class="button">保证不打死管理员</a>
	          </div> 
	      </div> 
	   </div> 
	</div>
</body>
</html>
