<%-- <%@include file="/UI/common/Welcome_page.jsp" %>
 --%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="/UI/common/Header.jsp" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>email markiting</title>
<style type="text/css">
<%-- 
body { 
    background-image: url("<%=application.getContextPath()%>/IMAGES/UI_Images/EM.jpg");
   background-repeat:no-repeat;
    background-attachment: fixed;
    background-position: center;
     background-size: 100%; 
}	  --%>
</style>
</head>



<body style="background-color:#f9f9f9; text-align:center">
   <form action="<%=application.getContextPath()%>/AuthenticationAction" >
<center>
<h1><br>Forgot Password</h1>

<h3 style="padding:5px ;text-align:">Email</h3>
<input type="text" name="text" size="58"  placeholder="Enter Email" style="height: 36px; width: 372px"><br><br>
<ul>
<li style="color:DarkGoldenRod;"><h1>Enter valid Email-id</h1>
<input type="submit" name="submit" value="Send mail" size="58" style="width: 372px; height: 36px; color:white; background-color:cornflowerBlue; ">
 </li>
  </form>
</center>
</body>



</html>