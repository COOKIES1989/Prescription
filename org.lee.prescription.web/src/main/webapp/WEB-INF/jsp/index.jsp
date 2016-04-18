<%@ page language="java" import="java.util.*" errorPage="/error.jsp" pageEncoding="utf-8" isELIgnored="false"%>
<%
	String path = request.getContextPath();
	//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head id="Head1">
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <title>处方系统</title>
	    
	    <!-- <link rel="icon" href="prescription.ico" type="image/x-icon"/>
	    <link rel="shortcut icon" href="prescription.ico" type="image/x-icon"/>
	    <link rel="bookmark" href="prescription.ico" type="image/x-icon"/> -->
	    
	    
	    <link rel="stylesheet" type="text/css" href="<%=path %>/js/css/index.css"  />
	    <link rel="stylesheet" type="text/css" href="<%=path %>/js/easyui/themes/icon.css" />
	    <link rel="stylesheet" type="text/css" href="<%=path %>/js/easyui/themes/default/easyui.css" />
	    
	    <script type="text/javascript" src="<%=path %>/js/easyui/jquery-1.8.0.min.js"></script>   
	    <script type="text/javascript" src="<%=path %>/js/easyui/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="<%=path %>/js/easyui/locale/easyui-lang-zh_CN.js"></script>	
	    <script type="text/javascript" src="<%=path %>/js/easyui/extension/datagrid-detailview.js"></script>	
	    <script type="text/javascript" src="<%=path %>/js/ypgl/common.js"></script>	
	    
	    <script type="text/javascript">  
		    var pathurl="";
		
		    $(function () {
		    	updatePanel('处方管理', '<%=path %>/tocfgl.do');
			   /*  var objectpanel=$('#west div.panel');	
		    	var qx="1"; */
		    	
		        /* if(qx!='1'){
		        	$(objectpanel[1]).css('display','none');
		        }else{
		        	$('#tt').css('show','');
		        	$('#wd').css('display','none');
		        } */
		    	
		    	/* if(qx=="0"){
		    		$("#yhqx").text("一般用户");
		    	}else if(qx=="1"){
		    		$("#yhqx").text("高级用户");
		    	} */
		    	
		    }); 
		    
		    function updatePanel(titles,url){
		    	$('body').layout('panel', 'center').panel({ 
		    		cache:false,
		    		href:url,
		    		loadingMessage:'载入中....',
		    		title: titles });
		    	
		    }    	
		    
		    function updatePanel3(titles,url,tblno,size,number){
		    	$('body').layout('panel', 'center').panel({ 
		    		cache:false,
		    		href:url,
		    		loadingMessage:'载入中....',
		    		title: titles });
		    }
		    
		    function updatePanel4(titles,url,tblno,passno){
		    	$('body').layout('panel', 'center').panel({ 
		    		cache:false,
		    		href:url,
		    		loadingMessage:'载入中....',
		    		title: titles 
		    		});
		    } 
		     	
			/* function Open_Dialog() { 
				 $('#mydialog').show(); 
				 $('#mydialog').dialog({ 
				// maximized:true,
				 collapsible: true, 
				 minimizable: true, 
				 maximizable: true,
				 buttons: {  
					 text: '退出', 
					 iconCls: 'icon-back', 
					 handler: function() { 
						 $('#mydialog').dialog('close');
					 	} 
					 }
			     }); 
			}  */	
		</script>
</head>
    
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
   	<noscript>
    <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;"> 
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' /> </div>
    </noscript> 
     
   <!-- <div region="north" class="north" split="true" style=""> 
        <div class="bigshow">
	        <span>系统名称:</span><span class="red" >XXX管理系统</span> &nbsp;
	        <span>当前用户:</span><span id='myids' class="red" >XXX</span> &nbsp;
	        <span >用户权限:</span><span class="red" id="yhqx">管理员</span>&nbsp;
  	 	</div>
   </div> -->

	<div region="west" id="west" class="west"  hide="true" split="true" title="功能菜单" >
		<div id="nav" class="easyui-accordion" fit="true" border="false">  
        <div  class="zu"  title=功能列表 data-options="iconCls:'icon-ok'" >
				<ul>
					<li id="10001">
                        <a href="#" onclick="updatePanel('处方管理', '<%=path %>/tocfgl.do')">
                        	<span class="icon-add">&nbsp;&nbsp;</span>
							<span class="nav">处方管理</span>
						</a>
					</li>
					<li id="10002">
                        <a href="#" onclick="updatePanel('信息管理', '<%=path %>/toypgl.do')">
                        	<span class="icon-add">&nbsp;&nbsp;</span>
							<span class="nav">信息管理</span>
						</a>
					</li>
					
				</ul>	
			</div>
		</div>
	</div>

<div  id="mainPanel" region="center" >
<!-- 内部字体大小在index.css*{}中修改 -->
</div>



</body>
</html>