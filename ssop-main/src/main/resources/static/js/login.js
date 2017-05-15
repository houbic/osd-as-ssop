function login() {

	var userName = document.getElementById("userName").value.trim();
	var password = document.getElementById("password").value;
	var code = document.getElementById("code").value;

	var params = {
		"userName" : userName,
		"password" : password,
		"code" : code
	}

	jumpToServlet("post", "/ssop/checkLogin", params);

}
function jumpToServlet(method, urls, params) {
	$.ajax({
		type: method,
		url: urls,
		dataType: "json",
		data: params,
		success: function (data) {
			if (data.code != 200) {
				alert("用户或密码错误！");
				return "/ssop/login";
			}
			window.location.href =  "/ssop/jumpPage";
			return true;
		}
	});
}

