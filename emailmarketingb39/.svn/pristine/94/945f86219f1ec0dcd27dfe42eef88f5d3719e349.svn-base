<%@include file="/UI/Admin/Admin_Header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="operationType.css"/>
 <script type="text/javascript">

 function checkvalue(val)
{
    if(val==="1"||val==="2"||val=="3")
       document.getElementById('t1').style.display='block';  
} 
 $(document).ready(function() {
		$("#btn").click(function(){
		//alert("hi")
			$("#ds").append("price successfully changed");
		})
	}) 
 

</script> 
</head>
<body>

<br></br>
<br></br>
<br></br>
<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 -->
 <!--  <h1 class="register-title">ADMIN</h1> -->
 <div id="ds"></div>
<form action="<%=application.getContextPath() %>/operationtypeAction" class="register">
    
   <label>Select</label></td>
   <select name="name" onchange='checkvalue(this.value)'> 
    <option>select operation type</option>  
    <option value="1">Click</option>
    <option value="2">Buy</option>
<!--     <option value="3">Cart</option>
 -->	</select> <br>
	<br>
	<label>Add price(%)</label>
	<input type="text" name="t1" id="t1" style='display:none'/><BR>
 	
     <input type="submit" value="update" class="register-button" id="btn" onclick="m()">

     
  </form>
  <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
<%@include file="/UI/Admin/Footer.jsp" %>
	 
</body>


</html>
