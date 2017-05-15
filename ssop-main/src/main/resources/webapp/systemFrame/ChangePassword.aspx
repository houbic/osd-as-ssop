<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ChangePassword.aspx.cs"
    Inherits="SysFrame.Web.ChangePassword" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ Register Assembly="Control" Namespace="Controls" TagPrefix="cc1" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head2" runat="server">
    <title>:::中国移动飞信运营支撑平台:::</title>
    <link href="Common/Css/Login.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="Common/js/jquery.js"></script>
    <script type="text/javascript" src="Common/js/BGConfig.js"></script>
    <script type="text/javascript">
        function CheckPwd() {
            var first = document.getElementById("txtPwd").value;
            var second = document.getElementById("txtPwd2").value;

            if (first != second) {
                $("#msgtip").text("两次输入不一致!");
                return false;
            }
            var reg = /^[0-9a-zA-Z\!@#\$%\^&\*\(\)_\+]{6,24}$/;
            if (reg.test(first) && first.replace(/[a-z\!@#\$%\^&\*\(\)_\+]/ig, '').length > 0 && first.replace(/[0-9a-z]/ig, '').length > 0 && first.replace(/[0-9\!@#\$%\^&\*\(\)_\+]/ig, '').length > 0) {
                return true;
            }
            $("#msgtip").text("您输入的密码不符合要求");
            return false;
        }

        $(function () {

            PosInput();
            $("#btnModify").hover(function () {
                $(this).attr("src", "Common/images/Login/modify-button-hover.png")
            }, function () {
                $(this).attr("src", "Common/images/Login/modify-button.png")
            })
            $("#btnModify").mousedown(function () {
                $(this).attr("src", "Common/images/Login/modify-button-click.png")
            })
        });

        $(window).resize(function () {

            PosInput();
        });

        function PosInput() {
            var content = $("#divLogin .changepwd-content>.bg");
            var table = $("#divLogin .changepwd-content table");
            table.css("margin-top", content.height() * 0.270);
            table.css("left", content.width() * 0.33);
            table.find("td").height(content.height() * 0.11);

        }
    </script>
</head>



<body>
    <form id="form1" runat="server">
        <div id="divLogin">
            <div class="top">
                <div class="top_logo">
                    <img src="Common/images/Login/logo.png" style="width: 452px; height: 117px" />
                </div>
                <div class="top1">
                    <span>欢迎！<asp:Literal ID="ltlName" runat="server"></asp:Literal>！</span>
                    <br />
                    <span class="bg"></span><span class="menu"><a href="#" class="selected">修改密码</a><a style="cursor: pointer;" href="logout.html">退出</a></span>
                </div>
            </div>
             
            <div class="changepwd-content content">
                <span style="font-weight: bold;">提示：密码只能为6-24位字母,数字,以及以下字符!@#$%^&*()_+|的组合</span>
                <img class="bg" src="Common/images/Login/changepwd-content.png" alt="" />    
                <table>

                    <tr>
                        <td>
                           
                            <cc1:CustTextBox  ID="txtOlePwd"  TextMode="Password" runat="server" CssClass="input"></cc1:CustTextBox>
                        </td>
                    </tr>
                    <tr>

                        <td>
                  
                            <cc1:CustTextBox  ID="txtPwd"  TextMode="Password" runat="server" CssClass="input"></cc1:CustTextBox>
                        </td>
                    </tr>
                    <tr>

                        <td>
                            <cc1:CustTextBox  ID="txtPwd2"  TextMode="Password" runat="server" CssClass="input"></cc1:CustTextBox>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align:center;">
                            <asp:ImageButton ID="btnModify" ImageUrl="Common/images/Login/modify-button.png" style="width:176px;height:46px;" 
                                runat="server" OnClientClick="return CheckPwd();" OnClick="btnChange_Click" />
                        </td>
                    </tr>
                     <tr>
                        <th style="height:40px; vertical-align:bottom; color:red;">
                             <span id="msgtip"><asp:Literal ID="ltlMsg" runat="server"></asp:Literal></span>
                        </th>
                    </tr>
                   
                </table>
            </div>
            <div class="copyright">
                中国移动版权所有<br />
                <br />
                copyright&copy;2004-2008 .All rights reserved. 京ICP备05024888号
                <img alt="中国移动通信" src="Common/images/Login/cmcc-logo.png" />
            </div>
        </div>
    </form>
</body>
</html>
