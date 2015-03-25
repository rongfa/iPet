function login() {
	var nameValue = $("#name").val();
	var pwdValue = $("#password").val();
	if (verifyNull(nameValue)) {
		alert("用户名不能为空");
	} else if (verifyNull(pwdValue)) {
		alert("密码不能为空");
	} else {
		$.post("login.login.action", {
		    name : nameValue,
		    password : pwdValue
		}, function(data) {
			data = eval(data);
			if (data.success) {
				if (window != top) {
					top.location.href = "home.action";
				}
				location.href = "home.action";
			} else {
				alert(data.message);
			}
		});
	}
}
$(function() {
	passNull($("#name"));
	passNull($("#password"));
	var input = $("input");
	input.bind("keydown", function(event) {
		if (event.keyCode == 13) {
			login();
		}
	});
});