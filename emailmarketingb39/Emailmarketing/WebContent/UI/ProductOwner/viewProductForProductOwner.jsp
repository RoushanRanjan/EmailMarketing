<!-- Author: Satyajeet and Amit -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Email Marketing</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assests/bootstrap/css/bootstrap.min.css">
  <script src="<%=application.getContextPath()%>/JS/jquery-1.12.3.js"></script>
  <script src="<%=application.getContextPath()%>/assests/bootstrap/js/bootstrap.min.js"></script>
<%--    <script src="<%=application.getContextPath()%>/JS/viewProductForProductOwner.js"></script>
 --%>     <script src="<%=application.getContextPath()%>/JS/jquery.multi-select.js"></script>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/JS/multi-select.css">
   <script>
   $(document).ready(function(){
		$("#error").hide();
		$("#success").hide();
	//	$("#success1").hide();
		$("#selectError").hide();
		$("#error1").hide();
		$("#loader").hide();


		var $url4=$('#url4').val();
		var $url5=$('#url5').val();
		var $url6=$("#url6").val();
		var $url7=$("#url7").val();
		
		$('#pre-selected-options').change(function(){
			$("#selectError").hide();
		});
		$('#close').click(function(){
			$("#selectError").hide();
			$("#error1").hide();
			$("#success").hide();
		});

		
		var idValue;
		$('.myService').click(function() {
			idValue = $(this).attr('id');
			$('#pre-selected-options').multiSelect();
			
		});
		$(".myServiceConfirm").click(function ()
		{
			$("#error1").hide();
			$("#success").hide();
			var data1 = [];
			
			$("select").each(function(el) {
			     // alert($(this).val());
				   data1.push([$(this).val()]);
				   //              alert(data1);       
	          });
			if(data1[0]==""){
				$("#selectError").show();
			}else{
				$("#loader").show();

		//	alert($url7);
		//	var json = JSON.stringify(data1);
			debugger;
			$.ajax({
	             type: 'POST',
	             url:  $url7+"?productId="+idValue+"&data1="+data1,
	       //      data: {data1:data1},
	             success: function(msg){ 
	            	if(msg==1){
	            		$("#loader").hide();
	            		$("#success").show();
	            	}else{
	            		$("#loader").hide();
	            		$("#error1").show();
	            	}       
	         	}
			});
			}
		});	
		$.getJSON($url6,function(data) {
			var a;
				$.each(data, function(key,value) {
					a=a+"<option value="+value+">"+key+"</option>"
				});
				$("#pre-selected-options").html(a);
		});		

		$(".btn").click(function(){
			$("#error").hide();
			$("#success").hide();
		});
		$('.myDelete').click(function() {
			idValue = $(this).attr('id');
		//	alert(idValue);
		});
				
		$('.myDeleteConfirm').click(function() {
		//	alert(idValue);
		/*var form_data = new FormData();                  // Creating object of FormData class
		form_data.append("productId", idValue)              // Appending parameter named file with properties of file_field to form_data;
	*/	 /*These above two are not working as Id is not form data*/
			
			$.ajax({
			    url: $url4+"?productId="+idValue,
			    type: 'POST',
			    async: false,
			    cache: false,
			    contentType: false,
			    processData: false,
			    success: function (returndata) {
			    	if(returndata==1){
			    		location.reload();
			    	}else{
			    		$("#error").show();
			    	}
			    }
			  });
		});
	});
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
    .sidenav{
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    
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
    
	 .container {
/* 	max-width: 800px;
 */    border-radius: 5px;
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 40px;
    padding-right: 50px;
	} 
	
	/* Pagination */
	.pagination>li>a, .pagination>li>span { border-radius: 50% !important;margin: 0 5px;}
	
	/* 3d Button */
	.btn3d {
    transition:all .08s linear;
    position:relative;
    outline:medium none;
    -moz-outline-style:none;
    border:0px;
    margin-right:10px;
    margin-top:15px;
}
.btn3d:focus {
    outline:medium none;
    -moz-outline-style:none;
}
.btn3d:active {
    top:9px;
}
.btn-primary {
    box-shadow:0 0 0 1px #428bca inset, 0 0 0 2px rgba(255,255,255,0.15) inset, 0 8px 0 0 #357ebd, 0 8px 0 1px rgba(0,0,0,0.4), 0 8px 8px 1px rgba(0,0,0,0.5);
    background-color:#428bca;
}
.btn-info {
    box-shadow:0 0 0 1px #5bc0de inset, 0 0 0 2px rgba(255,255,255,0.15) inset, 0 8px 0 0 #46b8da, 0 8px 0 1px rgba(0,0,0,0.4), 0 8px 8px 1px rgba(0,0,0,0.5);
    background-color:#5bc0de;
}
.btn-danger {
    box-shadow:0 0 0 1px #c63702 inset, 0 0 0 2px rgba(255,255,255,0.15) inset, 0 8px 0 0 #C24032, 0 8px 0 1px rgba(0,0,0,0.4), 0 8px 8px 1px rgba(0,0,0,0.5);
    background-color:#c63702;
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

<%-- <nav class="navbar navbar-inverse">
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
 
 <div class="container-fluid text-center">    
  <div class="row content"> 
  <div class="col-sm-8 text-left col-sm-offset-2">
	 <div class="panel" >
  
 
   
 	    	<!-- <div class="alert alert-success alert-dismissable text-center" id='success1'>
   		 		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
   		 		<strong>Success!</strong> Product deleted successfully.
 	    	</div> -->
           	<div class="alert alert-danger alert-dismissable text-center" id='error' style="display: none">
   				 <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
   				 <strong>Error!</strong> Internal Problem. Try Again.
  			</div>
  			</div>
  			
  	</div>

  		<!--Choose services  -->
  		<div id="service" class="modal fade" role="dialog">
    <div class="modal-dialog modal-md">

    <div class="modal-content">
      <div class="modal-header" style="background-color:#3b5998">
       <button type="button" id="close" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title" style="color:white">Choose Services</h4>
        
      </div>
      <div class="modal-body">
      <div id="loader"><img src="<%=application.getContextPath()%>/IMAGES/loader.gif"></div>
      
      <div class="alert alert-success alert-dismissable text-center" id='success'>
   		 		<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
   		 		<strong>Success!</strong> Your Product details sent successfully to mails.
 	    	</div>
 	    	<div class="alert alert-danger alert-dismissable text-center" id='error1'>
   				 <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
   				 <strong>Error!</strong> Internal Problem. Try Again.
  			</div>
      <div id="selectError" style="color:red"><b>Service is required</b></div>
      <input type="hidden" id="url6" value="<%=application.getContextPath()%>/showServicesForPorductOwnerAction"/>
      <form action="" method="post">
      <div class="form-group">
            <div class="col-md-12 col-md-offset-2">
   			<select id='pre-selected-options' multiple='multiple' name="pre-selected-options" class="form-control">
   			 </select>
   			</div>
     	 <div class="modal-footer">
      		<button class="myServiceConfirm btn btn-success" type="button" name="submit" id="submit">Submit</button>
          </div>
      </div>
      </form>
    </div>
	</div>
</div>
  		
  		</div>
  	  	 <!--Delete Modal content-->
	<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">

    <div class="modal-content">
      <div class="modal-header" style="background-color:#3b5998">
        <h4 class="modal-title" style="color:white">Delete Product</h4>
      </div>
      <div class="modal-body">
        <p>Are you sure for delete product?</p>
      </div>
      <div class="modal-footer">
 
        <button type="button" class="myDeleteConfirm btn btn-success" data-dismiss="modal" data-toggle="modal">Yes</button>
         <button type="button" class="btn btn-warning" data-dismiss="modal" data-toggle="modal">No</button>
          
      </div>
    </div>
	</div>
</div>
  <input type="hidden" value="<%=request.getContextPath()%>/deleteProduct" id="url4">
<%--   <input type="hidden" value="<%=request.getContextPath()%>/featchProduct" id="url5">
 --%>  <input type="hidden" value="<%=request.getContextPath()%>/useService" id="url7">
  
  <h3 style="text-align:right">${listDto.ownerName}</h3><br>
  <div class="row">
  <c:choose>
  	<c:when test="${listDto.listProductDto.size()!=0}">
   <c:forEach items="${listDto.listProductDto}" var="dto">
   <c:choose>
	<c:when test="${dto ne null}">
    <div class="col-sm-3" style="border:1px solid #cecece; padding-left: 20px">
        
      <img src="${dto.image}" alt="Image" width="150px" height="150px"><br>
      <b>Product:</b> <span>${dto.proudctName} ${dto.productType}</span><br>
      <b>In stock:</b> <span>${dto.quantity}</span><br>
      <b>Price:</b> Rs. <span> ${dto.pirce}</span>/-<br>
 	<a type="button" class="myService btn btn-primary btn-sm btn3d" data-toggle="modal" data-target="#service" id="${dto.productId}"><span class="glyphicon glyphicon-cloud"></span> Service</a>
 	<a type="button" class="myUpdate btn btn-info btn-sm btn3d" href="<%=request.getContextPath()%>/featchProduct?productId=${dto.productId}"><span class="glyphicon glyphicon-question-sign"></span> Update</a>
 	<button type="button" class="myDelete btn btn-danger btn-sm btn3d" data-toggle="modal" data-target="#myModal" id="${dto.productId}"><span class="glyphicon glyphicon-remove"></span> Delete</button>
 	<br><br>
    </div>
    </c:when>
			<c:otherwise>
				<div class="alert alert-info alert-dismissable text-center" id='info'>
   		 		<strong>No product found!</strong>
 	    	</div>
			</c:otherwise>
		</c:choose>
    </c:forEach>
    </c:when>
    <c:otherwise>
		<div class="alert alert-info alert-dismissable text-center" id='info'>
   		<strong>No product found!</strong>
 	    </div>
	</c:otherwise>
	</c:choose>
 </div>
 </div>
 
 <div class="col-sm-8 text-center col-sm-offset-2">
	 <div class="panel " >
	<ul class="pagination">
		<c:forEach var="page" begin="1" end="${listDto.tatolPage}">
              <li><a href="<%=application.getContextPath()%>/viewProductForProductOwner?pageNo=${page}">${page}</a></li>
 		</c:forEach>             
 </ul>
 </div>
 </div>
</div>
<footer class="container-fluid text-center">
  <p><b>&copy; Copyright 2017 All Rights Reserved www.nacresoftwareservices.com</b></p>
</footer>
</body>
</html>
