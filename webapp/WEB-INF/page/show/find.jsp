<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<link href="/source/style/before.css" rel="stylesheet" type="text/css">
<script type="text/javascript"  src="/source/scripts/jquery-1.8.2.min.js"></script>
<script type="text/javascript"  src="/source/scripts/find.js"></script>
<title>社交网络</title>
</head>
<body>
		<div  class="logo" >iPet</div>
	<div class="content"> 
			<input type="text"id="email" placeholder="电子邮箱"/>
			 <input type="text"  class="button" readonly="readonly" onclick="getVerification()" value="获取验证码" /> 
		<div  class="right-a" ><a href="login.action">直接登录iPet?</a></div>
		</div>
</body>
</html>