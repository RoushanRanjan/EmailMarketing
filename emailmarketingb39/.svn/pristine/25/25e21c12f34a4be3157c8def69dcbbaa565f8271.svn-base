<!-- Author: Satyajeet and Amit -->
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Email Marketing</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assests/bootstrap/css/bootstrap.min.css">
  <script src="<%=application.getContextPath()%>/JS/jquery-1.12.3.js"></script>
  <script src="<%=application.getContextPath()%>/assests/bootstrap/js/bootstrap.min.js"></script>
<%--     <script src="<%=application.getContextPath()/JS/addProductForm.js"></script>
   <script src="<%=application.getContextPath()%>/JS/showServiceForProductOwner.js"></script>
 --%>
    <script>
  	/* Uploading Image File */
	/*  function readURL(input) {
  	  if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah')
                .attr('src', e.target.result)
                .width(120)
                .height(120);
        };
        reader.readAsDataURL(input.files[0]);
    }
}   
 */

	$(document).ready(function(){
	/*For image upload*/
		var $imageValid=0;
		$("#imageUpload").change(
				function() {
					$imageValid=0;
					//$("#dvPreview").html("");
					var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.jpg|.jpeg|.gif|.png|.bmp)$/;
					if (regex.test($(this).val().toLowerCase())) {
						/* if ($.browser.msie
								&& parseFloat(jQuery.browser.version) <= 9.0) {
					//		$("#dvPreview").show();
							//   $("#dvPreview")[0].filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = $(this).val();
						} else { */
							if (typeof (FileReader) != "undefined") {
								/* $("#dvPreview").show();
								$("#dvPreview")
										.append(
												"<img style='width: 200px; height: 200px;'/>"); */
								var reader = new FileReader();
								reader.onload = function(e) {
									 $('#blah')
						                .attr('src', e.target.result)
						                .width(120)
						                .height(120);
								}
								reader.readAsDataURL($(this)[0].files[0]);
							} else {
								$imageValid=1;
							   	$('#blah').attr('src', "<%=application.getContextPath()%>/IMAGES/new_product_default.png");

							}
						//}
					} else {
						$imageValid=1;
					   	$('#blah').attr('src', "<%=application.getContextPath()%>/IMAGES/new_product_default.png");

					}
				});
		/*For image upload end*/
		var $url=$("#url").val();
		var $fir=0;
		var $sec=0;
		var $thi=0;
		$.getJSON($url,function(data) {
			var a="<option value='0'>Select Service..</option>";
			$.each(data, function(key,value) {
				a=a+"<option value="+value+">"+key+"</option>"
			});
			$("#first").html(a);
			$("#second").html(a);
			$("#third").html(a);
		});
		
		
		    $('#first').change(function() {
		    	$('#second option[value=' + $fir + ']').show();
		        $('#third option[value=' + $fir + ']').show();
		    	$fir=$(this).val();
		    //	alert($fir);
		    	if($(this).val()!=0){
		        $('#second option[value=' + $(this).val() + ']').hide();
		        $('#third option[value=' + $(this).val() + ']').hide();
		    	}
		    });
		    
		    $('#second').change(function() {
		    	$('#first option[value=' + $sec + ']').show();
		        $('#third option[value=' + $sec + ']').show();
		    	$sec=$(this).val();
		    //	alert($sec);
		    	if($(this).val()!=0){
		        $('#first option[value=' + $(this).val() + ']').hide();
		        $('#third option[value=' + $(this).val() + ']').hide();
		    	}
		    });
		    $('#third').change(function() {
		    	$('#second option[value=' + $thi + ']').show();
		        $('#first option[value=' + $thi + ']').show();
		    	$thi=$(this).val();
		    //	alert($thi);
		    	if($(this).val()!=0){
		        $('#second option[value=' + $(this).val() + ']').hide();
		        $('#first option[value=' + $(this).val() + ']').hide();
		    	}
		    });
	/* });	    


	$(document).ready(function() { */
		
		$("#success").hide();
		$("#error").hide();
		$("#success1").hide();
		$("#error1").hide();
		$("#loader").hide();

		var $1st=0;
		var $2nd=0;
		var $3rd=0;
		
		
		$("#submit").click(function(){
			$("#success").hide();
			$("#error").hide();
			$("#success1").hide();
			$("#error1").hide();
			$("#validation").text("");
			$1st=$("#first").val();
			$2nd=$("#second").val();
			$3rd=$("#third").val();
			
			var regPName = new RegExp("^[a-zA-Z]{3}[a-zA-Z0-9]+$");
			var regPrice = new RegExp("^[0-9]+$");
			var regPType = new RegExp("^[a-zA-Z]{3}[a-zA-Z]+$");
			if($("#pName").val()==""){
				$("#validation").text("Name is required");
			}else if(!(regPName.test($("#pName").val()))){
				$("#validation").text("Product name must be more than three chartchter (first three chachater is alphabate)");
			}else if($("#price").val()==""){
				$("#validation").text("Price is required");
			}else if(!(regPrice.test($("#price").val()))){
				$("#validation").text("Price must be digit");
			}else if($("#price").val()<50){
				$("#validation").text("Price must be greater than 50 rupees");
			}else if($("#quantity").val()==""){
				$("#validation").text("Quantity is required");
			}else if(!(regPrice.test($("#quantity").val()))){
				$("#validation").text("Quantity must be digit");
			}else if($("#quantity").val()<1){
				$("#validation").text("Quantity must be greater than one");
			}else if($("#pType").val()==""){
				$("#validation").text("Product Type is required");
			}else if(!(regPType.test($("#pType").val()))){
				$("#validation").text("Product type must be more than three charchater");
			}else if($("#imageUpload").val()==""){
				$("#validation").text("Product image is required");
			}else if($imageValid==1){
				$("#validation").text("Please upload a valid image file");
			}else{
				if($1st=="0" && $2nd=="0" && $3rd=="0"){
					$('#myModal2').modal('show');
				
				}else{
					$('#myModal1').modal('show');
				}
			}
		}); 
		$("#m1n").click(function(){
			$1st=0;
			$2nd=0;
			$3rd=0;
		});
		
		$("#m1y").click(function(){
/* 			$(this).button('loading').delay(1000).queue(function() {
 */			addProduct();
			 /* $(this).button('reset');
	         $(this).dequeue(); 
	     });*/
		});
		$("#m2y").click(function(){
			addProduct();
			
		});
		/*Sliding Services*/
	    function close_accordion_section() {
	        $('.accordion .accordion-section-title').removeClass('active');
	        $('.accordion .accordion-section-content').slideUp(300).removeClass('open');
	        
	    }
	 
	    $('.accordion-section-title').click(function(e) {
	        // Grab current anchor value
	        var currentAttrValue = $(this).attr('href');
	 
	        if($(e.target).is('.active')) {
	            close_accordion_section();
	        }else {
	            close_accordion_section();
	 
	            // Add active class to section title
	            $(this).addClass('active');
	            // Open up the hidden content panel
	            $('.accordion ' + currentAttrValue).slideDown(300).addClass('open'); 
	        }
	        e.preventDefault();
	    });   
	    
	    
	    /*Azax for Asyncornous Communication for product adding*/
	    var $url1=$("#url1").val();
	    function addProduct(){ 
	    	$("#loader").show();
	    	//alert("hi");
	    //event.preventDefault();
		$("#loader").show();
		 var file_data = $("#imageUpload").prop("files")[0];   // Getting the properties of file from file field
			var form_data = new FormData();                  // Creating object of FormData class
			form_data.append("image", file_data)              // Appending parameter named file with properties of file_field to form_data
		 form_data.append("pName",$("#pName").val()) 
		// alert($("#txtProductName").val());
		 form_data.append("price", $("#price").val()) 
		// alert($("#txtProductModel").val());
		 form_data.append("quantity",$("#quantity").val()) 
		// alert($("#txtCategoryType").val());
		 form_data.append("pType", $("#pType").val()) 
		// alert($("#txtCategoryName").val());
		 form_data.append("first", $1st) 
		// alert($("#txtBrand").val());
		 form_data.append("second", $2nd) 
		// alert($("#txtPrice").val());
		 form_data.append("third", $3rd) 

		// alert(form_data);
			  $.ajax({
					
		    url: $url1,
		    type: 'POST',
		    data: form_data,
		    /* async: false,
		    cache: false,*/
		    contentType: false,
		    processData: false, 
		    success: function (returndata) {
		    	$("#loader").hide();

		    	$("#pName").val("");
		    	$("#price").val("");
		    	$("#pType").val("");
		    	$("#quantity").val("");
			   	$('#imageUpload').val("");
			   	$('#blah').attr('src', '<%=application.getContextPath()%>/IMAGES/new_product_default.png');
//		    	$("#myForm")[0].reset();
		      if(returndata==1){
		    	  $("#success").show();
		    	  
		    	 /*  $("#first").val().hide();
		    		    $('#first option').prop('selected', function() {
		    		        return this.defaultSelected;
		    		    }); */
		    	  
		      }else if(returndata==0){
		    	  $("#error").show();
		      }
		      else if(returndata==3){
		    	  $("#error1").show();
		      }
		      else if(returndata==4){
		    	  $("#success1").show();
		      }
		    }
		  });
		 
		  return false;
	}
	});
	function getContextPath() {
		   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	}
  </script>
  
  
  <style>
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
/* 
.dropbtn {
    background-color:#222222;
    color: #999999;
    padding: 16px;
    height:auto;
    border: none;
    cursor: pointer;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #222222;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);  
    z-index: 1;
}

.dropdown-content a {
    color: #999999;
   padding: 12px 16px; 
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #222222}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #222222;
}

/*For Drop down*/
 */  </style>
</head>
<body>
<%-- 
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header"><br>
      <div class="navbar-brand" ><img src="<%=application.getContextPath()%>/IMAGES/img1.jpg" height="80px" width="100px" ></div>
     <!--  <a class="navbar-brand" href="#">Email-Marketing</a> -->
    </div>
    <div class="collapse navbar-collapse" id="myNavbar"><br>
      <ul class="nav navbar-nav">
      <li><a href="<%=application.getContextPath()%>/showServiceOwnerDetailsForProductOwnerHomePage"><span class="glyphicon glyphicon-home"></span><b> Home</b></a></li>
        <li>
        	<div class="dropdown">
  				<button class="dropbtn"><span class="glyphicon glyphicon-shopping-cart"></span><b> Product</b></button>
  				<div class="dropdown-content">
  				  <a href="<%=application.getContextPath()%>/UI/ProductOwner/addProductFrom.jsp"><b>Add Product</b></a>
  				  <a href="<%=application.getContextPath()%>/viewProductForProductOwner?pageNo=1"><b>View Product</b></a>
 			 </div>
			</div>
        </li>
        <li><a href="#"><span class="glyphicon glyphicon-globe"></span><b> Notification</b></a></li>
        <li><a href="#"><span class="social social-myspace"></span><b>Track User</b></a></li>
     	<li>
     		<div class="dropdown">
  				<button class="dropbtn"><span class="glyphicon glyphicon-cog"></span><b> Settings</b></button>
  				<div class="dropdown-content">
  				  <a href="#"><b>Change Password</b></a>
   
 			 </div>
			</div>
     	</li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-out"></span><b> Logout </b></a></li>
      </ul>
    </div>
  </div>
</nav>
 --%>
 <%@include file="Product_Owner_Header.jsp"%>
 <div class="container text-center">
 
  <!-- Modal -->
  
  <div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header" style="background-color:#3b5998">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" style="color:white">Confirmation for mail</h4>
        </div>
        <div class="modal-body">
          <p>Are sure for sending mail?</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-success" data-dismiss="modal" data-toggle="modal" data-loading-text="Loading ..." id="m1y">Yes</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal" data-toggle="modal" data-target="#myModal2" id="m1n">No</button>
          
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content" >
        <div class="modal-header" style="background-color:#3b5998">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" style="color:white">Confirmation for product</h4>
        </div>
        <div class="modal-body">
          <p>Are sure for adding product?</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-success" data-dismiss="modal" id="m2y">Yes</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal" id="m2n">No</button>
          
        </div>
      </div>
    </div>
  </div>
			 	<!-- Adding Product Start-->
 <div class="container-fluid"> 
    
  <div class="row content">
	   <div id="loader"><img src="<%=application.getContextPath()%>/IMAGES/loader.gif"></div>
	
  <br>
	<div class="col-sm-8 text-left col-sm-offset-2">
	 <div class="panel panel-info">
      <div class="panel-heading text-center"><b>ADD PRODUCT<b></div>
	   
    	<div class="row"> 	    
        <div class="col-sm-12">
          <div class="panel-body">
          	<div class="alert alert-success alert-dismissable text-center" id='success'>
   		 		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
   		 		<strong>Success!</strong> Product added successfully.
 	    	</div>
 	    	<div class="alert alert-success alert-dismissable text-center" id='success1'>
   		 		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
   		 		<strong>Success!</strong> Product added successfully and also mail sent successfully
 	    	</div>
          	<div class="alert alert-danger alert-dismissable text-center" id='error'>
   				 <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
   				 <strong>Error!</strong> Internal Problem. Try Again.
  			</div>
  			<div class="alert alert-warning alert-dismissable text-center" id='error1'>
   				 <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
   				 <strong>Info!</strong> Product added successfully and mail didn't sent due to bad network
  			</div>	
  			
			<input type="hidden" id="url" value="<%=application.getContextPath()%>/showServicesForPorductOwnerAction"/>
			<input type="hidden" id="url1" value="<%=application.getContextPath()%>/insertProductAction"/>
			
			<form enctype='multipart/form-data' method="post" id="myForm">	
				<div class="col-lg-8">	
			     <label for="prName" class="col-lg-4 control-label">Product Name</label>
			     <div class="col-lg-8">
   				 <input type="text" id="pName" name="pName" class="form-control" placeholder="Product name..">	
				</div>					
    			 <label for="pr" class="col-lg-4 control-label">Price</label>
    			 <div class="col-lg-8">
   				 <input type="text" id="price" name="price" class="form-control" placeholder="Product Price..">
    			</div>
    			
    			
   				 <label for="quan" class="col-lg-4 control-label">Quantity</label>
   				 <div class="col-lg-8">
  				  <input type="text" id="quantity" name="quantity"  class="form-control" placeholder="Quantity..">
				</div>
				
					<label for="pt" class="col-lg-4 control-label">Product Type</label>
				<div class="col-lg-8">
  				  <input type="text" id="pType" name="pType" class="form-control" placeholder="Product Type..">
				</div>
				
				
				<!-- <div class="col-lg-12">
     				<input type="file" name="imageUpload" id="imageUpload" class="form-control-file" onchange="readURL(this)"/>
    			</div> -->
    			</div>
    			<div class="col-lg-4 text-center">
<!--     			<label for="pi" class="col-lg-4 control-label">Product Image</label>
 -->				<br><br><div class="col-lg-12"  align="center">
					<img id="blah" src="<%=application.getContextPath()%>/IMAGES/new_product_default.png"  alt="Image" height="120px" width="120px"/>
				</div>	
    			<div class="col-lg-12">
    			<span class="btn btn-default btn-file" >
   				 Browse Image<input type="file" name="imageUpload" id="imageUpload" class="form-control-file"> <!-- onchange="readURL(this)"/> -->
				</span>
				<br><br><br><br><br>
				</div>    			
    			</div>
    			
    			<!-- Sliding Content Start-->
   				<div class="accordion">
    			<div class="accordion-section" >
        		&nbsp;&nbsp;&nbsp;&nbsp;<a class="accordion-section-title"  href="#accordion-1"><img src="<%=application.getContextPath()%>/IMAGES/addService.gif">&nbsp;Services(Optional)</a> 
        		<div id="accordion-1" class="accordion-section-content" style="display:none">
        		<label for="opt1" class="col-lg-3 control-label">1st Service</label>
            	<div class="col-lg-9">
   				 <select id="first" name="first" class="form-control">
     				 <option value="">Enter Service..</option>
   				  </select>
   				  </div>
   				  <label for="opt2" class="col-lg-3 control-label">2st Service</label>
   				<div class="col-lg-9 ">
   			  <select id="second" name="second"  class="form-control">
   				 <option value="">Enter Service..</option>
   			  </select>
   			  </div>
   			  <label for="opt3" class="col-lg-3 control-label">3st Service</label>
   			  <div class="col-lg-9 ">
   			  
   			  <select id="third" name="third"  class="form-control">
   				 <option value="">Enter Service..</option>
   			  </select>
   			  </div>
        	</div><!--end .accordion-section-content-->
    			</div><!--end .accordion-section-->
				</div><!--end .accordion-->
				<!-- Sliding Content End-->
				 
    			
    		<button class="btn btn-primary col-lg-2 col-lg-offset-9" type="button" name="submit" id="submit">Submit</button>
    		<div class="col-lg-12 text-center"  style="background-color:red; color:white" id="validation" ></div>		
    		
		<br>
		</form>
		</div>
		</div>
		</div>
		</div>
		
  </div>
 
</div>
</div>
<!-- Adding Product End-->
<!--    		<button class="btn btn-primary col-lg-offset-9" type="button" name="submit" data-toggle="modal" data-target="#myModal" id="submit" onClick="location.reload()">Submit</button>
 -->
</div>
<br><br>
<footer class="container-fluid text-center">
  <p><b>&copy; Copyright 2017 All Rights Reserved www.nacresoftwareservices.com</b></p>
</footer>
</body>
</html>
