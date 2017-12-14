<!DOCTYPE html>

<html lang="en">
<head>
<%-- <%@include file="Service_Owner_Header.jsp"%> --%>
 <%@page import="java.util.Calendar"%>
 <%@include file="/UI/common/Header.jsp" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>SERVICE-OWNER-REGISTRATION-PAGE</title>

<meta name="description" content="Service Owner Registration page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & font awesome -->

<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assests/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assests/font-awesome/4.2.0/css/font-awesome.min.css" />

<!-- text fonts -->
<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assests/fonts/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assests/css/ace.min.css" />


<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assests/css/ace-rtl.min.css" />

<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assests/css/jquery-ui.min.css"/>
<link rel="stylesheet"
	href="<%=application.getContextPath() %>/assests/css/jquery.validate.min.js"/>

<link rel="stylesheet" href="<%=application.getContextPath() %>/assets/css/formValidation.css">
<script type="text/javascript">
var countryId=0;
var stateId=0;
var cityId=0;

</script>
<style type="text/css">

body { 
    background-image: url("<%=application.getContextPath()%>/IMAGES/UI_Images/EM.jpg");
   background-repeat:no-repeat;
    background-attachment: fixed;
    background-position: center;
     background-size: 100%; 
}	 
</style>
</head>

<body class="login-layout" style="width: 100%">
	<!-- alignment adjusting -->
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h2>
							<!-- 	<i class="ace-icon fa fa-leaf green"></i>  -->
								<span class="blue">Service Owner Registration</span>
							</h2>
						</div>

						<div class="space-6"></div>

						<div class="position-relative" style="width: 130%">
							<!-- size adjusting -->
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i> Please Enter Your
											Personal Details
										</h4>
										<div class="hero-unit">
											<div class="space-6"></div>
											<form  id='reg-form'
												name="form" method="get"
												action="<%=application.getContextPath() %>/ServiceOwnerRegister"
												 enctype="multipart/form-data">
												
													<fieldset>
													<input type="hidden" name="identity" value="1">
													<div class="form-group">
															<label class="block clearfix"> <span
																class="block input-icon input-icon-right"><b>FirstName:<span style="color:red;">*</span><span id="fname-msg"></span></b><input
																	type="text" class="form-control"
																	placeholder="EX-Supriya" name="fname" id="fname"/> <i
																	class="ace-icon fa fa-user"></i>
															</span>
															
															</label>
														</div>
													<div class="form-group">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <b>LastName:<span style="color:red;">*</span><span id="lname-msg"></b><input
																type="text" class="form-control" placeholder="EX-Raut"
																name="lname" id="lname"/> <i class="ace-icon fa fa-user"></i>
														</span>
							
														</label> 
														</div>
														<span style="color: red;" id="lerrors"> </span> 
														
 														<%-- <%
														String emailStatus=request.getParameter("emailStatus");
														String msg=request.getParameter("msg");
														if(emailStatus!=null && msg!=null)
														{
														%>
														<%="<b style='color:red;'>"+emailStatus+"</b>"%>
														<br>
														
														<%="<b style='color:red;'>"+msg+"</b>" %>
														<%
														}
														%> --%>
														<div class="form-group">
														<label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"> <b>Email-Id:<span style="color:red;">*</span><span id="email-msg"></span></b><input
																type="email" class="form-control" placeholder="EX-priya2811@gmail.com"
												required="required"		name="email" id="email"/> <i class="ace-icon fa fa-envelope"></i>
														</span>
														</label> 
														</div>
														<div class="form-group">
														<span style="color: red;" id="emailerrors"></span> <label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"><b>Password:<span style="color:red;">*</span><span id="password-msg"></span></b> <input
																type="password" class="form-control" required="required"
																placeholder="EX-12abc45" name="pwd" id="pwd"/> <i
																class="ace-icon fa fa-lock"></i>
														</span>
														</label> 
														</div>
														<div class="form-group">
														<span style="color: red;" id="perrors"></span> <label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"><b>Re-type Password:<span style="color:red;">*</span><span id="repassword-msg"></span></b> <input
																type="password" class="form-control" required="required"
																placeholder="EX-12abc45" name="repwd" /> <i
																class="ace-icon fa fa-lock"></i>
														</span>
														</label>
														</div>
														<div class="form-group">
														<span style="color: red;" id="rerrors"> </span> <label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"><b>Mobile No:<span style="color:red;">*</span><span id="mobile-msg"></span></b> 
															<input
																type="text" class="form-control"
																placeholder="EX-8625863558" name="mobileno"required="required"
																id="mobileno" /> <i class="ace-icon fa fa-phone"></i>
														</span>
														</label> 
														</div>
														<span style="color: red;" id="moberrors"> </span>
														<div class="form-group">
														 <label
															class="block clearfix"> <span
															class="block input-icon input-icon-right"> <b>Date of birth:<span style="color:red;">*</span></b><input
																class='form-control' type='text' id='datepicker' placeholder="28/11/1994" required="required"
																name="dob"> <i class="ace-icon fa fa-calender"></i>
														</span>
														</label>
														
														</div>
														<div class="form-group">
														 <label class="block clearfix" >  <b>Gender:<span style="color:red;">*</span></b>
															<b>Male</b><input
																type="radio" name='gender' value='1' checked="checked">
																<b>Female</b><input type="radio" name='gender'  value='0' required="required">
														
														</label> 
														
														</div>
																												<div class="form-group">
														<label class="block clearfix" style='color: blue'>
															<span class="block input-icon input-icon-right"><b>Enter
																Your Address Details: </b></span>
														</label>
														</div>
														<div class="form-group">
														 <label class="block clearfix"> <span
															class="block input-icon input-icon-right">
																<b>Country:<span style="color:red;">*</span></b><select name="country" id="country"
															class='form-control'	required="required">
                                                              
															</select>
														</span>
														</label> 
														</div>
														<div class="form-group">
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right">
																<b>State:<span style="color:red;">*</span></b><select name="state" id="state"
															class='form-control'	required="required">
                                                             
															</select>
														</span>
														</label>
														</div>
														<div class="form-group">
                                                           <label class="block clearfix"> <span
															class="block input-icon input-icon-right"> <b>City:<span style="color:red;">*</span></b><select
															class='form-control'	name="city" id="city" required="required">
                                                                     
											                  </select>
														</span>
														</label>

														</div>			
														<div class="form-group">											
														<label class="block clearfix"> <span
															class="block input-icon input-icon-right"><b>Location:<span style="color:red;">*</span></b><input type="text"
														class='form-control'	placeholder="EX-Ameerpet" name="location"
															required="required"> 
														</span>
														</label>
														</div>
														
													</fieldset>
												

												<div class="space"></div>

												<div class="clearfix">
													<div>
														
															<button type="submit" class="width-25 pull-right btn btn-sm btn-primary">
															<span id="submit">REGISTER</span>

															<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
														</button>
													</div>

													<button type="reset"
														class="width-25 pull-left btn btn-sm btn-primary">
														<i class="ace-icon fa fa-refresh"></i> <span
															>RESET</span>
													</button>
												</div>
												
											</form>

										</div>
									</div>
									<!-- .widget-main -->

								</div>
								<!-- .widget-body -->
							</div>
							<!-- login-box -->

						</div>
						<!-- /.position-relative -->


					

					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.main-content -->
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<script
		src="<%=application.getContextPath() %>/assests/js/jquery.2.1.1.min.js"></script>
	<script type="text/javascript"
		src="<%=application.getContextPath() %>/assests/js/jquery.validate.min.js"></script>

	
	<script type="text/javascript">
			
		window.jQuery || document
							.write("<script src ='<%=application.getContextPath() %>/assests/js/jquery.min.js'>"
									+ "<"+"/script>");
		</script>

	<script type="text/javascript">
			if ('ontouchstart' in document.documentElement)
				document
						.write("<script src='<%=application.getContextPath() %>/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script
		src="<%=application.getContextPath()%>/assests/js/jquery-ui.min.js"></script>
	<!-- inline scripts related to this page -->
	
    <script type="text/javascript" src="<%=application.getContextPath() %>/assests/js/formValidation.js"></script>
    
    <script type="text/javascript" src="<%=application.getContextPath() %>/assests/js/framework/bootstrap.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			$(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			});
		});

		//you don't need this, just used for changing background
	/* 	jQuery(function($) {
			$('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'cyan');
				$('#id-company-text').attr('class', 'cyan');

				e.preventDefault();
			});

		});
 */
		/** Date Picker*/
<%
Calendar cal=Calendar.getInstance();
	int year=cal.get(Calendar.YEAR);
	request.setAttribute("year", year);
%>
var year='<%=year%>'; 
var minYear=year-19;

		$(function() {
			$("#datepicker").datepicker({
				changeMonth: true,
	            changeYear: true,
	            showButtonPanel: true,
	            yearRange: '1980:'+minYear,
	            onSelect: function () {
	                $('#datepicker').text(this.value);
	            } 
	        });
			
		});
 	
		
		
		$(document).ready(function(){
			
			$("#country").append("<option>select</option>");
			$.getJSON("<%=request.getContextPath()%>/CountryAction",function(data) {

				var a=" ";
				$.each(data, function(key,value) {
					a=a+"<option value="+value+">"+key+"</option>";
				});
				$("#country").append(a);
			});
			
		$("#country").change(function(){
			$("#state").empty();
		var	$b=$("#country").val();
		var $g="";
		$("#state").append("<option>select</option>");
		
		
		
			$.getJSON("<%=request.getContextPath()%>/StateAction?name="+$b,function(data){
				$.each(data, function(key,value) {
					$g=$g+"<option value="+value+">"+key+"</option>";
				});
				$("#state").append($g);
			});
			
		});
		$("#state").change(function(){
			$("#city").empty();
			var $k=$("#state").val();
	var	$c=" ";
	$("#city").append("<option>select</option>");
			//$.getJSON("CityAction?cname="+$k,function(data) {
				$.getJSON("<%=request.getContextPath()%>/CityAction?cname="+$k,function(data){
				$.each(data, function(key,value) {
					$c=$c+"<option value="+value+">"+key+"</option>";
				});
				$("#city").append($c);
			});
		});
		});

	 $('#reg-form')
			.formValidation({
			    message: 'This value is not valid',
			    icon: {
			        valid: 'glyphicon glyphicon-ok',
			        invalid: 'glyphicon glyphicon-remove',
			        validating: 'glyphicon glyphicon-refresh'
			    },
			    fields: {
					fname: {
			            message: 'The username is not valid',
			            validators: {
			                notEmpty: {
			                    message: 'The First Name is required and can\'t be empty'
			                },
			                stringLength: {
			                    min: 2,
			                    max: 30,
			                    message: 'The First Name must be more than 2 and less than 30 characters long'
			                },
			                /*remote: {
			                    url: 'remote.php',
			                    message: 'The username is not available'
			                },*/
			                regexp: {
			                    regexp: /^[a-zA-Z]+$/,
			                    message: 'The First Name can only consist of alphabetical'
			                }
			            }
			        },
			        lname: {
			            message: 'The username is not valid',
			            validators: {
			                notEmpty: {
			                    message: 'The Last Name Name is required and can\'t be empty'
			                },
			                stringLength: {
			                    min: 2,
			                    max: 30,
			                    message: 'The Last Name must be more than 2 and less than 30 characters long'
			                },
			                /*remote: {
			                    url: 'remote.php',
			                    message: 'The username is not available'
			                },*/
			                regexp: {
			                    regexp: /^[a-zA-Z]+$/,
			                    message: 'The Last Name can only consist of alphabetical'
			                }
			            }
			        },
			        email: {
			            validators: {
			                notEmpty: {
			                    message: 'The email address is required and can\'t be empty'
			                },  regexp: {
			                    regexp: /^[a-zA-Z0-9][a-zA-Z0-9._]{3,}[@]{1}[a-zA-Z0-9]{2,}[.]{1}[a-zA-Z0-9]{2,}([.]{1}[a-zA-Z0-9]{2,}){0,}$/,
			                    message: 'EMAIL FORMAT IS INVALID'
			                }
			                /* ,
			                emailAddress: {
			                    message: 'The input is not a valid email address'
			                } */
			            }
			        },
			        pwd: {
			            validators: {
			                notEmpty: {
			                    message: 'The password is required and can\'t be empty'
			                },
			                stringLength: {
			                    min: 8,
			                    max: 30,
			                    message: 'The Last Name must be more than 7 and less than 30 characters long'
			                }
			            }
			          
			        },
			        repwd:{
				    	   validators: {
				    		   identical: {
				                    field: 'pwd',
				                    message: 'The password and its confirm are not the same'
				                },stringLength: {
				                    min: 8,
				                    max: 30,
				                    message: 'The Last Name must be more than 2 and less than 30 characters long'
				                }
		                    }
	               
			        },
                    mobileno:{
                    	 validators: {
                             phone: {
                                 country: 'IN',
                                 message: 'The value is not valid %s phone number'
                             },
			                regexp: {
			                    regexp:/^[7-9][0-9]{9}$/,
			                    message: 'The MOBILE NO SHOULD START WIT 7 OR 8 OR 9'
			                },stringLength: {
			                    min: 10,
			                    max: 10,
			                    message: 'PLEASE ENTER 10 DIGITS MOBILE NO'
			                }
                         }
                    },
                    pin: {
                        validators: {
                            regexp: {
                                regexp: /^\d{6}$/,
                                message: 'The IN zipcode must contain 6 digits'
                            }
                        }
                    }
			       
			    }
			});

</script>		
<%@include file="/UI/common/Footer.jsp" %>	
</body>
</html>

			