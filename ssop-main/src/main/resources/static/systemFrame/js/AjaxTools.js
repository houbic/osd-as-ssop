AjaxTools = function(){}

AjaxTools.AjaxGet = function(url)
{
	var s = new AjaxProxy();	
	var ajaxReturnValue = AjaxReturnValue(s.ajaxT(url));
	return ajaxReturnValue;
}

AjaxTools.GetUserList = function()
{
    var url = "";
    return AjaxTools.AjaxGet(url);
   }

   AjaxTools.GetCityList = function(pid) {
   var url = "../../systemFrame/Ajax/GetCityList.aspx?id=" + pid;
   	return AjaxTools.AjaxGet(url);
   }
   AjaxTools.GetDeptList = function(pid) {
   var url = "../../systemFrame/Ajax/GetDepartmentList.html?id=" + pid;
   	return AjaxTools.AjaxGet(url);
   }
   AjaxTools.GetRoleUser = function(rid, searchword,searchType) {

   var url = "../../systemFrame/Ajax/GetRoleUser.aspx?rId=" + rid + "&searchWord=" + escape(searchword) + "&searchType=" + searchType;
   return 	AjaxTools.AjaxGet(url);
   }
