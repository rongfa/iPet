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
