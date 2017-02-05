<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta charset="utf-8">
<!-- 禁止客户端缓存要在<head>中加入类似如下内容：  -->
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<!-- 清除后退时的页面有缓存，但是没效果 -->
<% 
response.setHeader("Pragma", "no-cache"); 
response.setHeader("Cache-Control", "no-store"); 
response.setDateHeader("Expires", -1); 
%> 

<!-- 向搜索引擎说明你的网页的关键词；  -->
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

<!-- 告诉搜索引擎你的站点的主要内容；  -->
<meta http-equiv="description" content="This is my page">

<!-- 用以说明主页制作所使用的文字以及语言；又如英文是ISO-8859-1字符集，还有BIG5、utf-8、shift-Jis、Euc、Koi8-2等字符集； -->
<meta http-equiv="content-type" content="text/html; charset=“utf-8" />

<!-- 适合手机端屏幕 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<meta name="apple-mobile-web-app-status-bar-style" content="black"/>
<meta name="format-detection" content="telephone=no"/>
<meta name="referrer" content="no-referrer"/>

<!-- 在服务器的动态网页中禁止缓存，要加入类似如下脚本  -->
<%
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);  
%>