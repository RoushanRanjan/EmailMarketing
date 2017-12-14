<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
	<script  src="<%=application.getContextPath() %>/JS/jquery-3.1.1.js"></script>
	<script  src="<%=application.getContextPath() %>/JS/ProductOwnerTotalNotifications.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assests/bootstrap/css/bootstrap.min.css">
  <script src="<%=application.getContextPath()%>/JS/jquery-1.12.3.js"></script>
  <script src="<%=application.getContextPath()%>/assests/bootstrap/js/bootstrap.min.js"></script>
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
  </style>
</head>
<body>
	<input type="hidden" id="url" value="<%=request.getContextPath()%>/ProductOwnerTotalNotificationsServlet"/>

<nav class="navbar navbar-inverse ">
  <div class="container-fluid">
    <div class="navbar-header"><br>
      <div class="navbar-brand" ><img src="<%=application.getContextPath()%>/IMAGES/UI_Images/img1.jpg" height="80px" width="100px" ></div>
     <!--  <a class="navbar-brand" href="#">Email-Marketing</a> -->
    </div>
    <div class="collapse navbar-collapse" id="myNavbar"><br>
  <!--   <b style="color:#999999;">Welcome to Product Owner Home Page</b> -->
      <ul class="nav navbar-nav">
     <!--  <li><a href="#"><span class="glyphicon glyphicon-user"></span><b> Create Account</b></a></li> -->
        <li><a href="#"><b>Add Product</b></a></li>
        <li><a href="<%=application.getContextPath()%>/ProductOwnerNotificationServlet"><b id="ProductOwnerTotalNotificationsId"></b><span class="glyphicon glyphicon-globe"></span><b> Notification</b></a></li>
       <li><div class="dropdown">
  			<button class="dropbtn"><b>Track User</b></button>
  				<div class="dropdown-content">
    			<a href="<%=application.getContextPath()%>/UI/User/ViewUserClickOperationHighChart.jsp"><b>Click</b></a>
    			<a href="<%=application.getContextPath()%>/UI/User/ViewUserBuyOperationHighChart.jsp"><b>Buy</b></a>
  				</div>
			</div>
        </li>
        
        
        <style>
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


<div class="dropdown">
  <button class="dropbtn"><span class="glyphicon glyphicon-cog"></span><b> Settings</b></button>
  <div class="dropdown-content">
    <a href="/UI/authentication/changePassword.jsp"><b>Change Password</b></a>
   <!--  <a href="#">Link 2</a>
    <a href="#">Link 3</a> -->
  </div>
</div>
        
        
        
        
        
        
        <!--  <li><a href="#"><span class="glyphicon glyphicon-cog"></span><b> Settings</b></a></li> -->
     
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/Emailmarketing/logoutactionurl"><span class="glyphicon glyphicon-log-out"></span><b> Logout </b></a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center"><br>  
  <div class="row content"><br>
    <!-- <div class="col-sm-2 sidenav"><br>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div> -->
    <div class="col-sm-12 text-left"> 
       <h1>Welcome</h1>
      <p>Product Owner Page.</p>
      <hr>
      <h3>Modification</h3>
      <p>Product Owner...</p>
    </div>
   
  </div>
</div>
<div><br><br><br></div>
<footer class="container-fluid text-center">
  <p><b>&copy; Copyright 2017 All Rights Reserved www.nacresoftwareservices.com</b></p>
</footer>
	
</body>
</html>
