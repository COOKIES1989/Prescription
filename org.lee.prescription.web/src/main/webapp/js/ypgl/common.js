var reg = /^[\u4E00-\u9FA5]+$/;

function init_combobox(id,table_name,url){
	init_combobox_style(id,table_name,url);//初始化下拉框风格
	init_combobox_data(table_name,url ,id,"");//初始化时加载数据
}

function init_combobox_data(table_name,url ,id ,value){//combobox异步加载数据
	$.ajax({
		type : "POST",
		url : url,
		data : {"tbn" : table_name , "value" : value},
		dataType : "json",
		success : function (result){
			$("#"+id).combobox("loadData",result);
		},
		error : function(data){
			updatePanel("错误提示","toerror.do");
//			alert("init_combobox_data:error");
		}
	});
}


function init_combobox_style(id,table_name,url){//初始化combobox风格
	var iCombogridRow = 0, iRows = 0;
	$("#"+id).combobox({
//		editable:false,    	//不可编辑状态
		cache : false,     	//无缓存
		delay : 1000,      	//输入文本进行模糊查询时，延时1秒
		height : '32',     	//下拉框高度
		valueField : [1],  	//加载dm
		textField : [0],   	//加载中文mc
		panelHeight : '200',//固定高度，下拉框内容较多时，出现滚动条
		keyHandler : {
			enter : function() {
				$(this).combobox('hidePanel');
			},
			up : function() {//上方向键选择选项
				if(iRows==0) return;
				if(iCombogridRow>0) 
					iCombogridRow = iCombogridRow - 1;
				$(this).combobox('select',$(this).combobox('getData')[iCombogridRow][0]);
				},
			down : function() {//下方向键选择选项
				 if(iRows==0) return;	 
				 if(iCombogridRow<(iRows-1)) 
					 iCombogridRow = iCombogridRow + 1;
				 $(this).combobox('select',$(this).combobox('getData')[iCombogridRow][0]);
			},
			query : function(key) {
				if (key == '' ) {
					$(this).combobox('setValue', '');
					return;
				}
				if(!reg.test(key) && !reg.test($(this).combobox("getText").charAt(0))){
					init_combobox_data(table_name,url ,id ,$(this).combobox("getText"));
				}else{
					$(this).combobox('setValue', '');
				}
			}
		},
		onLoadSuccess:function(data){
			iCombogridRow = -1;
			var __rows = $(this).combobox('getData');
			iRows = __rows.length;
		},
		onHidePanel : function() {
			$('#'+id+'_zw').val($('#'+id).combobox('getText'));
		}
	}).next('span').find('input').click(function(){
//		init_combobox_data(table_name,url ,id,"");//点击输入框时加载数据
		$('#'+id).combobox("showPanel");
	});
}



function init_simple_combobx(id ,isDefault){//初始化简化的下拉框，加载本地json文件作为数据
	//var iCombogridRow = 0, iRows = 0;
	//////////debugger;
	var jsonUrl = "";
	if (id.indexOf("_") !=-1) {
		jsonUrl = "json_data/"+id.split("_")[0]+".json";
	}else{
		jsonUrl = "json_data/"+id+".json";
	}
	$("#"+id).combobox({
		cache : false,     	//无缓存
		height : '32',     	//下拉框高度
		valueField : 'code',//加载dm
		textField : 'note', //加载中文mc
		url : jsonUrl,		//加载本地json文件
		panelHeight : 'auto',//固定高度，下拉框内容较多时，出现滚动条
		onLoadSuccess:function(data){
			//$(this).combobox("setValue","01");
			//////////debugger;
			if(isDefault){
				if(data.length > 0){
					var first_row = $(this).combobox('getData')[0];
					var code = first_row.code;
					var note = first_row.note;
					$(this).combobox("setValue",code);
					$(this).combobox("setText",note);
					$("#"+id+"_zw").val(note);
				}
			}
		},
		onHidePanel : function(){
			$('#'+id+'_zw').val($('#'+id).combobox('getText'));
		}
	}).next('span').find('input').click(function(){
		$('#'+id).combobox("showPanel");
	});
}


function messageUtil(type , msg){//展示信息的方法
	if(type == "show"){
		$.messager.show({
			title : "提示信息",
			msg : msg,
			showType : "slide",
			timeout : 2000
		});
	}else if (type == "alert") {
		$.messager.alert("错误提示", msg,"error");
	}
}



function clearForm(form_id){//清空表单
//	$('#'+form_id).form('reset');
	$(':input','#'+form_id)
	.not(':button,:submit,:reset,:hidden')
	.val('');
}








