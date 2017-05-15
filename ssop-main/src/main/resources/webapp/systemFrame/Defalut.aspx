<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Defalut.aspx.cs" Inherits="SysFrame.Web.Defalut" %>

<html>
<head>
	<title>ƽ̨����ϵͳ</title>
	<link href="Common/Css/FrameStyle.css" type="text/css" rel="Stylesheet" />	
</head>
<body leftmargin="0" topmargin="0" scroll="no" marginwidth="0" marginheight="0">
<form id="form1" runat="server">
	<table height="100%" cellspacing="0" cellpadding="0" width="100%" border="0">
		<tbody>
			<tr>
				<td style="border-bottom: #000000 1px solid; width: 100%; height: 50px;" colspan="3">
					<table height="49" cellspacing="0" cellpadding="0" width="100%"
						border="0">
						<tbody>
							<tr>
								<td width="50%" style=" background-image:url(Common/images/topbanner.jpg);">
								</td>
								<td width="50%" align="right" style="text-align:right; background-image:url(Common/images/topbannerbg.jpg);">
									<asp:Literal runat="server" ID="lblUser"></asp:Literal>&nbsp;|<span id="spanLoginInfo" runat="server"></span>
									   <asp:LinkButton ID="lbtnExit" runat="server" onclick="lbtnExit_Click">�˳�</asp:LinkButton>			
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td id="frmTitle" style="border-right: #000000 1px solid" align="center" valign="middle"
					width="12%" name="frmTitle">
					<iframe style="z-index: 2; visibility: inherit; width: 170px; height: 100%" name="BoardTitle"
						src="Left.aspx" frameborder="0" visible="true"></iframe>
				</td>
				<td class="navPoint" title="�ر�/������" style="width: 10pt;" bgcolor="#7898a8">
					<table height="100%" cellspacing="0" cellpadding="0" width="11" align="right" border="0">
						<tbody>
							<tr>
								<td class="tdMiddle" valign="middle" align="right">
									<img id="menuimg" onmouseover="javascript: menuonmouseover();" style="cursor: hand"
										onclick="javascript:switchSysBar()" onmouseout="javascript: menuonmouseout();"
										height="76" alt="��������" src="Common/images/Menu/close.gif" width="11" border="0" />
								</td>
							</tr>
						</tbody>
					</table>
				</td>
				<td style="width: 100%">
					<iframe id="mainFrame" style="z-index: 1; visibility: inherit; width: 100%; height: 100%"
						name="mainFrame" src="main.html" frameborder="0"></iframe>
				</td>
			</tr>
		</tbody>
	</table>

	<script language="javascript" type="text/javascript">

	var DispClose = true;

	function CloseEvent() {
		if (DispClose) {
			return "�Ƿ��뿪��ǰҳ��?";
		}
	}
	rnd.today = new Date();

	rnd.seed = rnd.today.getTime();

	function rnd() {
		rnd.seed = (rnd.seed * 9301 + 49297) % 233280;
		return rnd.seed / (233280.0);

	};

	function rand(number) {
		return Math.ceil(rnd() * number);

	};

	function AlertMessageBox(Messages) {
		DispClose = false;
		window.location.href = location.href + "?" + rand(1000000);
		alert(Messages);
	}function switchSysBar() 
	{
		if (document.getElementById("frmTitle").style.display == "none") {
			document.getElementById("frmTitle").style.display = ""
			var imgObj = document.getElementById("menuimg");
			imgObj.src = "Common/images/Menu/close.gif";
			imgObj.alt = "��������"
		}
		else {
			document.getElementById("frmTitle").style.display = "none"
			var imgObj = document.getElementById("menuimg");
			imgObj.src = "Common/images/Menu/open.gif";
			imgObj.alt = "��������"
		}
	}
	function menuonmouseover() 
	{
		var imgObj = document.getElementById("menuimg");
		if (document.getElementById("frmTitle").style.display == "none") {
			imgObj.src = "Common/images/Menu/open_on.gif";
		}
		else {
			imgObj.src = "Common/images/Menu/close_on.gif";
		}
	}
	function menuonmouseout() 
	{
		var imgObj = document.getElementById("menuimg");
		if (document.getElementById("frmTitle").style.display == "none") {
			imgObj.src = "Common/images/Menu/open.gif";
		}
		else {
			imgObj.src = "Common/images/Menu/close.gif";
		}
	}
	if (top != self) {
		top.location.href = "Defalut.aspx";
}


	</script>
</form>
</body>
</html>
