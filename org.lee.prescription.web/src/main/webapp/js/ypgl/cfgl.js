$(function(){
	
	initWindow("modifyYpxxDiv", "药品信息窗口");//初始化修改药品信息窗口
	
	//reloadCfyptbl("402883c34fdf383f014fdf3af3020000");//预设列表数据
	
	init_cfyptbl ();//初始化药品信息列表
	
	init_simple_combobx("hzxb", true);//初始化患者性别下拉框
	init_simple_combobx("cfjx", true);//初始化处方剂型下拉框
	
	var trs = $("#ypDiv tr");
	for (var i = 1; i<= trs.length; i++) {
		init_combobox("ypqc_"+i, "YPXXB", "cfgl/getYpxx.do");//初始化药品名称下拉框
		init_simple_combobx("ypjl_"+i,true);//初始化药品剂量下拉框
		init_simple_combobx("fyfs_"+i,true);//初始化服用方式下拉框
		init_simple_combobx("sfzj_"+i,true);//初始化是否针剂下拉框
	}
	
})


function submitForm(){//提交表单
	
	var formData = $("#cfxxForm").serializeArray();
	
	$.ajax({
		type : "POST",
		url : "cfgl/saveCfxx.do",
		data : formData,
		dataType : "json",
		success : function(result){
			if(result.flag != "0"){
				messageUtil("alert", "提交失败，请重新提交");
				return;
			}
			$("#cfzj_hidden").val(result.msg);
			reloadCfyptbl(result.msg);
			messageUtil("show", "提交成功");
			$("#submitbtn").css("display" , "none");
			$("#moreTRbtn").css("display" , "none");
			$("#appendypbtn").css("display" , "");
			$("#modifyCFxxbtn").css("display" , "");
		},
		error : function(){
			messageUtil("alert", "SubmitForm异常");
		}
	});
}


function reloadCfyptbl(cfzj){//重载药品列表数据
	if(cfzj == "" || cfzj == "null" || cfzj =="undefined"){
		messageUtil("alert", "处方信息保存异常，请重新尝试");
		return;
	}
	
	$.ajax({
		type : "POST",
		url : "cfgl/getCfypxx.do",
		data : {"cfzj":cfzj},
		dataType : "json",
		success : function (result){
			if(result.flag != "0"){
				messageUtil("alert", "重载药品列表失败，请重新提交");
				return;
			}
			$("#cfyptbl").datagrid("loadData",result.rows);
		},
		error : function(){
			messageUtil("alert", "reloadCfyptbl异常");
		} 
	});
	
}


function addMoreTR(){//新增药品列表行
	debugger;
	var lastTrId = $("#ypDiv tr :last").attr("id");
	var tr_index_last = lastTrId.split('_')[1];
	var tr_index_int_new = Number(tr_index_last)+1; 
	var newTr = '<tr id = "tr_'+tr_index_int_new+'" align="center">'+
					'<td ><span>'+tr_index_int_new+'</span></td>'+
					'<td><input id="ypqc_'+tr_index_int_new+'" name="ypdm" style="width: 400px;border: 0px;">'+
						'<input id="ypqc_'+tr_index_int_new+'_zw" name="ypqc" style="width: 400px;border: 0px;" type="hidden"></td>'+
					'<td><input id="ypjl_'+tr_index_int_new+'" name="ypjldm" style="width: 400px;border: 0px;">'+
						'<input id="ypjl_'+tr_index_int_new+'_zw" name="ypjl" style="width: 400px;border: 0px;" type="hidden"></td>'+
					'<td><input id="fyfs_'+tr_index_int_new+'" name="fyfs" style="width: 400px;border: 0px;">'+
						'<input id="fyfs_'+tr_index_int_new+'_zw" name="fyfszw" style="width: 400px;border: 0px;" type="hidden"></td>'+
					'<td><input id="sfzj_'+tr_index_int_new+'" name="sfzj" style="width: 50px;border: 0px;">'+
						'<input id="sfzj_'+tr_index_int_new+'_zw" name="sfzjzw" type="hidden"></td>'+
				'</tr>'
	$("#ypDiv").append(newTr);
	
	//初始化新增下拉框
	init_combobox("ypqc_"+tr_index_int_new, "YPXXB", "cfgl/getYpxx.do");
	init_simple_combobx("ypjl_"+tr_index_int_new,true);
	init_simple_combobx("fyfs_"+tr_index_int_new,true);
	init_simple_combobx("sfzj_"+tr_index_int_new,true);
}


function init_cfyptbl (){//初始化处方药品列表
	$("#cfyptbl").datagrid({
		title : "处方药品信息",
//		url: "cfgl/getCfypxx.do",
		method: 'post',
//		pageList : [5,10,15,20],
		pageSize : 20,
		striped : true,// 设置为true将交替显示行背景。
		width: "100%",
		height: "auto",
		fitColumns: true,
		rownumbers: true,
		pagination: true,
		singleSelect: true,
		columns:[[
			{field:'ypqc',title:'药品全称',width:3},
			{field:'ypjlzw',title:'药品剂量',width:2,align:'center'},
			{field:'fyfszw',title:'服用方式',width:2,align:'center'},
			{field:'sfzjzw',title:'是否针剂',width:2,align:'center'},
			{field:'option',title:'操作',width:3,align:'center',formatter:optionypxx},
			{field:'uuid',title:'yyid',hidden:true},
		]]
	})
}


function optionypxx(value,rowData,index){//格式化操作列
	return "<a href='#' title="+rowData.uuid+" onclick='deleteCfypxx(this.title)'><span style='color: blue;'>删除</span></a>"+
		   "&nbsp;&nbsp;&nbsp;&nbsp;" +
		   "<a href='#' title="+rowData.uuid+" onclick='modifyCfypxx(this.title)'><span style='color: blue;'>修改</span></a>";
}


function deleteCfypxx(uuid){//删除药品信息
	var cfzj = $("#cfzj_hidden").val();
	$.messager.confirm("确认删除" ,"确认删除吗？",function(r){
		if (r) {
			$.ajax({
				type : "POST",
				url : "cfgl/deleteCfypxx.do",
				data : {"uuid" : uuid,"cfzj" : cfzj},
				success : function(result){
					if (result.flag == "0") {
						reloadCfyptbl(cfzj);//重载列表数据
						$.messager.show({
							title : "提示信息",
							msg : result.msg,
							showType : "slide",
							timeout : 2000
						});
					}else{
						messageUtil("alert", "删除失败");
					}
				},
				error : function(){
					messageUtil("alert", "系统发生错误");
				}
			});
		}
	});
}


function initWindow(id,title){
	$('#'+id).window({  
		title:title,
	    width:750,   
	    height:300,   
	    closable :true,
	    closed:true,
	    draggable : true,
	    shadow :true,
	    modal : true
	});
	//初始化隐藏域重的下拉框
	init_combobox("ypqc_mf", "YPXXB", "cfgl/getYpxx.do");//初始化药品名称下拉框
	init_simple_combobx("ypjl_mf", true);
	init_simple_combobx("fyfs_mf", true);
	init_simple_combobx("sfzj_mf", true);
	
	$("#submitbtn_mf").linkbutton({
		iconCls:'icon-edit',
	});
	$("#undo_mf").linkbutton({
		iconCls:'icon-undo',
	});
	$("#appendbtn").linkbutton({
		iconCls:'icon-add',
	});
	
}

function modifyCfypxx (uuid) {//修改处方药品信息
	$("#submitbtn_mf").css("display","");
	$("#undo_mf").css("display","");
	$("#appendbtn").css("display","none");
	setYpParam(uuid);
	$("#modifyYpxxDiv").window("open");
}

function setYpParam(uuid){//设置修改窗口回填参数
	$.ajax({
		url : "cfgl/getOneYpxx.do",
		type : "POST",
		data : {"uuid" : uuid},
		success : function (result){
			
			$("#cfypzj").val(result.rows.uuid);
			$("#cfzj").val(result.rows.cfzj);
			
			$("#ypqc_mf").combobox("setValue",result.rows.ypdm);
			$("#ypqc_mf").combobox("setText",result.rows.ypqc);
			$("#ypqc_mf_zw").val(result.rows.ypqc);
			
			$("#ypjl_mf").combobox("setValue",result.rows.ypjl);
			$("#ypjl_mf").combobox("setText",result.rows.ypjlzw);
			$("#ypjl_mf_zw").val(result.rows.ypjlzw);
			
			$("#fyfs_mf").combobox("setValue",result.rows.fyfs);
			$("#fyfs_mf").combobox("setText",result.rows.fyfszw);
			$("#fyfs_mf_zw").val(result.rows.fyfszw);
			
			$("#sfzj_mf").combobox("setValue",result.rows.sfzj);
			$("#sfzj_mf").combobox("setText",result.rows.sfzjzw);
			$("#sfzj_mf_zw").val(result.rows.sfzjzw);
		}
	});
}


function submitModifyForm(){//提交修改药品信息表单
	var formData = $("#modifyYpxxForm").serializeArray();
	$.ajax({
		url : "cfgl/updateCfypxx.do",
		type : "POST",
		data : formData,
		success : function(result){
			if(result.flag != "1") {
				messageUtil("alert", "修改失败，请重新尝试");
				return;
			}
			reloadCfyptbl($("#cfzj_hidden").val());
			messageUtil("show", result.msg);
			$('#modifyYpxxDiv').window('close');
		},
		error : function(){
			messageUtil("alert", "SubmitForm异常");
		}
	});
}

function addNewCfyp(){//点击提交按钮后继续追加药品
	
	$("#submitbtn_mf").css("display","none");
	$("#undo_mf").css("display","none");
	$("#appendbtn").css("display","");
	$("#cfzj").val($("#cfzj_hidden").val());//获取处方主键并赋值给弹窗隐藏域
	$("#modifyYpxxDiv").window("open");
	
}

function appendCfyp(){//追加药品信息
	var formData = $("#modifyYpxxForm").serializeArray();
	$.ajax({
		url : "cfgl/appendCfypxx.do",
		type : "POST",
		data : formData,
		success : function (result){
			if(result.flag == "1"){
				messageUtil("show", result.msg);
				$('#modifyYpxxDiv').window('close');
				reloadCfyptbl($("#cfzj_hidden").val());
			}else{
				messageUtil("alert", "添加失败，请重新尝试");
			}
		},
		error : function(){
			alert("SubmitForm异常");
		}
	});
}

function modifyCfxx (){
	
}























