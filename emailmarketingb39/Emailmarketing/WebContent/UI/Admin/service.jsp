<!DOCTYPE>
<%@include file="/UI/Admin/Admin_Header.jsp" %>
 <html>
<head>
<title>Services Operations</title>
<!-- Include one of jTable styles. -->
<link href="<%=application.getContextPath()%>/CSS/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="<%=application.getContextPath()%>/CSS/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="<%=application.getContextPath()%>/JS/jquery-1.8.2.js" type="text/javascript"></script>
<script src="<%=application.getContextPath()%>/JS/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="<%=application.getContextPath()%>/JS/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#ServiceTableContainer').jtable({
			title : 'Service List',
			actions : {
				listAction : '<%=request.getContextPath()%>/service?action=list',
		 		deleteAction : '<%=request.getContextPath()%>/service?action=delete',
	 		},
			fields : {
				serviceId : {
					title : 'Service Id',
					width : '30%',
					key : true,
					list : true,
					edit : false,
					create : true
				},
				serviceName : {
					title : 'Service Name',
					width : '30%',
					edit : true
				},
				serviceDate : {
					title : 'Service Date',
					width : '30%',
					edit : true
				},
				
				 Email: {
	                    
	                    width: '5%',
	                    sorting: false,
	                    edit: false,
	                    create: false, 
	                      display: function (serviceData) {
	                        //Create an image that will be used to open child table
	                         var $img =$('<img src="email-black.png"/>');
	                         
	                        //Open child table when user clicks the image
	                        $img.click(function () {
 							     $('#ServiceTableContainer').jtable('openChildTable',
	                                    $img.closest('tr'),
	                                    {
	                                        title: 'Email',
	                                        actions: {
	                                  listAction: '<%=request.getContextPath()%>/abc?serviceId=' + serviceData.record.serviceId+'&email='+'abc',
	                                         },
	                                        fields: {
	                                            emailId: {
	                                                type: 'hidden',
	                                                defaultValue: serviceData.record.emailId
	                                            },
	                                     	                            				emails : {
	                            					title : 'Email id',
	                            					width : '30%',
	                            					edit : true
	                            				},
 	                                        }
 	                                    }, 
 	                                    function (data) { //opened handler
	                                        data.childTable.jtable('load');
	                                    });
	                        });
	                        //Return image to show on the person row
	                        return $img;
	                    }
	                },
	         	}
	 	});
		$('#ServiceTableContainer').jtable('load');
	});
</script>
</head>
<body>
<div style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
 		<h4>Services details</h4>
		<div id="ServiceTableContainer"></div>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<%@include file="/UI/common/Footer.jsp" %>
</body>

</html> 

