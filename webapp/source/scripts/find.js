function getVerification() {
	$("#button").attr({
		"disabled" : "disabled"
	});
	$.post("find.getVerificationCode.action", {
		email : $("#email").val()
	}, function(data) {
		data = eval(data);
		if (data.success) {
			window.location.href = "affirmPassord.action";
		} else {
			$("#button").removeAttr("disabled");
			alert(data.message);
		}
	});
}
