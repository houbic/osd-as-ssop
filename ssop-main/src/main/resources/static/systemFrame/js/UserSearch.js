function GetCityList() {
	var pid = document.getElementById("ddlArea").value;
	var Cityobj = document.getElementById("ddlCityList");

	if (pid != -1) {

		var result = AjaxTools.GetCityList(escape(pid));
		Cityobj.options.length = 0;
		var CityList = result.value.split(',');
		var city;
		for (var i = 0; i < CityList.length; i++) {
			city = CityList[i].split('|');
			Cityobj.options.add(new Option(city[1], city[0]));
		}
	}
	else {
		Cityobj.options.length = 0;
		Cityobj.options.add(new Option("--全部--", "-1"));
	}
}


function GetDepartmentList() {
	var pid = document.getElementById("ddlCompanyList").value;
	var Deptobj = document.getElementById("ddlDepartment");

	if (pid != -1) {

		var result = AjaxTools.GetDeptList(escape(pid));
		Deptobj.options.length = 0;
		var DeptList = result.value.split(',');
		var dept;
		for (var i = 0; i < DeptList.length; i++) {
			dept = DeptList[i].split('|');
			Deptobj.options.add(new Option(dept[1], dept[0]));
		}
	}
	else {
		Deptobj.options.length = 0;
		Deptobj.options.add(new Option("--全部--", "-1"));
	}
}
