 

function selectMoveLeftAll(leftTemp,rightTemp) 
{
	var objLeft = document.getElementById(leftTemp);
	var objRight = document.getElementById(rightTemp);
	for (i = 0; i < objRight.length; i++) {
		objLeft.options.add(new Option(objRight.options[i].text, objRight.options[i].value));
		objRight.remove(0);
		i--;
	}
}

function selectMoveRightAll(leftTemp,rightTemp)
{
	var objLeft = document.getElementById(leftTemp);
	var objRight = document.getElementById(rightTemp);
	for(i = 0;i < objLeft.length;i++)
	{
	
		objRight.options.add(new Option(objLeft.options[i].text, objLeft.options[i].value));
		objLeft.remove(0);
		i--;
	}
}
function selectMoveLeft(leftTemp,rightTemp,tempSign)
{
    var objLeft = document.getElementById(leftTemp);
    var objRight = document.getElementById(rightTemp);
    for(i = 0;i < objRight.length;i++)
    {
        if(objRight.options[i].selected)
        {
	        objLeft.options.add(new Option(objRight.options[i].text,objRight.options[i].value));
	        objRight.remove(i);
	        i--;
        }
    }
}
function selectMoveRight(leftTemp,rightTemp,tempSign)
{
    var objLeft = document.getElementById(leftTemp);
    var objRight = document.getElementById(rightTemp);
    var selected;
    for(i = 0;i < objLeft.length;i++) {
    	selected = objLeft.options[i].value;
    	if (objLeft.options[i].selected && document.getElementById("hidObjRightValue").value.indexOf("ψ"+selected )<0)
        { 
	        objRight.options.add(new Option(objLeft.options[i].text,objLeft.options[i].value));
	        objLeft.remove(i);
	        i--;
	        document.getElementById("hidObjRightValue").value+="ψ"+selected ;
        }
    }
}

function GetSelectRightValue(rightTemp,hidInput)
{
	var objRight = window.document.getElementById(rightTemp );
	var objInput = window.document.getElementById(hidInput );
    var list = new String();
    for(i = 0;i < objRight.length;i++)
    {	        
        list = list.concat(objRight.options[i].text);
        list = list.concat("|");
        list = list.concat(objRight.options[i].value);	
        list = list.concat("ほ");			        	        		        
    }
    objInput.value = list.substring(0,list.length-1);
}
//确认删除
function ConfirmDel()
{
    if(confirm("确定要删除么?"))
    {
        return true;
    }
    return false;
}
//选择grid列表复选框
function checkFormAll(id)
{
    form = document.getElementsByTagName("input");
    var value = document.getElementById(id).checked;
    for(var i=0; i<form.length; i++)
    {
        if (form[i].type=="checkbox" && !form[i].disabled && form[i].id != "chkAll")
        {
            form[i].checked = value;
        }
    }
}
//检查是否选择了行，排除id为chkAll的复选框
 function CheckIsSelected(type)
{
	//type =2/删除操作，1/编辑操作,0/添加,和EnumUtil.OperateType枚举保持一致
    form = document.getElementsByTagName("input");
    var flag = false;
    var count=0;
    for(var i=0; i<form.length; i++)
    {
        if (form[i].type=="checkbox" && form[i].id != "chkAll" && form[i].checked && !form[i].disabled)
        {
            count++;
            break;
        }
    }
    if(type==2)
    {
		if(count==0)
		{
			alert("请选择记录！");
			return false;
		}
	}
	else if(type==1)
	{
		if(count != 1)
		{
			alert("请选择一条记录！");
			return false;
		}
	}
    return true;
}
//单选框必须选择一条记录
function CheckOne(stralert,varform)
{
	var j=0;
	for ( var i =0; i<varform.elements.length;i++)
	{
		var e = varform.elements[i];
		if(e.type=="radio"&&e.checked==true)
		{
			j++
		}
	}
	if(j == 0)
	{
		alert(stralert);	
		return false; 
	}
}

function Get_Center(size, side)
{
	self.y_center=(parseInt(screen.height/2));
	self.x_center=(parseInt(screen.width/2));
	center = eval('self.'+side+'_center-('+size+'/2);');
	return(parseInt(center));
}

function OpenWin(url, name, height, width)
{
	var left = Get_Center(width,'x');	
	var top = Get_Center(height,'y');
	if (top > 30)
	{
		top = top - 30;
	}
	window.open(url,name,"height=" + height + ",width=" + width + ",left=" + left + ",top=" + top + ",scrollbars=no,toolbar=no,menubar=no,status=no,location=no,resizable=no");
}
//模态对话框
function OpenModalDialog(url, height, width)
{
   return window.showModalDialog(url + "&rdm=" + Math.random(),document,"dialogHeight: " + height + "px; dialogWidth: " + width + "px;edge: Raised; center: Yes; help: No; resizable: No; scrollbars:No;location:No;status:No");
}
//模态对话框
function OpenModalDialog(url, argument,height, width)
{
   return window.showModalDialog(url + "&rdm=" + Math.random(),argument,"dialogHeight: " + height + "px; dialogWidth: " + width + "px;edge: Raised; center: Yes; help: No; resizable: No; scrollbars:No;location:No;status:No");
}

function ValidateLength(oSrc, args)
{
	args.IsValid = (args.Value.length <= oSrc["limit"]); 
}

function ValidateRemarkLength(id,len)
{
	var obj = document.getElementById(id)
	if(obj)
		if(obj.value.length>len)
		{
			if(event.keyCode !=8 && event.keyCode != 46 &&  event.keyCode !=34 && event.keyCode!=35 &&  event.keyCode !=36 && event.keyCode!=37 &&  event.keyCode !=38 && event.keyCode!=39 && event.keyCode!=40)
				event.returnValue=false
		}
}

function ValidateDateTime(str)
{
    var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/; 
    var r = str.match(reg); 
    if(r==null)return false; 
    var d= new Date(r[1], r[3]-1,r[4]); 
    var newStr=d.getFullYear()+r[2];
    if (d.getMonth()+1-10 >= 0)
    {
        newStr +=(d.getMonth()+1)+r[2];
    }
    else
    {
        newStr +='0' + (d.getMonth()+1)+r[2];
    }
    if (d.getDate()+1-10 > 0)
    {
        newStr +=d.getDate();
    }
    else
    {
        newStr +='0' + d.getDate();
    }
    return newStr==str ;
}    
//日期相减，得出天数
function DateDiff(strDate1, strDate2)
{
	var  strDate1  =  strDate1.substring(0,10) + "  00:00:00.0";  
	var  strDate2  =  strDate2.substring(0,10) + "  00:00:00.0";  
	strDate1=strDate1.substring(0,strDate1.lastIndexOf(".")).replace(/-/g,"/");  
	strDate2=strDate2.substring(0,strDate2.lastIndexOf(".")).replace(/-/g,"/");  
	var  date1  =  Date.parse(strDate1);  
	var  date2  =  Date.parse(strDate2);  
	var diffValue = Math.ceil((date2-date1)/(24*60*60*1000));
	return diffValue;
}

function Trim(str)
{
    str = str.replace(/\ /g, '');
    return str;
}

//格式化数字(数字，小数位数)
function FormatNumber(srcStr,nAfterDot){
    var srcStr,nAfterDot;
    var resultStr,nTen;
    srcStr = ""+srcStr + "";
    strLen = srcStr.length;
    dotPos = srcStr.indexOf(".",0);
    if (dotPos == -1){
        resultStr = srcStr+".";
        for (i=0;i<nAfterDot;i++){
            resultStr = resultStr+"0";
        }
        return resultStr;
    } else{
        if ((strLen - dotPos - 1) >= nAfterDot){
            nAfter = dotPos + nAfterDot + 1;
            nTen =1;
            for(j=0;j<nAfterDot;j++){
            nTen = nTen*10;
        }
        resultStr = Math.round(parseFloat(srcStr)*nTen)/nTen;
        return resultStr;
        } else{
            resultStr = srcStr;
            for (i=0;i<(nAfterDot - strLen + dotPos + 1);i++){
                resultStr = resultStr+"0";
            }
            return resultStr;
        }
    }
}
//刷新父页面
function parPageRefresh()
{
	var url = window.parent.location.href;
	url = url.replace("#","");
	window.parent.location.href  = url;
}
//取cookies函数
function GetCookie(name)        
{
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
     if(arr != null) return unescape(arr[2]); return null;

}
//验证输入是否为整数
function CheckInt(str)
{
    var reg = /^\d+$/;
    return reg.test(str);
}
//验证输入是否为浮点数
function CheckDecimal(str)
{
    var reg = /^([1-9][0-9]{0,9}|[0-9])(\.\d{1,2}){0,1}$/;
    return reg.test(str);
} 
//全选或全不选，并将选中的CheckBox对应的Value保存到HiddenField中
function SelectCheckBoxAll(chkAll, objName, objHidd)
{
    var form = document.forms[0];
    for(var i=0; i<form.elements.length; i++)
    {
        if (form.elements[i].type=="checkbox")
        {
            var len = form.elements[i].name.length;
            var currName = form.elements[i].name;
            var subCurrName = currName.substring(len - objName.length, len);
            if (subCurrName==objName && form.elements[i].disabled == false)
            {
                form.elements[i].checked = chkAll;
                SelectCheckBox(form.elements[i], objHidd);
            }   
        }
    }
}

function SelectCheckBox(objChk, objHidd) 
{
    var valueContainer = document.getElementById(objHidd);
    var oldvalue=valueContainer.value;
    var newValue="";
    var oldValueArray=oldvalue.split(",");
    var i = 0;
    for(i=0;i<oldValueArray.length;i++)
    {
        if(objChk.value!=oldValueArray[i])
        {
            if(oldValueArray[i]!="")
            {
                newValue+=oldValueArray[i]+",";
            }
        }
    }
    if (objChk.checked == true)
    {
        newValue += objChk.value;
    }
    valueContainer.value=newValue;
}
// 用途：enter 转化成tab
//使用：onload ="initEnter2Tab()" form标记加上 <form name="frm" type="enter2tab">...</form>
var isCycle = false; //当光标到最后一个元素的时候，是否循环光标焦点，
var iCurrent = -1;
var frmName = "0"//input_form
//
function enterToTab()  //网页里按回车时焦点的转移
{
  var e = document.activeElement;
  if(e == null) return false;
  //获得当前表单的名字


  for(i=0;i<document.forms.length;i++){  
 for(var el in document.forms[i].elements){
  if(e.UniqueID == el.UniqueID){
   frmName = document.forms[i].name
  }    
 } 
  }
  if(window.event.keyCode == 13)
  {  
   switch(e.tagName)//标签类型
 {
     case "INPUT":
   handleInput(e)
   break;
     case "SELECT":
   handleSelect(e)   
   break;  
     case "TEXTAREA":
   handleTextarea(e)
   break;   
         default:  
    //window.status = "未知的标签名称:"+e.tagName+"，不能移动焦点！"
    }  
  }// end if
}
//处理input 标签类型
function handleInput(e)
{
   switch(e.type)
 {
     case "text":
  case "password":
  case "checkbox":
  case "radio":
  case "file":
   moveFocusToNextElement(e)
   break; 
 // case "submit"://处理有提交按钮的情况
  case "button":
   if(isHandleSubmit(e)){
    handleSubmit(e)
    focusOnNextElement(document.forms[frmName].elements,iCurrent-1)
    break;
   }
   moveFocusToNextElement(e)
   break;            
         default:  
        
    }
}
//处理select 标签类型
function handleSelect(e)
{
 moveFocusToNextElement(e)
}
//处理textarea 标签类型
function handleTextarea(e)
{
 //moveFocusToNextElement(e)
}
//移动到下一个元素
function moveFocusToNextElement(e)
{
  var oE = document.forms[frmName].elements, iCurentPos=-1;
  for(var i=0; i<oE.length; i++)
  {
    if(oE[i] == e) iCurentPos = i;
    if(iCurentPos>-1 && iCurentPos+1<oE.length)
    {
    //把焦点设置到下一个可用的元素上  
  focusOnNextElement(oE,iCurentPos)
    }
  }
}
//下一个可用元素得到焦点 n 元素的位置
function focusOnNextElement(oElements,iIndex)
{
	var oE = oElements
	var oldIndex = iIndex 
//    var no = false;
//	if(oE[iIndex+1].parentElement.parentElement.style.display == "none"
//	 || oE[iIndex+1].parentElement.parentElement.parentElement.style.display == "none");
//	{
//	    //alert(oE[iIndex+1].id);
//	    
//	    no = true;
//	}
	while(oE[iIndex+1].type =="hidden" || oE[iIndex+1].parentElement.parentElement.style.display == "none"
	 || oE[iIndex+1].parentElement.parentElement.parentElement.style.display == "none"
		|| oE[iIndex+1].disabled || oE[iIndex+1].tagName == "FIELDSET" || oE[iIndex+1].style.display == "none")
	{ 
		/*window.status += "e.name = "+oE[iIndex+1].name
		window.status += ";e.type = "+oE[iIndex+1].type
		window.status += ";e.disabled = "+oE[iIndex+1].disabled
		window.status += ";e.readOnly = "+oE[iIndex+1].readOnly+"."*/
		iIndex++;
		if(iIndex+1 == oE.length)
		{
		
			if(isCycle)
			{//设置焦点在第一元素
				focusOnNextElement(oE,-1);
			} 
			return;
		}
	}//end while
	iCurrent = iIndex+1
	oE[iCurrent].focus();
        //window.event.keyCode    = 0;
    window.event.returnValue= false; 
    return;
}
function focusFirstElement(oElements,iIndex)
{
	var oE = oElements
	var oldIndex = iIndex 
	while(oE[iIndex+1].type =="hidden" 
		|| oE[iIndex+1].tagName == "SELECT"
		|| oE[iIndex+1].readOnly == true
		|| oE[iIndex+1].disabled || oE[iIndex+1].tagName == "FIELDSET" || oE[iIndex+1].style.display == "none")
	{ 
		/*window.status += "e.name = "+oE[iIndex+1].name
		window.status += ";e.type = "+oE[iIndex+1].type
		window.status += ";e.disabled = "+oE[iIndex+1].disabled
		window.status += ";e.readOnly = "+oE[iIndex+1].readOnly+"."*/
		iIndex++;
		if(iIndex+1 == oE.length)
		{
		
			if(isCycle)
			{//设置焦点在第一元素
				focusFirstElement(oE,-1);
			} 
			return;
		}
	}//end while
	iCurrent = iIndex+1
	oE[iCurrent].focus();
        //window.event.keyCode    = 0;
    window.event.returnValue= false; 
    return;
}

//处理当前元素
function handleSubmit(element)
{
 element.click()
 return; 
}
//判断是否处理提交
function isHandleSubmit(element)
{
 var ret = false;
 if(element !=null && (element.id.toUpperCase() == "SUBMIT" || element.name.toUpperCase() == "SUBMIT" || element.isSubmit)){
  ret = true;
 }
 return ret; 
}

function initEnter2Tab()
{
	 for(i=0;i<document.forms.length;i++){
	   document.forms[i].onkeydown = function f(){enterToTab();};
	 }

	 if(document.forms[0].elements != null)
	 {
	  focusFirstElement(document.forms[0].elements,-1)
	 }
} 

if(document.attachEvent)
{
	window.attachEvent("onload",  initEnter2Tab);
}
else
{
	window.addEventListener('load',  initEnter2Tab,  false);
}



