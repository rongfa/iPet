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
			<input type="text" name="contactName" id="contactName" placeholder="手机号码"/>
			 <input type="text"  id="contactEmail"  value="" placeholder="验证码" />
			 <input type="text" disabled="disabled" class="button" readonly="readonly" name="contactEmail" id="contactEmail"  value="加入" /> 
		</form>
		<div  class="rule" >一旦注册,即表示你同意<a href="home.action">我们iPet使用条款</a>,并已详读<a href="home.action">隐私政策</a>,包括Cookie的使用!</div>
		<div  class="right-a" ><a href="home.action">已加入iPet?</a></div>
	</div>
</body>
</html>