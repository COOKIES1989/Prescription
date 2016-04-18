$(function(){
	
	$('#modifybtn').css('display', 'none');//隐藏修改按钮
	
	init_yplb();//初始化药品列表
	
//	init_simple_combobx("ypjlgl",false);//初始化药品剂量下拉框
//	
//	init_simple_combobx("ypcj",false);//初始化药品厂家下拉框
//	
//	init_simple_combobx("ypjx",false);//初始化药品剂型下拉框
	
	
});


function init_yplb(){//初始化药品列表
	$("#yplb").datagrid({
		url: "ypgl/getAllYpxx.do",
		method: 'post',
		pageList : [5,10,15,20],
		pageSize : 5,
		striped : true,// 设置为true将交替显示行背景。
		width: '100%',
		height: "auto",
		fitColumns: true,
		rownumbers: true,
		pagination: true,
		singleSelect: true,
		columns:[[
			{field:'ypqc',title:'药品全称',width:4},
			{field:'ypmc',title:'药品名称',width:2,align:'center'},
			{field:'yppyjc',title:'药品拼音简称',width:2,align:'center'},
			{field:'ypjlzw',title:'药品剂量',width:2,align:'center'},
			{field:'ypcjzw',title:'药品厂家',width:3,align:'center'},
			{field:'option',title:'操作',width:4,align:'center',formatter:option},
			{field:'uuid',title:'uuid',hidden:true}
		]],
	});
}

function option(value,rowData,index){//格式化操作列
	return "<a href='#' title="+rowData.uuid+" onclick='deleteYpxx(this.title)'><span style='color: blue;'>删除</span></a>"+
		   "&nbsp;&nbsp;&nbsp;&nbsp;" +
		   "<a href='#' title="+rowData.uuid+" onclick='modifyYpxx(this.title)'><span style='color: blue;'>修改</span></a>";
}


function submitYpglForm(){//提交表单_保存药品信息
	var formData = $("#ypglForm").serializeArray();
	console.log(formData);
	$.ajax({
		type : "POST",
		data : formData,
		url : "ypgl/saveYpxx.do",
		success : function(result){
			if (result.flag == "OK") {
				$("#yplb").datagrid("reload");
				$.messager.show({
					title : "提示信息",
					msg : result.msg,
					showType : "slide",
					timeOut : 3000
				});
			}else{
				$.messager.alert('错误提示','保存失败','error');
			}
		}
	})
	
	
}

function deleteYpxx(uuid){//删除药品信息
	$.messager.confirm("确认删除" ,"确认删除吗？",function(r){
		if (r) {
			$.ajax({
				type : "POST",
				url : "ypgl/deleteYpxx.do",
				data : {"uuid" : uuid},
				success : function(result){
					if (result.flag == "OK") {
						$("#yplb").datagrid("reload");
						$.messager.show({
							title : "提示信息",
							msg : result.msg,
							showType : "slide",
							timeout : 2000
						});
					}else{
						$.messager.alert("提示信息","删除失败","error");
					}
				},
				error : function(){
					$.messager.alert("提示信息","系统发生错误","error");
				}
			});
		}
	});
}


function modifyYpxx (uuid) {//回填药品信息
	$('#modifybtn').css('display', '');
	$('#submitbtn').css('display', 'none');
	$.ajax({
		type : "POST",
		data : {"uuid" : uuid},
		url : "ypgl/getOneYpxx.do",
		success : function (result){
			if (result.flag == "OK") {
				setParam(result.rows);
			}
		},
		error : function(){
			$.messager.alert("提示信息","系统发生错误","error");
		}
	});
}

function  submit_update_ypxx (){
	var formData = $("#ypglForm").serializeArray();
	$.ajax({
		type : "POST",
		data : formData,
		url : "ypgl/updateYpxx.do",
		success : function(result){
			if (result.flag == "OK") {
				$("#yplb").datagrid("reload");//刷新列表数据
				$('#modifybtn').css('display', 'none');
				$('#submitbtn').css('display', '');
				clearForm("ypglForm");//清空表单
				$.messager.show({
					title : "提示信息",
					msg : result.msg,
					showType : "slide",
					timeout : 2000
				});
			}
		},
		error : function (){
			$.messager.alert("提示信息","系统发生错误","error");
		}
	});
	
	
}


function setParam(data){//设置页面参数
	
	$("#uuid").val(data.uuid);
	$("#ypdm").val(data.ypdm);
	
	$("#ypmc").val(data.ypmc);
	$("#yppyjc").val(data.yppyjc);
	
	$("#ypjl").val(data.ypjlzw);
	
	$("#ypcj").val(data.ypcjzw);
	
	$("#ypjx").val(data.ypjxzw);
	
	/*$("#ypjl").combobox("setValue",data.ypjl);
	$("#ypjl").combobox("setText",data.ypjlzw);
	$("#ypjlzw").val(data.ypjlzw);
	
	$("#ypcj").combobox("setValue",data.ypcj);
	$("#ypcj").combobox("setText",data.ypcjzw);
	$("#ypcjzw").val(data.ypcjzw);
	
	$("#ypjx").combobox("setValue",data.ypjx);
	$("#ypjx").combobox("setText",data.ypjxzw);
	$("#ypjxzw").val(data.ypjxzw);*/
}















