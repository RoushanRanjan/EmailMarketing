<!DOCTYPE html>
<html lang="en">
<head>
<%@page import="java.util.*,com.nacre.emailmarketing.Action.ProductVeiw_Action"%>
  <title>Email Marketing</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assests/bootstrap/css/bootstrap.min.css">
  <script src="<%=application.getContextPath()%>/JS/jquery-1.12.3.js"></script>
  <script src="<%=application.getContextPath()%>/assests/bootstrap/js/bootstrap.min.js"></script>

  <style>
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
   
  </style>
  <script type="text/javascript">
function addCart(){
	
	
}

function buyNow(){
	
	
}

</script>
  
</head>
<body>

	<%@ include file="/UI/common/WelcomePage_Header.jsp" %>
<%
	List al = (ArrayList) request.getAttribute("details");
	
%>
<div class="container text-center">    
  <h1>Product Details</h1><br>
  <div class="row">
    <div class="col-sm-6">
    
           <img src=<% out.println(al.get(1)); %> height="200%"	width="50%" alt="Product Image" />
             
    </div>
    
    <div class="col-sm-6 text-left">
      <div class="well">
      <h2><% out.println(al.get(0)); %>&nbsp;<% out.println(al.get(3)); %></h2>
     <h3><b> Price:</b> Rs. <% out.println(al.get(2)); %>/-<br><br>
     <b> Quantity:</b> <% out.println(al.get(4)); %></h3>
      </div>
      
    </div>
    <div class="col-sm-12 text-center">
        <br><br><br><br>
    
 			 <a type="button" class="btn btn-success btn-lg" href="UI/common/UserRegistration.jsp">BUY NOW</a>
           
    </div>
  </div>
</div><br>
<br><br><br><br>
<footer class="container-fluid text-center">
  <p><b>&copy; Copyright 2017 All Rights Reserved www.nacresoftwareservices.com</b></p>
</footer>

</body>
</html>
