
		   
<html>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> 
<script src="<%=application.getContextPath()%>/JS/jquery-1.8.2.min.js" type="text/javascript"></script> 
<script src="<%=application.getContextPath()%>/JS/highcharts.js" type="text/javascript"></script>
<script src="<%=application.getContextPath()%>/JS/data.js" type="text/javascript"></script>
<script src="<%=application.getContextPath()%>/JS/drilldown.js" type="text/javascript"></script>
<%--   <script src="<%=application.getContextPath()%>/JS/jquery-1.12.3.js"  type="text/javascript"></script> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assests/bootstrap/css/bootstrap.min.css">
  <script src="<%=application.getContextPath()%>/assests/bootstrap/js/bootstrap.min.js"></script>
<style>
.button {
    background-color: #008CBA;
    color: white;
    padding: 15px 32px;
    text-align:center;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    font-size:16px;
    display:inline-block;
}
</style>
<body>
          <%@ include file="/UI/ProductOwner/Product_Owner_Header.jsp"%>  

 	<div style="text-align: center;">
 <input type="button" name="n" value="Clicked_User" id="s" class="button" >
 </div>
<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
<script>

	
	$(document).ready(function() {
		 var series=[];
		 $('#s').click(function(){ 
			 $(this).hide();
			var btn=$('#s').val();
			//alert(btn+"....btn");
	
	$.ajax({
			type: 'POST',
			url: '<%=application.getContextPath()%>/clicktracking?pid='+btn,
			dataType:'json',
			success: function(js) {
				 
		 		 var agentJson = js;
		 		 
		 		 
		 // alert(js);
	
  
			 var dat1=[];
			 var dat2=[];
			 var dat3=[];
			 var dat4=[];
			 for( var i=0; i<agentJson.length ;i++){

						if(i==0){
					 dat1.push(agentJson[i].productownername);
				 dat2.push(agentJson[i].operationtypeproductcount);
			 }else{
				 dat3.push(agentJson[i].servicename);
				 dat4.push(agentJson[i].operationtypeservicecount);
			 }	 
			 }
			//alert(dat1+">>"+dat2+">>"+dat3+">>"+dat4);
	
			//Designing Chart
			 var chart = {
			            type: 'column'
			         };
			         var title = {
			            text: 'Track Of User Click'   
			         };    
			         var subtitle = {
			            text: 'Click the columns to view Services and No Of Views Based On Services'
			         };
			         var xAxis = {
			            type: 'category'      
			         };
			         var yAxis ={
			            title: {
			              text: 'Total No of Views'
			            }
			         };  
			          
			       
			            //Dynamic Drill Down Data
			             var ddData =[];
			             $.each(dat3, function (ind,obj) {
			             
			            	  
					                  ddData.push( [
					                         dat3[ind],
					                         dat4[ind]
					                     ]);
		
			             });
			         
			             // Create the main data
			        var  series = [{
			             name: 'Product Owners Names',
			             colorByPoint: true,
			             data: [{
			                 name:  dat1[0],
			                 y: dat2[0],
			                 drilldown:dat1[0] 
			             }]
			         }];
			        /*  console.log(  dat3[0]+" >>>>>>> "+dat4[0]); */
			         
			        // Create the DrillDown data
			        var drilldown = {
			             series:[{
			                 name: dat1[0],
			                 id: dat1[0],
							data:ddData			             			      
						 }]
			     
			        
			         }
			        
			         var json = {};   
			         json.chart = chart; 
			         json.title = title;   
			         json.subtitle = subtitle;
			         json.xAxis = xAxis;
			         json.yAxis = yAxis;   
			        
			         json.series = series;
			        json.drilldown = drilldown;
			         $('#container').highcharts(json);
			 
			            },
			 
			              error:function(){
			            	debugger;
			            	  
			              alert("PLEASE TRY LATER");
			              }

			        
			});
	});
			});
	
</script>
<!-- <centre> -->
<!--                <table> -->
<!--                         <tr> -->
<!--                            <td style="background-color:green"><input type="button" name="n" value="Clicked_User" id="s"></td> -->
<!--                         </tr> -->
<!--                 </table>  -->
<!--                 </centre> -->

       <%@ include file="/UI/common/Footer.jsp"%>  
           
       </body>
       
       
       
       
    </html>  
       
       
       
 
	

