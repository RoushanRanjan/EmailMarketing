<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/UI/ServiceOwner/Service_Owner_Header.jsp" %> 
<html>
<head>

<script src="<%=application.getContextPath()%>/JS/jquery-1.8.2.js"></script>
<script>

	function validateForm() {
		
	    var x = document.forms["myForm"]["serviceName"].value;
	    if (x == "") {
	        alert("ServiceName must be filled out");
	        return false;
	    }
	  
		var y = document.getElementById("xfile").required;
	
		/* var y = document.forms["myForm"]["xfile"].value;
	    if (y == "") {
	        alert("Excel File must be required");
	        return false;
	    }
		 */
	}
	/* 
	function checkfile(sender) {
		  var x = document.forms["myForm"]["usr_file"].value;
	    var validExts = new Array(".xlsx", ".xls");
	    var fileExt = sender.value;
	    fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
	    if (validExts.indexOf(fileExt) < 0) {
	      alert("Invalid file selected, valid files are of " +
	               validExts.toString() + " types.");
	      return false;
	    }
	    else return true;
	}
	
	 */
	function service() {
		  var x = document.forms["myForm1"]["serviceName"].value;
		    if (x == "") {
		        alert("ServiceName must be choosen.!!!");
		        return false;
		    }
		    
	}
	
	var f="Service name";
	var g="Email";
	var a=" ";
	var val=" ";
	$(document).ready(function(){
	
	    $(".t").click(function(){
	        $("#s").hide();
	        $("#s").html("");
	        
	        
	        
	        $("#s").show();
	        
	        $('#s').append('<div style="text-align: center; border: 1px; background-color:#222222 ; width: 40%; height: 230px; padding-top: 30px; margin-left: 30%; margin-top: 5px;border-radius: 10px;">'
	        		+'<span style="color:white;"><b>'+f+'</b></span><span style="color:red">*</span><span style="color:white;"> : </span>'
	        		+'<select name="serviceName" id="serviceName" onchange="service()" required ><option>'+a+'</option></select>'
	        		/* +'<select name= "serviceName" id="servicename"></select>' */
	        		+'<br><br>'
	        		+'<input type = "hidden" name="sid" value="'+val+'" required >'
	        		+'<span style="color:white;"><b>'+g+'</b></span><span style="color:red">*</span><span style="color:white;"> : </span>'
	        		+'<input type = "email" name="email" id="email" required>'
	        		+'<h2 id="#result"></h2>'
	        		+'<input type = "submit" name="sub" id="validate" value="Add Email">'
	        		
	        		+'</div');
	       
	        return false;
         
	    });
	
	    
	
	    $.get("<%=request.getContextPath() %>/MailDropDownAction",function(data) {
			
			$.each(data, function(key,value) {
				a=a+"<option value="+value+">"+key+"</option>"
				val=value;
				/* alert(val)
				alert(key+"...."); */
			});
			
			
			/*  
			$("#servicename").change( function() {
				
				var $id=$("#servicename").val();			
				$.getJSON("service?id="+$id ,function(data){
					
					var b=" ";
					$.each(data,function(key,value){
						
						b=b+"<option value="+value+">"+key+"</option>"
					});
				});			
				});  */
			 
		});
	    function validateEmail(email) {
	    	
	    	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	    	  return re.test(email);
	    	}

	    	function validate() {
	    	  $("#result").text("");
	    	  var email = $("#email").val();
	    	  if (validateEmail(email)) {
	    	    $("#result").text(email + " is valid :)");
	    	    $("#result").css("color", "green");
	    	  } else {
	    	    $("#result").text(email + " is not valid :(");
	    	    $("#result").css("color", "red");
	    	  }
	    	  return false;
	    	}

	    	$("#validate").bind("click", validate);
	});

</script>

<script type="text/javascript" language="javascript">
function checkfile(sender) {
    var validExts = new Array(".xlsx", ".xls");
    var fileExt = sender.value;
    fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
    
    
    if (validExts.indexOf(fileExt) < 0) {
      alert("Invalid file selected, valid files are of " +
               validExts.toString() + " types.");
      return false;
    }
    else return true;
}
</script>

<style>
body{
	background-image:
		url("<%=application.getContextPath()%>/IMAGES/images.jpg");
	background-repeat: no-repeat;
	background-attatchment: fixed;
	background-position: centre;
	background-size: 100%;
}



input[type=text], select {
    width: 30%;
    padding: 7px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
	
}
input[type=email], select {
    width: 50%;
    padding: 7px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
	
}

input[type=submit] {
    
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
    
}


input[type=file] {
    
    background-color: #4CAF50;
    color: white;
    width: 60%;
    margin-left: 20%;
    padding: 14px 20px;
    
    border: none;
    border-radius: 4px;
    cursor: pointer;
    text-align: center; 
    
}

input[type=file]:hover {
    background-color: #45a049;
}
button {
   
    background-color: silver;
    padding: 14px 20px;
    margin: 8px 0;
    border: thick;
    border-radius: 4px;
    border-color:#4CAF50;
    cursor: pointer;
}
button:HOVER {
    background-color: #45a049;
    color: white;
}

select {
	width: 40%;
	color: black;
    
    
}

</style>

</head>

<body>
<form name="myForm" action=" <%=request.getContextPath() %>/MailListAction" method="post" enctype="multipart/form-data" onsubmit="return validateForm()"  >

	<div style="text-align: center; border: 10px; background-color:#222222; width:40%; height: 450px; padding-top: 30px; margin-left: 30%; border-radius: 10px;">
		<h4 style="color: yellow;">
		<%	if(request.getQueryString()!=null){out.println(request.getQueryString());} %>
		</h4>
		
		<h2><span style="color:white;">Add Mails..</span></h2>
   		<span style="color:white;"><b>Service name</b></span><span style="color:red">*</span><span style="color:white;"> : </span><input type="text" name="serviceName" onchange="validateForm()" required  /><br /><br />
	  <input style="text-align: center;" type="file"  name="xfile" id="xfile"  onchange="checkfile(this);"  required accept=".xls,.xlsx"><br />
      <input type="submit" name="sub" value="Add" /><br /><br /><br>
      <button  class="t">Add Individual</button>
	</div> 
   
        
</form>


<form name="myForm1" action="<%=request.getContextPath() %>/MailListAction" method="post" onsubmit="return service()"  >

   
  <p id = "s"> </p>
      
</form>
<br><br><br>
	<%@include file="/UI/common/Footer.jsp" %>
</body>
</html>