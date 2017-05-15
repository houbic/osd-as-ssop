window.onload = function() {
	GetRightValue();
}
function GetRightValue() {
	objRight = document.getElementById("SelectRight");

	var length = objRight.length - 1;
	var str = document.getElementById("hidObjRightValue").value;
	for (i = length; i >= 0; i--) {
		str += "ψ"+objRight.options[i].value ;
	}
	document.getElementById("hidObjRightValue").value = str;
}
function SetRightValue(v) {
	var str = document.getElementById("hidObjRightValue").value;
	str += "ψ" + v;
}
function GetRoleUser() {
	var rId = document.getElementById ("txthiddenRid").value;
	var searchWord = document.getElementById("txtUserName").value;
	var searchType = document.getElementById("txthiddenType").value;
	var objLeft = document.getElementById("SelectLeft");

	var result = AjaxTools.GetRoleUser(escape(rId), searchWord,searchType );
		objLeft.options.length = 0;
		var userList = result.value.split('θ');
		var user;
		for (var i = 0; i < userList.length; i++) {
			user = userList[i].split('ψ');
			objLeft.options.add(new Option( user[0],user[1]));
		}



		objRight = document.getElementById("SelectRight");

		 
		var tempAll = new Array()
		var rest = new Array();
		var length = objRight.length - 1;
		for (i = length; i >= 0; i--) {
			tempAll[i] = objRight.options[i].value + "ψ" + objRight.options[i].text;
			objRight.remove(i);

		}

		for (i = 0; i < tempAll.length; i++) {

			if (tempAll[i].substring(tempAll[i].indexOf("ψ"), tempAll[i].length).indexOf(searchWord) > 0) {
				objRight.options.add(new Option(tempAll[i].substring(tempAll[i].indexOf("ψ") + 1, tempAll[i].length), tempAll[i].substring(0, tempAll[i].indexOf("ψ"))));

			}
			else {
				rest[rest.length] = tempAll[i];
			}

		}

		for (i = objRight.length - 1; i >= 0; i--) {
			objRight.options[i].selected = true;
		}

		for (i = 0; i < rest.length; i++) {

			objRight.options.add(new Option(rest[i].substring(tempAll[i].indexOf("ψ") + 1, rest[i].length), rest[i].substring(0, tempAll[i].indexOf("ψ"))));



		}
	}
	 
 



function test() {

	objRight = document.getElementById("SelectRight");

	var keyWord = document.getElementById("txtUserName").value;
	var tempAll = new Array()
	var rest = new Array();
	var length = objRight.length - 1;
	for (i = length; i >= 0; i--) {
		tempAll[i] = objRight.options[i].value + "ψ" + objRight.options[i].text;
		objRight.remove(i);

	}

	for (i = 0; i < tempAll.length; i++) {

		if (tempAll[i].substring(tempAll[i].indexOf("ψ"), tempAll[i].length).indexOf(keyWord) > 0) {
			objRight.options.add(new Option(tempAll[i].substring(tempAll[i].indexOf("ψ") + 1, tempAll[i].length), tempAll[i].substring(0, tempAll[i].indexOf("ψ"))));

		}
		else {
			rest[rest.length] = tempAll[i];
		}

	}

	for (i = objRight.length - 1; i >= 0; i--) {
		objRight.options[i].selected = true;
	}

	for (i = 0; i < rest.length; i++) {

		objRight.options.add(new Option(rest[i].substring(tempAll[i].indexOf("ψ") + 1, rest[i].length), rest[i].substring(0, tempAll[i].indexOf("ψ"))));



	}

	objLeft = document.getElementById("SelectLeft");

	length = objLeft.length - 1;
	tempAll.length = 0;
	rest.length = 0

	for (i = length; i >= 0; i--) {
		tempAll[i] = objLeft.options[i].value + "ψ" + objLeft.options[i].text;
		objLeft.remove(i);

	}

	for (i = 0; i < tempAll.length; i++) {

		if (tempAll[i].substring(tempAll[i].indexOf("ψ"), tempAll[i].length).indexOf(keyWord) > 0) {
			objLeft.options.add(new Option(tempAll[i].substring(tempAll[i].indexOf("ψ") + 1, tempAll[i].length), tempAll[i].substring(0, tempAll[i].indexOf("ψ"))));

		}
		else {
			rest[rest.length] = tempAll[i];
		}

	}

	for (i = objLeft.length - 1; i >= 0; i--) {
		objLeft.options[i].selected = true;
	}

	for (i = 0; i < rest.length; i++) {

		objLeft.options.add(new Option(rest[i].substring(tempAll[i].indexOf("ψ") + 1, rest[i].length), rest[i].substring(0, tempAll[i].indexOf("ψ"))));



	}


}
 