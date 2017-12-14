<!DOCTYPE html>
<html lang="en">
<head>
  <title>User_Header</title>
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
background-color: #222222;
    }

  </style>
</head>
<body>
<!-- <nav class="navbar navbar-inverse">
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="Index.jsp"><span class="glyphicon glyphicon-home"></span><b> Home</b></a></li> 
      </ul>
    </div>
</nav> -->
<nav class="navbar navbar-inverse ">
  <div class="container-fluid">
    <div class="navbar-header"><br>
      <div class="navbar-brand" ><img src="<%=application.getContextPath()%>/IMAGES/UI_Images/img1.jpg" height="80px" width="100px" ></div>
     <!--  <ul class="nav navbar-nav"><br>
     <b style="color:#999999;">Email-Marketing</b>
      </ul> -->
    </div>
    <div class="collapse navbar-collapse" id="myNavbar"><br>
  <!--   <b style="color:#999999;">Email-Marketing</b> -->
      <ul class="nav navbar-nav">
     <!--  <li><a href="#"><span class="glyphicon glyphicon-user"></span><b> Create Account</b></a></li> -->
     <!--    <li><a href="#"><b>Buy</b></a></li> -->
    <!--   <li><a href="#"><span class="glyphicon glyphicon-shopping-user"></span><b> User </b></a></li> -->
       
        
        
        
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
 <%-- input[type=text] {
    width: 790px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    background-image: url('<%=application.getContextPath()%>/IMAGES/UI_Images/search3.png');
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
   
} --%>

</style>
</head>
<body>


<div class="dropdown">
  <button class="dropbtn"><span class="glyphicon glyphicon-cog"></span><b> Settings</b></button>
  <div class="dropdown-content">
    <a href="<%=application.getContextPath()%>/UI/authentication/changePassword.jsp"><b>Change Password</b></a>
   <!--  <a href="#">Link 2</a>
    <a href="#">Link 3</a> -->
  </div>
</div>
        
       <!--  <li><form>&nbsp;&nbsp;&nbsp;
 	 <input type="text" name="search"  placeholder="  Search..">
	</form></li>
        --> 
        
      <!--   <li><a href="#"><span class="glyphicon glyphicon-cog"></span><b> Settings</b></a></li> -->
       <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span><b> Cart </b></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
    <!--     <li><a href="/Emailmarketing/logoutactionurl/authentication"><span class="glyphicon glyphicon-log-out"></span><b> LogOut </b></a></li>
     -->  </ul>
    </div>
  </div>
</nav>
