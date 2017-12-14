<%@ include file="Admin_Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style>
#s {
position:relative;
left: 120px;
}



body{
	background-image:
		url("<%=application.getContextPath()%>/IMAGES/images.jpg");
	background-repeat: no-repeat;
	background-attatchment: fixed;
	background-position: centre;
	background-size: 100%;
}

.dropbtn {
    background-color: #222;
    color: #9d9d91;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
    background-color: #3e8e41;
}

.dropdown {
    position: relative;
    display: inline-block;
    float: right;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    overflow: auto;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown a:hover {background-color: #f1f1f1}

.show {display:block;}
table{
border-collapse: collapse;
width: 100%;

}
th,td{
text-align: left;
padding: 8px;
}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/mytable.css"></link>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script>
var a=" ";
var g="nacre";
$(document).ready(function(){
	
	<%--  $.getJSON("<%=application.getContextPath()%>/AdminNotificationCheck",function(data) {
          alert();
		
			$.each(data, function(key,value) {
				a=a+"<option value="+key+">"+value+"</option>"
			});//each
			$("#product").append(a);
			alert($(this).val())
			alert(a);
		})	 --%>

    $(".t").click(function(){
    	
    	$("#s2").empty();
    	$("#s").hide();
    	$("#t1").hide();
        $("#s").html("");
        
        var lid= $(this).attr("linkId");
        $.ajax({
        	"url":"<%=application.getContextPath()%>/AdminNotificationCheck",
        	"data":{"linkId":lid},
        	"success":function(data){
        	var sel = 	$("<br><br><select id='#product'>");
        	$("#s").html("");
        	$("#s").append(sel);
        	
        
/*         	debugger;
 */        		if(lid==1){
        			sel.append("<option>SELECT PRODUCT</option>");
        		}else if(lid==2){
        			sel.append("<option>SELECT SERVICE</option>");
            			
        		}else if(lid==3){
        			sel.append("<option>SELECT USER</option>");
            		
        		}
    			console.log(data);
        		$.each(data, function(key,value) {
        			
        			sel.append("<option value='"+key+"'>"+value+"</option>");
    			});//each
    			
    			sel.change(
    			function(){
    				var $b = $(this).val();
    				$("#s1").html("");
    				var c= " ";
    				$.ajax({
    					"url":"<%=application.getContextPath()%>/AdminNotificationDetail",
    		        	"data":{"linkId":lid , "key":$b  },
    		         	"success":function(data){
    		         		$("#s1").hide();
    		         		//$("#s2").html("");
    		         		if(lid==1){
  		         		
    		         		var tab ="<table border='1' align='center'>"+
    		         			  "<thead>"+
    		         			 "<tr bgcolor='pink'>"+
    		         			     
    		         			 "<th>ProductName</th>"+

    		         			 "<th>ProductOwne name</th>"+
    		         			" <th>Price</th>"+

    		         			" <th>type</th>"+
    		         			 "</tr>"+
    		         			 "</thead>"+
    		         			 "<tbody  id='mytb'>";
    		         		}
    		         		
    		         		if(lid==2){
        		         		var tab ="<table border='1' align='center'>"+
        		         			  "<thead>"+
        		         			 "<tr bgcolor='pink'>"+
        		         			     
        		         			 "<th>SeviceName</th>"+

        		         			 "<th>ServiceOwne name</th>"+
        		         			" <th>Date</th>"+
        		         			 "</tr>"+
        		         			 "</thead>"+
        		         			 "<tbody  id='mytb'>";
        		         		}
    		         		
    		         		if(lid==3){
        		         		var tab ="<table border='1' align='center'>"+
        		         			  "<thead>"+
        		         			 "<tr bgcolor='pink'>"+
        		         			     
        		         			 "<th>userName  </th>"+

        		         			 "<th>Product name</th>"+
        		         			" <th>Date </th>"+

        		         			" <th>type</th>"+
        		         			 "</tr>"+
        		         			 "</thead>"+
        		         			 "<tbody  id='mytb'>";
        		         		}
    		         		$("#s1").html("");
    		         		c="<tr>";
    		        		$.each(data, function(key,value){
    		        		
    		        			c+="<td >"+value+"</td>";
    		        		});//each2
    		           c+="</tr>";
    		           
    		        	   tab=tab+c+
		         			 "</tbody>";
        			 
    		        		$("#s2").append(tab);
    		        		 
    		              //  $("#s1").show();
    		                //$("#s2").append("<<h4>ProductName    ProductOwner name             Price            type </h4>");    		                
    		                	
    		        	}
    		        	
    				});
    				  
    			});
        	}
        	
        });
        //$("#s2").DataTable();
        $("#s").show();
        
        return false;
         
    });
   
});
</script>
</head>
</head>
<body>
<div >
<div class="dropdown" id= "t1"><br></div>
<div class="dropdown"><br><br>
 <div onClick="myFunction()" class="dropbtn" align="center">Notifications</div>
  <div id="myDropdown" onload="myFunction()" class="dropdown-content">
  <div >
    <a  href = "AdminNotificationCheck?linkid=1" linkId='1'  class= "t" >Product  Notifications</a>
 </div>
    <a href="AdminNotificationCheck?linkid=2"   linkId='2'class= "t">Service Owner Notifications</a>
    <a href="AdminNotificationCheck?linkid=3" linkId='3'  class= "t">Customer Notifications</a>
  </div>
</div>
</div>
<div align="center">
<div id="s"></div>
<table id = "s2"  ></table>
<div class = "disp" id = "s1"></div></div>
<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>

</body>
</html>
