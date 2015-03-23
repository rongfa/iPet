function login() {
	$.post("login.login.action", {
		name : $("#name").val(),
		password : $("#password").val()
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

$(function() {
	var login = $("#password");
	login.bind("keydown", function(event) {
		if (event.keyCode == 13) {
			login();
		}
	});
});