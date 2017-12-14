
<!-- <!DOCTYPE>
<html>
<head>
<title>CRUD operations using jTable in J2EE</title>
Include one of jTable styles.
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
Include jTable script file.
<script src="./js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="./js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="./js/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#ServiceTableContainer').jtable({
			title : 'Service List',
			actions : {
				listAction : 'service?action=list',
		 		deleteAction : 'service?action=delete',
			  	updateAction :	'service?action=update'	
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
		fname : {
					title : 'Owner Name',
					width : '20%',
					edit : true
				},
				 Email: {
	                    title: 'email',
	                    width: '5%',
	                    sorting: false,
	                    edit: false,
	                    create: false,
	                    display: function (serviceData) {
	                        //Create an image that will be used to open child table
	                        var $img = $('<img src="WebContent/css/metro/blue/email.png" />');
	                        //Open child table when user clicks the image
	                        $img.click(function () {
	                            $('#ServiceTableContainer').jtable('openChildTable',
	                                    $img.closest('tr'),
	                                    {
	                                        title: 'Email',
	                                        actions: {
	                                  listAction: '/Demo/MailList?serviceId=' + serviceData.record.serviceId,
	                            //               listAction:'Controller?action=email' ,
	                                        },
	                                        fields: {
	                                            emailId: {
	                                                type: 'hidden',
	                                                defaultValue: serviceData.record.emailId
	                                            },
	                                           

	                            				email : {
	                            					title : 'Email id',
	                            					width : '30%',
	                            					edit : true
	                            				},
	                                        }
	                                    }, function (data) { //opened handler
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

		<h4>AJAX based CRUD operations using jTable in J2ee</h4>
		<div id="ServiceTableContainer"></div>
	</div>
</body>
</html>



 -->
  <!DOCTYPE>
<html>
<head>
<title>Services Operations</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#ServiceTableContainer').jtable({
			title : 'Service List',
			actions : {
				listAction : 'service?action=list',
		 		deleteAction : 'service?action=delete',
			/* 	updateAction:'service?action=update'
			 */
			//emailAction :'service?action=email'
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
	                         var $img = $("<img src='css/metro/email-black.png' />");
	              	      
	                        //Open child table when user clicks the image
	                        $img.click(function () {
 							     $('#ServiceTableContainer').jtable('openChildTable',
	                                    $img.closest('tr'),
	                                    {
	                                        title: 'Email',
	                                        actions: {
	                                  listAction: 'abc?serviceId=' + serviceData.record.serviceId+'&email='+'abc',
	                                          //listAction:'service?action=email' ,
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
	                                        
	                                    }, function (data) { //opened handler
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
</body>
</html> 