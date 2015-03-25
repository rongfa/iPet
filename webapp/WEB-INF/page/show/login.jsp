<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/page/common/top.jsp"%>
<link href="/source/style/before.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/source/scripts/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="/source/scripts/utils.js"></script>
<script type="text/javascript" src="/source/scripts/login.js"></script>
<title>iPet Login</title>
</head>
<body>
		<div class="logo">iPet</div>
		<div class="content">
				<input type="text" id="name" placeholder="电子邮箱/昵称" />
				<input type="password" id="password" placeholder="密码" />
				<input type="text" class="button" readonly="readonly" onclick="login()" value="登入" />
				<div class="right-a">
						<a onclick="goRegist()">申请加入iPet</a>
				</div>
				<div class="right-a">
						<a onclick="goFind()">帮助?</a>
				</div>
		</div>
</body>
</html>