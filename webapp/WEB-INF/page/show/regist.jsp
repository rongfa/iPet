<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<link href="/source/style/before.css" rel="stylesheet" type="text/css">
<script type="text/javascript"  src="/source/scripts/jquery-1.8.2.min.js"></script>
<script type="text/javascript"  src="/source/scripts/regist.js"></script>
<title>社交网络</title>
</head>
<body>
	<div  class="logo" >iPet</div>
	<div class="content"> 
			<input type="text"id="email" placeholder="电子邮箱"/>
			 <input type="text"  class="button" readonly="readonly" onclick="getVerification()" value="获取验证码" /> 
		<div  class="rule" >一旦注册,即表示你同意<a href="home.action">我们iPet使用条款</a>,并已详读<a href="home.action">隐私政策</a>,包括Cookie的使用!</div>
		<div  class="right-a" ><a href="login.action">已加入iPet?</a></div>
		</div>
</body>
</html>