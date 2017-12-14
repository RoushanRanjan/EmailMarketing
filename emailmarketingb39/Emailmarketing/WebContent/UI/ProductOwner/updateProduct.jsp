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

    <script>
  	/* Uploading Image File */
	/* function readURL(input) {
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
	    function addProduct(){    
	    //event.preventDefault();
		var $url2=$("#url2").val();
		 var file_data = $("#imageUpload").prop("files")[0];   // Getting the properties of file from file field
			var form_data = new FormData();                  // Creating object of FormData class
			form_data.append("image", file_data)              // Appending parameter named file with properties of file_field to form_data
		 form_data.append("pid",$("#pid").val())
		 form_data.append("pName",$("#pName").val())
		// alert($("#txtProductName").val());
		 form_data.append("price", $("#price").val()) 
		// alert($("#txtProductModel").val());
		 form_data.append("quantity",$("#quantity").val()) 
		// alert($("#txtCategoryType").val());
		 form_data.append("pType", $("#pType").val()) 
		

		// alert(form_data);
			  $.ajax({
		    url: $url2,
		    type: 'POST',
		    data: form_data,
		    async: false,
		    cache: false,
		    contentType: false,
		    processData: false,
		    success: function (returndata) {
		      if(returndata==0){
		    	  $("#error").show();
		      }else{
		    	  $("#success").show();
		      }
		    }
		  });
		 
		  return false;
	}
	$(document).ready(function() {
		/*For image upload*/
		var $imageValid=0;
		$("#imageUpload").change(
				function() {
					$imageValid=0;
					//$("#dvPreview").html("");
					var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.jpg|.jpeg|.gif|.png|.bmp)$/;
					if (regex.test($(this).val().toLowerCase())) {
						
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
					
					} else {
						$imageValid=1;
					   	$('#blah').attr('src', "<%=application.getContextPath()%>/IMAGES/new_product_default.png");

					}
				});
		/*Impage upload end*/
		
		$("#success").hide();
		$("#error").hide();
		$(".myUpdateConfirm").click(function(){
			addProduct();
		});
		$("#submit").click(function(){ 
			$("#validation").text("");
			$("#success").hide();
			$("#error").hide();
			var regPrice = new RegExp("^[0-9]+$");
			if($("#price").val()==""){
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
			}else if($imageValid==1){
				$("#validation").text("Please upload a valid image file");
			}else{
				$('#myModal').modal('show');
			}
		});	
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
 */
  </style>
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
 <div class="container">
 
<!-- Adding Product Start-->
 <div class="container-fluid text-center">    
  <div class="row content">
	<!-- Update product start-->
	<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">

    <div class="modal-content">
      <div class="modal-header" style="background-color:#3b5998">
        <h4 class="modal-title" style="color:white">Update Product</h4>
      </div>
      <div class="modal-body">
        <p>Are you sure for update product?</p>
      </div>
      <div class="modal-footer">
 
        <button type="button" class="myUpdateConfirm btn btn-success" data-dismiss="modal" data-toggle="modal">Yes</button>
         <button type="button" class="btn btn-warning" data-dismiss="modal" data-toggle="modal">No</button>
          
      </div>
    </div>
	</div>
</div>
	
	<!-- Update product end-->
  <br>
	<div class="col-sm-8 text-left col-sm-offset-2">
	 <div class="panel panel-info">
      <div class="panel-heading text-center"><b>UPDATE PRODUCT<b></div>
	   
    	<div class="row"> 	    
        <div class="col-sm-12">
          <div class="panel-body">
          	<div class="alert alert-success alert-dismissable text-center" id='success'>
   		 		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
   		 		<strong>Success!</strong> Product updated successfully.
 	    	</div>
          	<div class="alert alert-danger alert-dismissable text-center" id='error'>
   				 <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
   				 <strong>Error!</strong> Internal Problem. Try Again.
  			</div>	
  			
  			
			<form enctype='multipart/form-data' method="post" id="myForm">
			  <input type="hidden" value="<%=request.getContextPath()%>/updateProductAction" id="url2">
				<input type="hidden" id="pid" value="${dto.productId}"/>
				<div class="col-lg-8">	
			     <label for="prName" class="col-lg-4 control-label">Product Name</label>
			     <div class="col-lg-8">
   				 <input type="text" id="pName" name="pName" class="form-control" value="${dto.proudctName}" disabled="disabled"/>
				</div>	
    			 <label for="pr" class="col-lg-4 control-label">Price</label>
    			 <div class="col-lg-8">
   				 <input type="text" id="price" name="price" class="form-control" value="${dto.pirce}"/>
    			</div>
    			
    				
   				 <label for="quan" class="col-lg-4 control-label">Quantity</label>
   				 <div class="col-lg-8">
  				  <input type="text" id="quantity" name="quantity"  class="form-control" value="${dto.quantity}">
				</div>
					
					<label for="pt" class="col-lg-4 control-label">Product Type</label>
				<div class="col-lg-8">
  				  <input type="text" id="pType" name="pType" class="form-control" value="${dto.productType}" disabled="disabled">
				</div>

    			</div>
    			<div class="col-lg-4 text-center">
<!--     			<label for="pi" class="col-lg-4 control-label">Product Image</label>
 -->				<br><br><div class="col-lg-12"  align="center">
					<img id="blah" src="${dto.image}"  alt="Image" height="120px" width="120px"/>
				</div>	
    			<div class="col-lg-12">
    			<span class="btn btn-default btn-file" >
   				 Browse Image<input type="file" name="imageUpload" id="imageUpload" class="form-control-file"> <!-- onchange="readURL(this)"/> -->
				</span>
				<br><br><br><br><br>
				</div>    			
    			</div>
       		<button class="btn btn-primary col-lg-2 col-lg-offset-9" type="button" name="submit" id="submit">Submit</button>
       		<div class="col-lg-12 text-center" style="background-color:red; color:white" id="validation"></div>		
       		
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
