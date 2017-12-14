<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
background-color: #222222;
    }
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }

  .dropbtn {
   /*  background-color: #4CAF50; */
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
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <div class="navbar-brand" ><img src="<%=application.getContextPath()%>/IMAGES/UI_Images/img1.jpg" height="80px" width="100px" ><br><br></div>
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
        <li>
        		<a href="<%=application.getContextPath()%>/ProductOwnerNotificationServlet"><span class="glyphicon glyphicon-globe"></span><b> Notification</b></a>
        </li>
		<li>
     		<div class="dropdown">
  				<button class="dropbtn"><span class="glyphicon glyphicon-cog"></span><b> Track User</b></button>
  				<div class="dropdown-content">
					<a href="<%=application.getContextPath()%>/UI/ProductOwner/ViewUserClickOperationHighChart.jsp"><b> Click</b></a>
     		      <a href="<%=application.getContextPath()%>/UI/ProductOwner/ViewUserBuyOperationHighChart.jsp"><b> Buy</b></a>     				  
   
 			 </div>
			</div>
     	</li>     	<li>
     		<div class="dropdown">
  				<button class="dropbtn"><span class="glyphicon glyphicon-cog"></span><b> Settings</b></button>
  				<div class="dropdown-content">
   				  <a href="<%=application.getContextPath()%>/UI/authentication/changePassword.jsp"><b>Change Password</b></a>	
 			 </div>
			</div>
     	</li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/Emailmarketing/logoutactionurl"><span class="glyphicon glyphicon-log-out"></span><b> Logout </b></a></li>
      </ul>
    </div>
  </div>
</nav>

</body>
</html>

