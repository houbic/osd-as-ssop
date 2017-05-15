var AjaxProxy = function(){
	
	this.ajaxGLOBAL = null;
	}

AjaxProxy.prototype.eAT = function(i,u,P){

		this.eAA(i,u,"Text",true,P);
}

AjaxProxy.prototype.eAX = function(i,u,P){
	
		this.eAA(i,u,"XML",true,P);
}

AjaxProxy.prototype.ajaxT = function(u,P){

		return this.eAA({},u,"Text",false,P).responseText;
}

AjaxProxy.prototype.ajaxX = function(u,P){
	
		return this.eAA({},u,"XML",false,P).responseXML;
}

AjaxProxy.prototype.eAA = function(it,u,rt,asy,sv){
     
    var st  = "GET";
    var s = "";
    
    if(sv)
    { 
     	s  = sv ;
     	st  = "POST";
    	
    	}
    
    var eA = ajaxCreate();
    
    eA.onreadystatechange = function(){

        if(eA.readyState==4){
         	
			//可以在这里添加更多的状态码判断信息,一般没有这个必要.会加大运算量.
			
            if (eA.status == 200) {
             	
                if(rt=="Text"){o(eA.responseText);}
                else if(rt=="XML"){o(eA.responseXML);}
            } 
            
        }

    }
    
    var o = function(v){
    
        this.ajaxGLOBAL = v;
    
        if(typeof(it)=="function"){ it.call();}
        else
        {it = v;}
   
    }
    
    if(u.indexOf('?') > -1){ u+="&rd=";}

    else{u+="?rd=";}
     	
    u += Math.round(Math.random()*10000)*Math.round(Math.random()*10000) ;

    if(u.indexOf("http://")> -1)
    { 			
    	u = "Remote.aspx?url="+u.replace("http://","");
    }
   
			eA.open(st,u,asy); 
			eA.setRequestHeader("content-length",s.length); 
			eA.setRequestHeader("content-type","application/x-www-form-urlencoded");
			
			eA.send(s);
			
        return eA ;
  }
  function AjaxReturnValue(_value)
{
    var returnValue = new Object();
    returnValue.value = _value;
    return returnValue;
}

var ajaxCreate = function(){
	
	var xmldoc = null;
	
    if(window.XMLHttpRequest){
        xmldoc = new XMLHttpRequest();
        if(xmldoc.overrideMimeType){
	
                xmldoc.overrideMimeType("text/xml");
        }

    }else if(window.ActiveXObject){
		try{
        	xmldoc = new ActiveXObject("Msxml5.XMLHTTP");
        	}catch(e){
        	try{
            	xmldoc = new ActiveXObject("Msxml4.XMLHTTP");
        	}catch(e){
            	try{
                	xmldoc = new ActiveXObject("Msxml3.XMLHTTP");
            	}catch(e){
                	try{
                    	xmldoc = new ActiveXObject("Msxml2.XMLHTTP");
                	}catch(e){
                    	try{
                        	xmldoc = new ActiveXObject("Microsoft.XMLHTTP");
                    	}catch(e){}
                	}
            	}
        	}
    	}
	}
	return xmldoc || false;
}
