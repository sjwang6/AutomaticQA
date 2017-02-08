<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head> 
        <title>登录- login</title> 
        <%@ include file="common/head.jsp" %>
        <link href="resource/css/login/login.css" rel="stylesheet" type="text/css" />
        <!-- EasyUI CSS -->
		<link rel="stylesheet" type="text/css" href="resource/jquery-easyui-1.3.6/themes/default/easyui.css">   
		<link rel="stylesheet" type="text/css" href="resource/jquery-easyui-1.3.6/themes/icon.css"> 
		<!-- EasyUI JS -->
		<script type="text/javascript" src="resource/js/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="resource/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>   
        <script type="text/javascript" src="resource/js/login/login.js"></script>
        <script type="text/javascript">
	      	//后台返回的提示防刷新    
	        var show="${sign_in_error}";
	        $(function(){
	            $("#userP").html(show);
	            setTimeout('$("#userCue1").empty()',2000);
	        });
        </script>
    </head> 
    <body> 
        <div class="login" style="margin-top:50px;"> 
            <div class="header"> 
                <div class="switch" id="switch">
                    <a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a> 
                    <a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a>
                    <div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div> 
                </div> 
            </div> 
            <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;"> 
                <!--登录--> 
                <div class="web_login" id="web_login"> 
                    <div class="login-box"> 
                        <div class="login_form"> 
                            <form action="${common}/toLogin" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post">
                                <input type="hidden" name="did" value="0" /> 
                                <input type="hidden" name="to" value="log" />
                                <div id="userCue1" class="cue1">
                                	<p id="userP" align="center" style="color: red;size: 10"></p>
	                            </div> 
                                <div class="uinArea" id="uinArea"> 
                                    <label class="input-tips" for="u">帐号：</label> 
                                    <div class="inputOuter" id="uArea"> 
                                        <input type="text" id="u" name="username" class="inputstyle"  placeholder="请输入姓名"  /> 
                                    </div> 
                                </div> 
                                <div class="pwdArea" id="pwdArea"> 
                                    <label class="input-tips" for="p">密码：</label> 
                                    <div class="inputOuter" id="pArea"> 
                                        <input type="password" id="p" name="p" class="inputstyle"  placeholder="请输入密码"  /> 
                                    </div> 
                                </div> 
                                <div style="padding-left:50px;margin-top:20px;">
                                    <input type="submit" value="登 录" style="width:150px;" class="button_blue" />
                                </div> 
                            </form> 
                        </div> 
                    </div> 
                </div> 
                <!--登录end--> 
            </div> 
            <!--注册--> 
            <div class="qlogin" id="qlogin" style="display: none; "> 
            	<div class="web_login">
                    <form action="${common}/toRegister" name="form2" id="regUser" accept-charset="utf-8" method="post"> 
                        <input type="hidden" name="to" value="reg" /> 
                        <input type="hidden" name="did" value="0" /> 
                        <ul class="reg_form" id="reg-ul"> 
                            <li>
	                            <div id="userCue" class="cue">
	                                	快速注册请注意格式
	                            </div>
                            </li>
                            <li> 
                                <label for="user" class="input-tips2">用户名：</label> 
                                <div class="inputOuter2"> 
                                    <input type="text" id="user" name="user" maxlength="16" class="inputstyle2" onblur="checkUser();"/> 
                                </div>
                            </li> 
                            <li> 
                                <label for="passwd" class="input-tips2">密码：</label> 
                                <div class="inputOuter2"> 
                                    <input type="password" id="passwd" name="passwd" maxlength="16" class="inputstyle2"  /> 
                                </div> 
                            </li> 
                            <li> 
                                <label for="passwd2" class="input-tips2">确认密码：</label> 
                                <div class="inputOuter2"> 
                                    <input type="password" id="passwd2" name="" maxlength="16" class="inputstyle2" /> 
                                </div> 
                            </li>
                            <li> 
                                <label for="sex" class="input-tips2">性别：</label> 
                                <div class="inputOuter2">
                                    <input type="radio" id="radio1" name="radio" checked="checked" value="1"/>男 
                                    <input type="radio" id="radio0" name="radio" value="0" />女
                                </div> 
                            </li>
                            <li> 
                                <label for="brith" class="input-tips2">出生日期：</label> 
                                <div class="inputOuter2"> 
                                    <input type="text" id="brith" name="brith" onblur="checkBrith();"/>
                                </div> 
                            </li>  
                            <li> 
                                <label for="email" class="input-tips2">EMail：</label> 
                                <div class="inputOuter2"> 
                                    <input type="text" id="email" name="email" maxlength="20" class="inputstyle2" /> 
                                </div> 
                            </li>
                            <li> 
                                <label for="address" class="input-tips2">地址：</label> 
                                <div class="inputOuter2"> 
                                    <input type="text" id="address" name="address" maxlength="10" class="inputstyle2" /> 
                                </div> 
                            </li>  
                            <li> 
                                <div class="inputArea"> 
                                    <input type="button" id="reg" style="margin-top:10px;margin-left:85px;" class="button_blue" value="同意协议并注册" /> 
                                    <a href="#" class="zcxy" target="_blank">注册协议</a> 
                                </div> 
                            </li>
                            <li>
                            	<div class="cl"></div>
                            </li> 
                        </ul>
                    </form> 
                </div> 
            </div> 
            <!--注册end--> 
        </div> 
    </body>
</html>