$(function () {
    $("#divLogin").prepend("<img class='bg' src='/systemFrame/images/Login/login-bg.jpg' />");
    SizeBG();
   
});

$(window).resize(function () {
    //SizeBG();
   
});
function SizeBG() {
    var div = $("#divLogin");
    
    var img = $("#divLogin>.bg");
    var content = $("#divLogin .content>.bg");
    var logo = $("#divLogin .top_logo img");
    var width = img.width();
   
    img.width(div.width());
    img.height(img.width() / width * img.height());
    content.width(img.width() / width * content.width())
    content.height(img.width() / width * content.height())

    logo.width(img.width() / width * logo.width())
    logo.height(img.width() / width * logo.height())
   
    var btn = $("input[type='image']");
    btn.width(img.width() / width * btn.width())
    btn.height(img.width() / width * btn.height())
    btn.css("margin-top", content.height() * 0.01)


    var logincontent = $("#divLogin .login-content");
    logincontent.css("top", img.height() * 0.2)

    var pwdcontent = $("#divLogin .changepwd-content");
    pwdcontent.css("top", img.height() * 0.28)

    var copyrights = $("#divLogin .copyright");
    copyrights.css("top", img.height() * 0.85);

    var fisheye = $("#divLogin .fisheye");
    fisheye.css("top", img.height() * 0.3);
}