<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script> 
<script type="text/javascript">
	function submitloginForm (){
		var formdata = $("#loginForm").serializeArray();
		$.ajax({
			type : "POST",
			url : "login.do",
			data : formdata,
			dataType : "json",
			success : function (result){
				if(result.flag == "1001"){
					alert(result.msg);
					window.location="tomain.do";
				}else if(result.flag == "1002"){
					alert(result.msg);
				}
			},
			error : function (){
				alert("login ajax submit error");
			}
		});
	}
	
</script>
</head>
<body>
	<div align="center">
		<form id="loginForm" method="post">
			<table>
				<tr>
					<td>UserName:</td>
					<td><input id="username" name="username" ></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input id="password" name="password" type="password"></td>
				</tr>
				<tr>
					<td><input id="submitBtn" type="button" onclick="submitloginForm();" value="登录"></td>
				</tr>
			</table>
		
		</form>
	</div>
	
</body>
</html>