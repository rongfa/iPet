<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<link href="/source/style/before.css" rel="stylesheet" type="text/css">
<script type="text/javascript"  src="/source/scripts/jquery-1.8.2.min.js"></script>
<script type="text/javascript"  src="/source/scripts/login.js"></script>
<title>社交网络</title>
</head>
<body>
	<div  class="logo" >iPet</div>
	<div  class="content" >
		<form id="login" class="loginForm"  method="post" >
			<input type="text"  id="name" size="3" placeholder="手机号码/昵称"/>
			 <input type="password" id="password"  placeholder="密码" /> 
			 <input type="text" class="button" readonly="readonly" onclick="login()" value="登入" /> 
		</form>
		<div  class="right-a" ><a href="regist.action">申请加入iPet</a></div>
		<div  class="right-a" ><a href="find.action">需要帮助?</a></div>
	</div>
	
</body>
</html>