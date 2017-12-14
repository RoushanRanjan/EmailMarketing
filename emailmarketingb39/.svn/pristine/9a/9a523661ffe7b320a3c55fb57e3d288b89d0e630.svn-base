<!-- Author: Satyajeet and Amit -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" import="java.util.*, com.nacre.emailmarketing.dto.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Email Marketing</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assests/bootstrap/css/bootstrap.min.css">
  <script src="<%=application.getContextPath()%>/JS/jquery-1.12.3.js"></script>
  <script src="<%=application.getContextPath()%>/assests/bootstrap/js/bootstrap.min.js"></script>
    <BODY onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">
    <SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
  <script>
window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
window.onhashchange=function(){window.location.hash="no-back-button";}
</script> 
<style>
footer {
      background-color: #31698a;
      color: white;
      padding: 15px;
    }
    /*For Drop down*/
/* .dropbtn {
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
         <li><div class="dropdown">
  			<button class="dropbtn"><b>Track User</b></button>
  				<div class="dropdown-content">
    			<a href="<%=application.getContextPath()%>/UI/User/ViewUserClickOperationHighChart.jsp"><b>Click</b></a>
    			<a href="<%=application.getContextPath()%>/UI/User/ViewUserBuyOperationHighChart.jsp"><b>Buy</b></a>
  				</div>
			</div>
        </li>
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
  <h2 style="text-align: center">Services</h2>
  <div class="panel-group">	
  <%!
  List<ServiceDTOForProductOwnerHomePage> listDto;
  ServiceDTOForProductOwnerHomePage dto;
  ServiceDTOForProductOwnerHomePage dto1;
  ServiceDTOForProductOwnerHomePage dto2;
  ServiceDTOForProductOwnerHomePage dto3;
  %>
  <% listDto=(List<ServiceDTOForProductOwnerHomePage>)request.getAttribute("listDto");
   dto=listDto.get(0);
   dto1=listDto.get(1);
   dto2=listDto.get(2);
   dto3=listDto.get(3);
  %>
    

    <div class="panel panel-success">
      <div class="panel-heading"><%=dto.getServiceName()%></div>
      <div class="panel-body"><b>Owner Name:</b><%=dto.getOwnerName()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> Company Name:</b> <%=dto.getCompanyName()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Total Mails:</b><%=dto.getTotalMails()%> </div>
    </div>
	<br>
    <div class="panel panel-info">
      <div class="panel-heading"><%=dto1.getServiceName()%></div>
      <div class="panel-body"><b>Owner Name:</b><%=dto1.getOwnerName()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> Company Name:</b> <%=dto1.getCompanyName()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Total Mails:</b><%=dto1.getTotalMails()%> </div>
    </div>
<br>
    <div class="panel panel-warning">
     <div class="panel-heading"><%=dto2.getServiceName()%></div>
      <div class="panel-body"><b>Owner Name:</b><%=dto2.getOwnerName()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> Company Name:</b> <%=dto2.getCompanyName()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Total Mails:</b><%=dto2.getTotalMails()%> </div>
    </div>
<br>
    <div class="panel panel-danger">
      <div class="panel-heading"><%=dto3.getServiceName()%></div>
      <div class="panel-body"><b>Owner Name:</b><%=dto3.getOwnerName()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> Company Name:</b> <%=dto3.getCompanyName()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Total Mails:</b><%=dto3.getTotalMails()%> </div>
    </div>
    
  </div>
</div>
<br>
<footer class="container-fluid text-center">
  <p><b>&copy; Copyright 2017 All Rights Reserved www.nacresoftwareservices.com</b></p>
</footer>
</body>

</html>
