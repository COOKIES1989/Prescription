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
	<div>
		<table id="cfyptbl"></table>
		<input id="cfzj_hidden" name ="uuid" type="hidden" value="402883c34fdf383f014fdf3af3020000">
	</div>
	<form id="cfxxForm" method="post">
		<table cellpadding="2" cellspacing="4" border="0" style="width:96%;">
			<tr>
				<td colspan="4">
					<fieldset style="padding-top:0;margin-top:0;border-radius:5px;border: 1px solid #87CEFA;">
						<legend style="margin-left:20px;background-color: #ffffff;">患者信息</legend>
							<div align="center">
								<table>
									<tr>
										<td class="span01">患者姓名:</td>
										<td>
											<input id="hzxm" name="hzxm" >
										</td>
										<td class="span01">患者性别:</td>
										<td>
											<input id="hzxb" name="hzxb" >
											<input id="hzxb_zw" name="hzxbzw" type="hidden">
										</td>
										<td class="span01">患者年龄:</td>
										<td>
											<input id="hznl" name="hznl" >
										</td>
									</tr>
									<tr>
										<td class="span01">剂型:</td>
										<td>
											<input id="cfjx" name="cfjx" >
											<input id="cfjx_zw" name="cfjxzw" type="hidden">
										</td>
										<td class="span01">备注:</td>
										<td colspan="3">
											<input id="bz" name="bz" style="width: 594px;" >
										</td>
									</tr>
								</table>
							</div>
					</fieldset>
				</td>
			</tr>
		</table>
		<div align="center" style="margin-bottom: 10px;">
			<a id="moreTRbtn" href="javascript:void(0)" class="easyui-linkbutton" 
									data-options="iconCls:'icon-add'" onclick="addMoreTR();">更多药品</a>
			<a id="modifyCFxxbtn" href="javascript:void(0)" class="easyui-linkbutton" 
									data-options="iconCls:'icon-add'" onclick="modifyCfxx();" style="display: none;">修改患者信息</a>
			<span>&nbsp&nbsp&nbsp</span>
			<a id="submitbtn" href="javascript:void(0)" class="easyui-linkbutton" 
									data-options="iconCls:'icon-add'" onclick="submitForm();">提交</a>
			<a id="appendypbtn" href="javascript:void(0)" class="easyui-linkbutton" 
									data-options="iconCls:'icon-add'" onclick="addNewCfyp();" style="display: none;">继续添加药品</a>
			<span>&nbsp&nbsp&nbsp</span>
			<a id="printbtn" href="javascript:void(0)" class="easyui-linkbutton" 
									data-options="iconCls:'icon-print'" onclick="ad();">打印</a>
		</div>
		
		<div  align="center" style="margin-bottom: 100px;">
			<table  cellspacing="0" border="3" bordercolor="#E0ECFF" width = "70%" cellpadding="0">
				<thead >
					<tr>
						<th colspan="5" style="background-color: #95B8E7;height: 35px;">药品列表</th>
					</tr>
					<tr style="background-color: #95B8E7">
						<th>序号</th><th>药名</th><th>剂量</th><th>用法</th><th>是否针剂</th>
					</tr>
				</thead>
				<tbody id="ypDiv">
					<tr id = "tr_1" align="center">
						<td ><span>1</span></td>
						<td style="padding: 0px">
							<input id="ypqc_1" name="ypdm" style="width: 400px;border: 0px;padding: 0px">
							<input id="ypqc_1_zw" name="ypqc" style="width: 400px;border: 0px;" type="hidden"> 
						</td>
						<td>
							<input id="ypjl_1" name="ypjl" style="width: 200px;border: 0px;">
							<input id="ypjl_1_zw" name="ypjlzw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="fyfs_1" name="fyfs" style="width: 200px;border: 0px;">
							<input id="fyfs_1_zw" name="fyfszw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="sfzj_1" name="sfzj" style="width: 50px;border: 0px;">
							<input id="sfzj_1_zw" name="sfzjzw" type="hidden">
						</td>
					</tr>
					<tr id = "tr_2" align="center">
						<td ><span>2</span></td>
						<td>
							<input id="ypqc_2" name="ypdm" style="width: 400px;border: 0px;">
							<input id="ypqc_2_zw" name="ypqc" style="width: 400px;border: 0px;" type="hidden"> 
						</td>
						<td>
							<input id="ypjl_2" name="ypjl" style="width: 200px;border: 0px;">
							<input id="ypjl_2_zw" name="ypjlzw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="fyfs_2" name="fyfs" style="width: 200px;border: 0px;">
							<input id="fyfs_2_zw" name="fyfszw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="sfzj_2" name="sfzj" style="width: 50px;border: 0px;">
							<input id="sfzj_2_zw" name="sfzjzw" type="hidden">
						</td>
					</tr>
					<tr id = "tr_3" align="center">
						<td ><span>3</span></td>
						<td>
							<input id="ypqc_3" name="ypdm" style="width: 400px;border: 0px;">
							<input id="ypqc_3_zw" name="ypqc" style="width: 400px;border: 0px;" type="hidden"> 
						</td>
						<td>
							<input id="ypjl_3" name="ypjl" style="width: 200px;border: 0px;">
							<input id="ypjl_3_zw" name="ypjlzw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="fyfs_3" name="fyfs" style="width: 200px;border: 0px;">
							<input id="fyfs_3_zw" name="fyfszw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="sfzj_3" name="sfzj" style="width: 50px;border: 0px;">
							<input id="sfzj_3_zw" name="sfzjzw" type="hidden">
						</td>
					</tr>
					<tr id = "tr_4" align="center">
						<td ><span>4</span></td>
						<td>
							<input id="ypqc_4" name="ypdm" style="width: 400px;border: 0px;">
							<input id="ypqc_4_zw" name="ypqc" style="width: 400px;border: 0px;" type="hidden"> 
						</td>
						<td>
							<input id="ypjl_4" name="ypjl" style="width: 200px;border: 0px;">
							<input id="ypjl_4_zw" name="ypjlzw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="fyfs_4" name="fyfs" style="width: 200px;border: 0px;">
							<input id="fyfs_4_zw" name="fyfszw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="sfzj_4" name="sfzj" style="width: 50px;border: 0px;">
							<input id="sfzj_4_zw" name="sfzjzw" type="hidden">
						</td>
					</tr>
					<tr id = "tr_5" align="center">
						<td ><span>5</span></td>
						<td>
							<input id="ypqc_5" name="ypdm" style="width: 400px;border: 0px;">
							<input id="ypqc_5_zw" name="ypqc" style="width: 400px;border: 0px;" type="hidden"> 
						</td>
						<td>
							<input id="ypjl_5" name="ypjl" style="width: 200px;border: 0px;">
							<input id="ypjl_5_zw" name="ypjlzw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="fyfs_5" name="fyfs" style="width: 200px;border: 0px;">
							<input id="fyfs_5_zw" name="fyfszw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="sfzj_5" name="sfzj" style="width: 50px;border: 0px;">
							<input id="sfzj_5_zw" name="sfzjzw" type="hidden">
						</td>
					</tr>
					<tr id = "tr_6" align="center">
						<td ><span>6</span></td>
						<td>
							<input id="ypqc_6" name="ypdm" style="width: 400px;border: 0px;">
							<input id="ypqc_6_zw" name="ypqc" style="width: 400px;border: 0px;" type="hidden"> 
						</td>
						<td>
							<input id="ypjl_6" name="ypjl" style="width: 200px;border: 0px;">
							<input id="ypjl_6_zw" name="ypjlzw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="fyfs_6" name="fyfs" style="width: 200px;border: 0px;">
							<input id="fyfs_6_zw" name="fyfszw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="sfzj_6" name="sfzj" style="width: 50px;border: 0px;">
							<input id="sfzj_6_zw" name="sfzjzw" type="hidden">
						</td>
					</tr>
					<tr id = "tr_7" align="center">
						<td ><span>7</span></td>
						<td>
							<input id="ypqc_7" name="ypdm" style="width: 400px;border: 0px;">
							<input id="ypqc_7_zw" name="ypqc" style="width: 400px;border: 0px;" type="hidden"> 
						</td>
						<td>
							<input id="ypjl_7" name="ypjl" style="width: 200px;border: 0px;">
							<input id="ypjl_7_zw" name="ypjlzw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="fyfs_7" name="fyfs" style="width: 200px;border: 0px;">
							<input id="fyfs_7_zw" name="fyfszw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="sfzj_7" name="sfzj" style="width: 50px;border: 0px;">
							<input id="sfzj_7_zw" name="sfzjzw" type="hidden">
						</td>
					</tr>
					<tr id = "tr_8" align="center">
						<td ><span>8</span></td>
						<td>
							<input id="ypqc_8" name="ypdm" style="width: 400px;border: 0px;">
							<input id="ypqc_8_zw" name="ypqc" style="width: 400px;border: 0px;" type="hidden"> 
						</td>
						<td>
							<input id="ypjl_8" name="ypjl" style="width: 200px;border: 0px;">
							<input id="ypjl_8_zw" name="ypjlzw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="fyfs_8" name="fyfs" style="width: 200px;border: 0px;">
							<input id="fyfs_8_zw" name="fyfszw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="sfzj_8" name="sfzj" style="width: 50px;border: 0px;">
							<input id="sfzj_8_zw" name="sfzjzw" type="hidden">
						</td>
					</tr>
					<tr id = "tr_9" align="center">
						<td><span>9</span></td>
						<td>
							<input id="ypqc_9" name="ypdm" style="width: 400px;border: 0px;">
							<input id="ypqc_9_zw" name="ypqc" style="width: 400px;border: 0px;" type="hidden"> 
						</td>
						<td>
							<input id="ypjl_9" name="ypjl" style="width: 200px;border: 0px;">
							<input id="ypjl_9_zw" name="ypjlzw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="fyfs_9" name="fyfs" style="width: 200px;border: 0px;">
							<input id="fyfs_9_zw" name="fyfszw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="sfzj_9" name="sfzj" style="width: 50px;border: 0px;">
							<input id="sfzj_9_zw" name="sfzjzw" type="hidden">
						</td>
					</tr>
					<tr id = "tr_10" align="center">
						<td><span>10</span></td>
						<td>
							<input id="ypqc_10" name="ypdm" style="width: 400px;border: 0px;">
							<input id="ypqc_10_zw" name="ypqc" style="width: 400px;border: 0px;" type="hidden"> 
						</td>
						<td>
							<input id="ypjl_10" name="ypjl" style="width: 200px;border: 0px;">
							<input id="ypjl_10_zw" name="ypjlzw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="fyfs_10" name="fyfs" style="width: 200px;border: 0px;">
							<input id="fyfs_10_zw" name="fyfszw" style="width: 200px;border: 0px;" type="hidden">
						</td>
						<td>
							<input id="sfzj_10" name="sfzj" style="width: 50px;border: 0px;">
							<input id="sfzj_10_zw" name="sfzjzw" type="hidden">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
	<!-- 打印预览隐藏域 -->
	<div style="display: none">
		
	</div>	
	
	<!-- 修改药品信息隐藏域 -->
	<div id="modifyYpxxDiv" align="center" >
		<div style="margin-top: 20px;">
			<form id="modifyYpxxForm" method="post">
				<!-- 处方药品信息主键 -->
				<input id="cfypzj" name="uuid" type="hidden">
				<input id="cfzj" name="cfzj" type="hidden">
				<table>
					<tr>
						<td class="span01"><span>药品名称:</span></td>
						<td>
							<input id="ypqc_mf" name="ypdm" style="width: 400px;">
							<input id="ypqc_mf_zw" name="ypqc" style="width: 400px;" type="hidden"> 
						</td>
					</tr>
					<tr>
						<td class="span01"><span>药品剂量:</span></td>
						<td>
							<input id="ypjl_mf" name="ypjl" style="width: 400px;">
							<input id="ypjl_mf_zw" name="ypjlzw" style="width: 400px;" type="hidden">
						</td>
					</tr>
					<tr>
						<td class="span01"><span>服用方式:</span></td>
						<td>
							<input id="fyfs_mf" name="fyfs" style="width: 400px;">
							<input id="fyfs_mf_zw" name="fyfszw" style="width: 400px;" type="hidden">
						</td>
					</tr>
					<tr>
						<td class="span01"><span>是否针剂:</span></td>
						<td>
							<input id="sfzj_mf" name="sfzj" style="width: 400px;">
							<input id="sfzj_mf_zw" name="sfzjzw" type="hidden">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<a id="submitbtn_mf" href="javascript:void(0)" onclick="submitModifyForm();">修改</a>
			<a id="undo_mf" href="javascript:$('#modifyYpxxDiv').window('close');">取消</a>
			<a id="appendbtn" href="javascript:void(0)" onclick="appendCfyp();">添加</a>
		</div>
	</div>
	
	<script type="text/javascript" src="js/ypgl/cfgl.js"></script>
</body>
</html>



















