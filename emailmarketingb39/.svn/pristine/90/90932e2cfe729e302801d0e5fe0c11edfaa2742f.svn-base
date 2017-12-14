<%@ page import="java.io.*,java.util.*"%>

<%
	int roleid = 1;
	HttpSession session1 = request.getSession(false);
	roleid=(int)session.getAttribute("roleid");
	if (roleid == 1) {
%>
<%@include file="/UI/Admin/Admin_Header.jsp"%>
<%
	}

	else if (roleid == 3) {
%>
<%@include file="/UI/ProductOwner/Product_Owner_Header.jsp"%>
<%
	}

	else if (roleid == 2) {
%>
<%@include file="/UI/ServiceOwner/Service_Owner_Header.jsp"%>
<%
	}

	else {
%>
<%@include file="/UI/User/User_Header.jsp"%>
<%
	}
%>
<html>
<head>
<style type="text/css">
body {
	 background-image:
	url("<%=application.getContextPath()%>/IMAGES/images.jpg");
	background-repeat: no-repeat;
	background-attatchment: fixed;
	background-position: centre;
	background-size: 100%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assests/bootstrap/css/bootstrap.min.css">
  <script src="<%=application.getContextPath()%>/JS/jquery-1.12.3.js"></script>
  <script src="<%=application.getContextPath()%>/assests/bootstrap/js/bootstrap.min.js"></script>

<title>Email Marketing</title>
</head>


<script type="text/javascript"
	src="<%=application.getContextPath()%>/JS/jquery-1.12.3.js"></script>


<script type="text/javascript">

	$(document).ready(function(){
         $("#btnSubmit").click(function () { 
        	 
        	/*  var prePassword = $("#prePassword").val(); */
             var prePassword = $("#prePassword").val();
        	
             if (prePassword==null || prePassword==""){  
            	
            	 $('.loginError').show();
             	  return false; 
             }
             $('.loginError').hide();

            var txtPassword = $("#txtPassword").val();
            var confirmPassword = $("#txtConfirmPassword").val(); 
             if (txtPassword==null || txtPassword==""){ 
            	   $('.loginError1').show();
            	  //$( txtPassword).parent().after("<div class='validation' style='color:red;margin-bottom: 20px;'>Please enter email address</div>");
            	  return false; 
            }$('.loginError1').hide();

            var txtConfirmPassword = $("#txtConfirmPassword").val();
            var txtConfirmPassword = $("#txtConfirmPassword").val();
            if (txtConfirmPassword==null || txtConfirmPassword==""){  
            	// $( txtConfirmPassword).after("<div class='validation' style='color:red;margin-bottom: 20px;'>Please enter email address</div>");
            	   $('.loginError2').show();
            	
            	  return false; 
            }$('.loginError2').hide();
             
            
       	if(txtPassword.length>3&&txtPassword.length<8)
        		{ 
        		

         if (txtPassword!= confirmPassword) {
                      /* alert("Passwords do not match."); */
                        $('.loginError3').show();
            	
                      return false;
        		}
         else if(!txtPassword.equals(confirmPassword)){
        		 return false;
        	 }
         else
        	 
         return true;
         }
        		
        		
        		
       	else{
       		/* alert("enter min 4 chars");
       	          */
       	       $('.loginError4').show();
                   
            return false;}
        $('.loginError4').hide();
      /*   $('.loginError5').show(); */
     	return true;
     	 
       });
    });
        $(document).ready(function(){
        $("#prePassword").blur(function(){
        
        var prePassword=$("#prePassword").val();
        $.ajax({
        	 "url":"<%=application.getContextPath()%>/ChangePassword",

				"data" : {
					"prepassword" : prePassword
				},
				"success" : function(data) {
					if ("SUCCESS" == data) {
						$("#prePassword").css("border", "5px solid green");
						$("#prePassword").css("color:green");
					} else {
						$("#prePassword").css("border", "5px solid red");
						$("#prePassword").css("color:red");
					}

				}

			});

		});
	});
</script>
<style>
/* form {
     border: 1px solid #f1f1f1; 
}
 */
/* input[type=text], input[type=password] ,input[type=prepassword]{
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
 */
     /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
/*     .btn {background-color: #00877a;}
 */    
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #31698a;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
    
    /* For Form Page */
    input[type=text], select, textarea {
    width: 100%;
    height: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
	}

	input[type=submit] {
    background-color: #31698a;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
	}

	input[type=submit]:hover {
    background-color: #45a049;
	}

	 .container {
/* 	max-width: 800px;
 */    border-radius: 5px;
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 40px;
    padding-right: 50px;
	} 
	
	/* for Browse Button */
     .btn-file {
     background-color: #31698a;
     color: white;
    position: relative;
    overflow: hidden;
}
.btn-file input[type=file] {
    position: absolute;
    top: 0;
    right: 0;
    min-width: 100%;
    min-height: 100%;
    font-size: 100px;
    text-align: right;.
    filter: alpha(opacity=0);
    opacity: 0;
    outline: none;
    background: white;
    cursor: inherit;
     display: block;
}
</style>

<body>

		<br><br>

	<div class="col-sm-6 text-left col-sm-offset-3">
	 <div class="panel panel-info">
      <div class="panel-heading text-center"><b>Change Password<b></div>
	   
    	<div class="row"> 	    
        <div class="col-sm-12">
          <div class="panel-body text-center">

	<b><center><h3 style="color:red">CHANGE PASSWORD</h3></center></b>


	<form action="<%=request.getContextPath()%>/ChangePassword" method="post" id="formCheckPassword" onsubmit="return validateform()">
			
							
							<label class="col-lg-4 control-label" style="color: black;"><b>Old Password</b></label>
							<div class="col-lg-8"> 
							<input type="prepassword" placeholder="Enter prepassword" class="form-control" name="prepassword" id="prePassword" required><br>
							</div>
						
						<label class="col-lg-4 control-label" style="color: black;"><b>New Password</b></label> 
						<div class="col-lg-8">
						<input type="password" placeholder="Enter Newpassword" class="form-control" name="newpassword" id="txtPassword" required><br>
						</div>
						
							<label class="col-lg-4 control-label" style="color: black;"><b>Confirm Password</b></label> 
							<div class="col-lg-8">
							<input type="password" placeholder="Enter ConfirmPassword" class="form-control" name="confirmpassward" id="txtConfirmPassword" required><br>
							</div>
						


							<div class="col-sm-12 col-sm-offset-2">
								<button type="submit" class="btn btn-primary col-sm-1" id="btnSubmit" style="width:60%">Submit</button>
							</div>
						<div class="container" style="background-color: #f1f1f1;width:30%">
						<!-- 	&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; -->
<!-- 							<button type="submit" id="btnSubmit" style="width:30%">Submit</button> -->
						
							</div>
							</div>

<div class="col-lg-12 text-center">
		<p class="loginError" style="display: none; color: red">please
			enter your pre password</p>
		<p class="loginError1" style="display: none; color: red">please
			enter your new password</p>
		<p class="loginError2" style="display: none; color: red">please
			enter your confirm password</p>
		<p class="loginError3" style="display: none; color: red">password
			do not match</p>
		<p class="loginError4" style="display: none; color: red">enter
			minimum 4 charecters</p>

		<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
 -->
		
		<div style="color: green">
			<font>${requestScope.message}</font>
		</div>
	</div>
	</form>
	</div></div></div></div></div>
<!-- 	<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br>
 -->	
		
	
	<!-- <footer class="container-fluid text-center">
  <p><b>&copy; Copyright 2017 All Rights Reserved www.nacresoftwareservices.com</b></p>
</footer>
 -->
 </body>
</html>
