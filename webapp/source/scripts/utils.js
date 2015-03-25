function goLogin() {
	location.href = "login.action";
}

function goRegist() {
	location.href = "regist.action";
}

function goFind() {
	location.href = "find.action";
}

function goManual() {
	window.open("/commonUI/manual.jsp");
}

function goOrdinance() {
	window.open("/commonUI/ordinance.jsp");
}

function verifyEmail(email) {
	if (email == "") {
		return false;
	}
	var search_str = /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/;
	return search_str.test(email);
}

function verifyNull(value) {
	return value == "";
}

function passNull(element) {
	element.bind("keypress", function(event) {
		return event.keyCode != 32;
	});
}