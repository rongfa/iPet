function verification() {
	$.post("affirmPassord.verification.action", {
		verification : $("#verification").val()
	}, function(data) {
		data = eval(data);
		if (!data.success) {
			alert(data.message);
		}
	});
}

function getVerification() {
	$.post("affirmPassord.getVerificationCode.action", function(data) {
		data = eval(data);
		if (data.success) {
			alert("获取成功");
		} else {
			alert(data.message);
		}
	});
}

function affirm() {
	var nameValue = $("#verification").val();
	var pwdValue = $("#password").val();
	var affirmPassord = $("#affirmPassord").val();
	if (verifyNull(nameValue)) {
		alert("验证码不能为空");
	} else if (verifyNull(pwdValue)) {
		alert("密码不能为空");
	} else if (verifyNull(affirmPassord)) {
		alert("两次密码不一致");
	} else {
		$.post("affirmPassord.affirm.action", {
		    verification : $("#verification").val(),
		    password : $("#password").val(),
		    affirmPassord : $("#affirmPassord").val()
		}, function(data) {
			data = eval(data);
			if (data.success) {
				window.location.href = "home.action";
			} else {
				alert(data.message);
			}
		});
	}
}

$(function() {
	$("#password").bind("blur", function(event) {
		var password = $("#password").val();
		var affirmPassord = $("#affirmPassord").val();
		if (affirmPassord != "" && password != affirmPassord) {
			alert("两次输入密码不一致");
		}
	});

	$("#affirmPassord").bind("blur", function(event) {
		var password = $("#password").val();
		var affirmPassord = $("#affirmPassord").val();
		if (password != "" && password != affirmPassord) {
			alert("两次输入密码不一致");
		}
	});
});