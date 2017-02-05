$(function(){
	$('#switch_qlogin').click(function(){
		$('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_bottom').animate({left:'0px',width:'70px'});
		$('#qlogin').css('display','none');
		$('#web_qr_login').css('display','block');
	});
	$('#switch_login').click(function(){
		$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_bottom').animate({left:'154px',width:'70px'});
		$('#qlogin').css('display','block');
		$('#web_qr_login').css('display','none');
	});
	if(getParam("a")=='0'){
		$('#switch_login').trigger('click');
	}
	
	$('#brith').datebox({    
	    required:true   
	});	
});
function logintab(){
	scrollTo(0);
	$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
	$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
	$('#switch_bottom').animate({left:'154px',width:'96px'});
	$('#qlogin').css('display','none');
	$('#web_qr_login').css('display','block');
}

//判断是否用户已存在
function checkUser(){
	var userName = $("#user").val();
	$.ajax({
		type:"GET",
		data:"userName="+userName,
		url:"toCheckUser",
		dataType:"json",
		success:function (data){
			if(data != 1){
				$.messager.confirm("提示","该用户名已存在，请重新输入！",function(t){
					if(t){
						$("input[name='user']").focus(); //获取焦点
					}
				});
			}
		}
	});
}

//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) { 
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&'); 
    if (ArrParam.length == 1) { 
        //只有一个参数的情况 
        return params.split('=')[1]; 
    } 
    else { 
         //多个参数参数的情况 
        for (var i = 0; i < ArrParam.length; i++) { 
            if (ArrParam[i].split('=')[0] == pname) { 
                return ArrParam[i].split('=')[1]; 
            } 
        } 
    } 
}  

$(document).ready(function() {
	$('#reg').click(function() {
		
		/**
		 * 用户名
		 */
		if ($('#user').val() == "") {
			$('#user').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×用户名不能为空x</b></font>");
			return false;
		}else if ($('#user').val().length > 16) {
			$('#user').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×用户名不要超过16字符x</b></font>");
			return false;
		}else{
			$('#user').focus().css({
				border: "1px solid #D7D7D7",
				boxShadow: "none"
			});
		}
		
		/**
		 * 密码
		 */
		if ($('#passwd').val().length < 6) {
			$('#passwd').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×密码不能小于" + 6 + "位x</b></font>");
			return false;
		}else{
			$('#passwd').focus().css({
				border: "1px solid #D7D7D7",
				boxShadow: "none"
			});
		}
		
		/**
		 * 确认密码
		 */
		if ($('#passwd2').val() != $('#passwd').val()) {
			$('#passwd2').focus();
			$('#userCue').html("<font color='red'><b>×两次密码不一致！x</b></font>");
			return false;
		}else{
			$('#passwd2').focus().css({
				border: "1px solid #D7D7D7",
				boxShadow: "none"
			});
		}
		
		/**
		 * email
		 */
		var email = /^([A-Za-z0-9]|([a-zA-z]+[0-9]))+@+([0-9A-Za-z]+[-.])+[A-Za-z]{2,5}$/; //email正则表达式
		if (!email.test($('#email').val())) {
			$('#email').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×Email格式不正确x</b></font>");
			return false;
		} else {
			$('#email').css({
				border: "1px solid #D7D7D7",
				boxShadow: "none"
			});
		}
		$('#userCue').html("<font color='green'><b>x验证通过x</b></font>");
		setTimeout(function(){ //停顿函数
			window.close(); 
			$('#regUser').submit(); //停顿完成后要执行的函数
		},2000);
	});
});