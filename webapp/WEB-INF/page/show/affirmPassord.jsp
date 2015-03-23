<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<link href="/source/style/before.css" rel="stylesheet" type="text/css">
<script type="text/javascript"  src="/source/scripts/jquery-1.8.2.min.js"></script>
<script type="text/javascript"  src="/source/scripts/affirmPassord.js"></script>
<title>社交网络</title>
</head>
<body>
	<div  class="logo" >iPet</div>
	<div class="content"> 
			<input type="text"id="verification" placeholder="验证码"/>
			<input type="password"id="password" placeholder="登陆密码"/>
			<input type="password"id="affirmPassord" placeholder="确认密码"/>
			 <input type="text"  class="button" readonly="readonly" onclick="regist()" value="申请加入" /> 
		<div  class="rule" >如果长时间没有收到验证码，请<a href="javascript:getVerification();">重新获取</a>,或者<a href="javascript:history.go(-1);">重新填写邮箱</a>.</div>
		<div  class="right-a" ><a href="login.action">直接登录iPet?</a></div>
		</div>
</body>
</html>