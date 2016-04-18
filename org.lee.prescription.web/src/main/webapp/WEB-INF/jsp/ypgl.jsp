<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="yplb"></table>
	<form  id="ypglForm" method="post">
		
		<input id="uuid" name="uuid" type="hidden">
		<input id="ypdm" name="ypdm" type="hidden">
		
		<table cellpadding="2" cellspacing="4" border="0" style="width:96%;">
			<tr>
				<td colspan="4">
					<fieldset style="padding-top:0;margin-top:0;border-radius:5px;border: 1px solid #87CEFA;">
						<legend style="margin-left:20px;background-color: #ffffff;">基本信息</legend>
						<div align="center">
							<table border="0">
								<tr>
									<td class="span01">药品名称:</td>
									<td>
										<input id="ypmc" name="ypmc" >
									</td>
									<td class="span01">药品拼音简称:</td>
									<td>
										<input id="yppyjc" name="yppyjc" >
									</td>
								</tr>
								<tr>
									<td class="span01">药品剂量:</td>
									<td>
										<input id="ypjl" name="ypjlzw" >
									</td>
									<td class="span01">药品厂家:</td>
									<td>
										<input id="ypcj" name="ypcjzw" >
									</td>
								</tr>
								<tr>
									<td class="span01">药品剂型:</td>
									<td>
										<input id="ypjx" name="ypjxzw" >
									</td>
								</tr>
<!-- 								<tr>
									<td class="span01">药品名称:</td>
									<td>
										<input id="ypmc" name="ypmc" >
									</td>
									<td class="span01">药品拼音简称:</td>
									<td>
										<input id="yppyjc" name="yppyjc" >
									</td>
								</tr>
								<tr>
									<td class="span01">药品剂量:</td>
									<td>
										<input id="ypjlgl" name="ypjl" >
										<input id="ypjlgl_zw" name="ypjlzw" type="hidden">
									</td>
									<td class="span01">药品厂家:</td>
									<td>
										<input id="ypcj" name="ypcj" >
										<input id="ypcj_zw" name="ypcjzw" type="hidden">
									</td>
								</tr>
								<tr>
									<td class="span01">药品剂型:</td>
									<td>
										<input id="ypjx" name="ypjx" >
										<input id="ypjx_zw" name="ypjxzw" type="hidden">
									</td>
								</tr> -->
							</table>
						</div>
					</fieldset>
			</tr>
			<tr>
				<td id="submitFormId" align="center">
					<span  class='span01' style="text-align: left;">
						<a id="submitbtn" href="javascript:void(0)" class="easyui-linkbutton" 
							data-options="iconCls:'icon-add'" 
							onclick="submitYpglForm();">提交</a>
						<a id="modifybtn" href="javascript:void(0)" class="easyui-linkbutton"
							data-options="iconCls:'icon-edit'" onclick="submit_update_ypxx();">修改</a>
					</span>
					<span class='span01'>
						<a id="clearbtn" href="javascript:void(0)" class="easyui-linkbutton" 
							data-options="iconCls:'icon-undo'" onclick="clearForm('ypglForm')">
							清空
						</a>
					</span>
				</td>
			</tr>
		</table>
	</form>
	
	<script type="text/javascript" src="js/ypgl/ypgl.js"></script>
</body>
</html>