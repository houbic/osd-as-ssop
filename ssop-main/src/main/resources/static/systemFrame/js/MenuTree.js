//checkboxi 对应1  spani 
function findParent(ChildBox,action)
{
   
   var Par=ChildBox.parentElement;
   
   if(action=="true") 
   {    while(Par!=null)
       {   
           
           if(typeof(Par.belongCheckbox)!="undefined")
           {
               //alert(Par.belongCheckbox);
               document.getElementById(Par.belongCheckbox).checked="checked";
           }
           Par=Par.parentElement;
       } 
   }
   else
   {     
         Par=Par.parentElement;                                
         //alert(Par.id);
         if(typeof(Par.belongCheckbox)!="undefined")
         {
              var flag=true;
              var checkBox=Par.getElementsByTagName("input");  //得到父接点的所有checkbox
              for(var i=0;i<checkBox.length;i++)
              {
                 if(checkBox[i].checked)
                 {
                     flag=false;                  //还有checkbox 选种
                     break;              
                 }
              }
              if(flag)
              {   
                  document.getElementById(Par.belongCheckbox).checked="";
                  findParent(document.getElementById(Par.belongCheckbox),"false");     
              }
         }
      
   
   } 
}

function SelectBox(diving,obj)
{    
    //Checkbox1
    
    document.getElementById("TextNode").value=document.getElementById("span_"+obj.id.replace("Checkbox","")).innerText;
    
    if(obj.checked)   
    {
      obj.checked="checked";
      if(document.getElementById(diving)!=null)
      {  
         var checkbox=document.getElementById(diving).getElementsByTagName("input");
         for(var i=0;i<checkbox.length;i++)
                checkbox[i].checked="checked";
      }
      findParent(obj,"true"); 
    }
    else
    {
         
      obj.checked="";
      if(document.getElementById(diving)!=null)
      {  
         var checkbox=document.getElementById(diving).getElementsByTagName("input");
         for(var i=0;i<checkbox.length;i++)
                checkbox[i].checked="";
      }
      findParent(obj,"false");          //加如子接点全不取消选中,但是他的父结点还是选中(bug) 
    }
}

function ClickMenu(diving,plusing,num)
{ 
  
  if(document.getElementById(diving).style.display=="none")   //说明是合并状态
  {
     document.getElementById(diving).style.display='block';
     if(plusing=="plus")
     {
       document.getElementById(plusing+num).src="../../common/images/minus.gif";
     }
     else if(plusing=="nolines")
     {
     	document.getElementById(plusing + num).src = "../../common/images/minus_nolines.gif";
     } 
     else if(plusing=="bottom")
     {
     	document.getElementById(plusing + num).src = "../../common/images/minus_bottom.gif";
     }
     document.getElementById("open" + num).src = "../../common/images/close.gif";

                
  }
  else    //说明是张开状态
  {
     document.getElementById(diving).style.display='none';
     if(plusing=="plus")
     {
     	document.getElementById(plusing + num).src = "../../common/images/plus.gif";
     }
     else if(plusing=="nolines")
     {
     	document.getElementById(plusing + num).src = "../../common/images/plus_nolines.gif";
     } 
     else if(plusing=="bottom")
     {
     	document.getElementById(plusing + num).src = "../../common/images/plus_bottom.gif";
     }
     document.getElementById("open" + num).src = "../../common/images/open.gif"; 

  }
  
}

function ChangeColora(obj)
{
 
   obj.className='Node-selected';
}

function ChangeColorb(obj)
{
 
   obj.className='Node-unselect';

}