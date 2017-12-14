 <%@include file="/UI/Admin/Admin_Header.jsp"%>
  
<html>
<head>
<title>Cost Spend Per Day Bar Chart</title>




<!-- <script src="./JS/jquery-1.3.2.min.js"></script>
<script src="/JS/highcharts.js"></script> -->  
 
       
<script src="<%=application.getContextPath() %>/JS/jquery-1.3.2.min.js"></script>
<script src="<%=application.getContextPath() %>/JS/highcharts.js"></script>  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 

</head>
        
        
        
        <script>
$(document).ready(function() {
	
//alert(message)
	//alert("hello  i am ready "); 
	//costSpendPerBarChart();
	//alert("hellooo");

         
//function costSpendPerBarChart() {
	 
-	$.ajax({
		
		url : "<%=application.getContextPath()%>/Action?pid="+<%=request.getParameter("val")%>,
		dataType:"json",
		success : function(jsonArray) {
	//alert(typeof (jsonArray));
   var chart = {
      type: 'bar'
   };
   var title = {
       text: 'User Action'    
   };
   var subtitle = {
     text: 'Source:Nacre Software Services ' 
   };
   var dat1=[];
	/* for(var i=0;i<jsonArray.length;i++){
		
		 dat1.push([jsonArray[i].serviceName]);
		 
	} */

//	 dat1.push(jsonArray);

for( var i=0; i<jsonArray.length ;i++){

dat1.push(jsonArray[i].serviceName);

}

	//alert(dat1);
	var s=[];
	s.push(dat1);
	//s.dat1=dat1;
	//alert(s);
	/* var s=[];
	var s1=[];
	for(var i=0;i<dat1.length;i++){
	//alert(s[i]);
	s=s.push([dat1[i]]);
	alert(s);
	}
	for(var j=0;j<s.length;j++){
	alert(s1[j]);
	
	}
	 */ 
	 /* $.each(jsonArray,function(key,val){
                        dat1.push(val);
                       
                        });
	 */
 //  alert(dat1);
   var xAxis = {
      categories: dat1,
      labels: {
          rotation: -45,
          style: {
              fontSize: '13px',
              fontFamily: 'Verdana, sans-serif',
              color:'red'
          }
      }
   };
   var yAxis = {
      min: 0,
      title: {
         text: 'Amount(Unit)',
         align: 'high'
      },
      labels: {
         overflow: 'justify'
      },
      labels: {
          rotation: -45,
          style: {
              fontSize: '13px',
              fontFamily: 'Verdana, sans-serif',
              color:'red'
          }
      }
   };
   var tooltip = {
      valueSuffix: ''
   };
   var plotOptions = {
      bar: {
         dataLabels: {
            enabled: true
         }
      },
	/*   series: {
	     stacking: 'normal'
	  } */
   };
   var legend = {
      layout: 'vertical',
      align: 'right',
      verticalAlign: 'top',
      x: -40,
      y: 100,
      floating: true,
      borderWidth: 1,
      backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#7CFC00'),
      shadow: true
   };
   var credits = {
      enabled: false
   };
   var dat =[];
	 for(var i=0;i<jsonArray.length;i++){
		debugger;
		 dat.push([jsonArray[i].serviceName,   jsonArray[i].userEvent]);
	} 
	
   var series= [{
            name:'Action',     
            data: dat
	    }
   ];     
      
   var json = {};   
   json.chart = chart; 
   json.title = title;   
   json.subtitle = subtitle; 
   json.tooltip = tooltip;
   json.xAxis = xAxis;
   json.yAxis = yAxis;  
   json.series = series;
   json.plotOptions = plotOptions;
   json.legend = legend;
   json.credits = credits;
   $('#container').highcharts(json);
  }
});});
</script>

        <body>
        
 <center> <marquee width=60%,behavior="scroll" style="background-color:pink; "><h3 color="green">Welcome to the User tracking  page !!!</h3></marquee>
          <%--  <form action="<%= application.getContextPath() %>/tracking/admin" method="get">
                <table cellspacing="pixels">
                         <tr>
                           <td style="background-color:green"><input type="submit" class="btn btn-info" name="name" value="Clicked_User">
                           
                         
                           
                           
                           </td>
                             <td style="background-color:cyan"><input type="submit" class="btn btn-info" name="name" value="Buyyed_User"></td>
                        </tr> 
                        
                        <div class="container">
                </table> </center>
                
         
                 
                </form>  --%>
               
<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
<%@include file="/UI/common/Footer.jsp"%>
</body>


</html>
