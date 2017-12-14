<html>
<head>
	<script  src="<%=application.getContextPath() %>/JS/jquery-1.12.3.js"></script>
	<script  src="<%=application.getContextPath() %>/JS/ProductOwnerTotalNotifications.js"></script>
</head>
<body>
	<input type="hidden" id="url" value="<%=request.getContextPath()%>/ProductOwnerTotalNotificationsServlet"/>
	TotalNotifications:<span id="ProductOwnerTotalNotifications"></span> 
	<input type="hidden" id="url" value="<%=request.getContextPath()%>/ProductOwnerTotalNotificationsServlet"/>
	<b id="ProductOwnerTotalNotificationsId"></b><b> Notificatoions</b>	
</body>
</html>