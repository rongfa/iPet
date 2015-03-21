<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<link href="/source/style/before.css" rel="stylesheet" type="text/css">
<title>社交网络</title>
</head>
<body>
	<div  class="logo" >iPet</div>
	<div  class="content" >
		<form id="contact" class="loginForm" >
			<input type="text" name="contactName" id="contactName"  value=""placeholder="手机号码"/>
			 <input type="text" name="contactEmail" id="contactEmail"  value="" placeholder="验证码" /> 
			 <input type="text" class="button" readonly="readonly" name="contactEmail" id="contactEmail"  value="寻回" /> 
		</form>
		<div  class="right-a" ><a href="home.action">直接登入？</a></div>
	</div>
</body>
</html>