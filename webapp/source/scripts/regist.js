function getVerification() {
	var emailVaue = $("#email").val();
	if (verifyEmail(emailVaue)) {
		$("#button").attr({
			"disabled" : "disabled"
		});
		$.post("regist.getVerificationCode.action", {
			email : emailVaue
		}, function(data) {
			data = eval(data);
			if (data.success) {
				window.location.href = "affirmPassord.action";
			} else {
				$("#button").removeAttr("disabled");
				alert(data.message);
			}
		});
	} else {
		alert("邮箱格式不正确");
	}
}

$(function() {
	passNull($("#email"));
});