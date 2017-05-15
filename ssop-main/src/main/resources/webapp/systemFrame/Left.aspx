<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Left.aspx.cs" Inherits="SysFrame.Web.Left" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>后台管理</title>	
	<link href="<%=VirtualDir %>Common/Css/FrameStyle.css" rel="stylesheet" type="text/css" />
	<script language="javascript" type="text/javascript">
	function showHide(id) 
	{
		var obj = document.getElementById(id);
		if(obj)
		{
			var oStyle = obj.style;
			oStyle.display == "none" ? oStyle.display = "block" : oStyle.display = "none";
		}
	}
    </script>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<form id="form1" runat="server">
<!--start-->
<asp:Repeater ID="RepeaterMenuOne" runat="server" 	onitemdatabound="RepeaterMenuOne_ItemDataBound">
	<ItemTemplate>
		<table cellspacing="0" cellpadding="0" width="144" align="center" border="0">
		  <tbody>
		  <tr>
			<td width="30"><img height="35" src="Common/images/Menu/box_topleft.gif" width="30"></td>
			<td class="tdMenuTitle" onclick="JavaScript:showHide('<%# DataBinder.Eval(Container.DataItem, "SM_ID")%>');" width="110" background="Common/images/Menu/box_topbg.gif"><%# DataBinder.Eval(Container.DataItem, "SM_Name")%> </td>
			<td width="4"><img height="35" src="Common/images/Menu/box_topright.gif" width="4"></td>
		  </tr>
		  </tbody>
		</table>
		<table id="<%# DataBinder.Eval(Container.DataItem, "SM_ID")%>" style="display: none" cellspacing="0" cellpadding="0" width="144" 
		align="center" border="0">
		  <tbody>
		  <tr>
			<td width="144" background="Common/images/Menu/box_bg.gif" colspan="3" height="0">
			  <table width="80%" style="margin-left:20px;">
				<tbody>
					<asp:Repeater ID="RepeaterMenuTwo" runat="server">
						<ItemTemplate>
							<tr>
								<td>
									<img height="7" hspace="5" src="Common/images/Menu/arrow.gif" width="5" align="absMiddle">
									<a href="<%# DataBinder.Eval(Container.DataItem, "SM_LinkURL")%>"  target="mainFrame"><%# DataBinder.Eval(Container.DataItem, "SM_Name")%></a>
								</td>
							</tr>
						</ItemTemplate>
					</asp:Repeater>
				</tbody></table></td></tr></tbody></table>
		<table cellspacing="0" cellpadding="0" width="144" align="center" border="0" style=" margin-bottom:5px;">
		  <tbody>
		  <tr>
			<td colspan="3"><img height="10" src="Common/images/Menu/box_bottom.gif" 
		  width="144"></td></tr></tbody></table>
	</ItemTemplate>
</asp:Repeater>
<!--end-->

</form>
</body>
</html>
