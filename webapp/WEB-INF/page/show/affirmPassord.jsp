<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/page/common/top.jsp"%>
<link href="/source/style/before.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/source/scripts/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="/source/scripts/affirmPassord.js"></script>
<script type="text/javascript" src="/source/scripts/utils.js"></script>
<title>iPet</title>
</head>
<body>
		<div class="logo">iPet</div>
		<div class="content">
				<input type="text" id="verification" placeholder="验证码" onblur="verification()"/>
				<input type="password" id="password" placeholder="登陆密码" />
				<input type="password" id="affirmPassord" placeholder="确认密码" />
				<input type="text" class="button" readonly="readonly" onclick="affirm()" value="提交申请" />
				<div class="rule">
						如果长时间没有收到验证码,请<a onclick="getVerification()">重新获取</a>,或者<a onclick="javascript:history.go(-1);" >重新填写邮箱</a>.
				</div>
				<div class="right-a">
						<a onclick="goLogin()">直接登入iPet?</a>
				</div>
		</div>
</body>
</html>