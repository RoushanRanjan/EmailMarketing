<%-- <%@include file="/UI/common/WelcomePage_Header.jsp" %>
 --%><!DOCTYPE html>
<html lang="en">

<head>
<%@include file="/UI/common/Header.jsp"%>
<meta charset="utf-8">

<!-- Google Fonts -->
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"  href="/Emailmarketing/CSS/animate.css">
<!-- Custom Stylesheet -->
<link rel="stylesheet" href="/Emailmarketing/CSS/style.css">

<script src="/Emailmarketing/JS/jquery-1.12.3.js"></script>	
</head>
<form action="Emailmarketing/loginactionurl" method="post" onsubmit=" return validate(this)">
	<div class="container">
		<div class="top"></div>
		<div class="login-box animated fadeInUp">
			<div class="box-header">
				<h2>Log In</h2>
			</div>
			 <span style="color:red" id="sid"></span><br>
			<label for="username">Username</label><br> 
			<input type="text" name="username" id="uname"><br>
			 <label for="password">Password</label><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<input type="password" name="password" id="pwd">&nbsp;<a href="/Emailmarketing/UI/authentication/ForgotPassword.jsp" class="small"><b>Forgot?</b></a><br> 
			 <input type="hidden" name="flag" value="no">
			<button type="submit" id="bt">Login</button><br><br>
			 <input type="checkbox" name="stay" id="ck" checked>Stay signed in<br>
		</div>
	</div>
</form>		
<script>
function validate(frm) {
		frm.flag.value = "yes";
		$(document).ready(function() {
			$('#logo').addClass('animated fadeInDown');
			$("input:text:visible:first").focus();
			$('#uname').append("hhm");
		});
		$('#username').focus(function() {
			$('label[for="username"]').addClass('selected');
		});
		$('#username').blur(function() {
			$('label[for="username"]').removeClass('selected');
		});
		$('#password').focus(function() {
			$('label[for="password"]').addClass('selected');
		});
		$('#password').blur(function() {
			$('label[for="password"]').removeClass('selected');
		});
}//validate(-)
		
		$(document).ready(function(){
	    $("button").click(function(){
		 var username=$("#uname").val();
		 var password=$("#pwd").val();
		 var check=$("#ck").val();
		 if($('#ck').is(":checked")){
			 check=true;
		 }else{
			 check=false;
		 }//else
		 if(username!="" && password!=""){
			 $.ajax({
			 type:"post",
			 data:{
				 username : username,
				 password : password,
				 stay 	  :check
				 },
			 url:"<%=request.getContextPath()%>/loginactionurl",
			 success: function(result){
				 if(result.err!=undefined){
				 $("#sid").html(result.err);
				 }else if(result!=undefined){
				  window.location.assign("<%=application.getContextPath()%>/"+result.url);
				 }//else if
			 }//function
		 });//ajax
		 }//if
		 else{
		  $("#sid").html("please enter username and password");
		 }//else
	 return false;
	 });//click
}); //ready
</script>
</html>