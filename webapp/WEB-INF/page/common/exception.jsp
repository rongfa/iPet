<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/page/common/top.jsp"%>
<link href="/source/style/before.css" rel="stylesheet" type="text/css">
<title>iPet ErrorPage</title>
</head>
<body>
		<div class="logo">操作异常</div>
		<div class="content">
				<form id="contact" class="loginForm">
						<input type="text" class="button" readonly="readonly" onclick="javascript:top.location.href='home.action';" value="去主页" />
				</form>
		</div>
</body>
</html>