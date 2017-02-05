/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	$.messager.alert("这是删除");
	$("#mainForm").attr("action",basePath + "DeleteBatchServlet.action");
	$("#mainForm").submit();
}

/**
 * 修改当前页码，调用后台重新查询
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}

/**
 * 获取天气信息
 */
function getWeatherInfo(){
	$.messager.confirm("提示","是否清空天气表tb_weather",function(t){
		if(t){
			$.messager.alert("YES");
		}else{
			$.messager.alert("NO");
		}
	});
}