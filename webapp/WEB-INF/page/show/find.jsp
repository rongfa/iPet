<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/page/common/top.jsp"%>
<link href="/source/style/before.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/source/scripts/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="/source/scripts/find.js"></script>
<script type="text/javascript" src="/source/scripts/utils.js"></script>
<title>iPet</title>
</head>
<body>
		<div class="logo">iPet</div>
		<div class="content">
				<input type="text" id="email" placeholder="电子邮箱" />
				<input id="button" type="text" class="button" readonly="readonly" onclick="getVerification()" value="获取验证码" />
				<div class="right-a">
						<a onclick="goLogin()">登入iPet</a>
				</div>
				<div class="right-a">
						<a onclick="goRegist()">申请加入iPet?</a>
				</div>
		</div>
</body>
</html>