<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>AJAX JsonArray Example</title>
<link href='http://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>
<style type="text/css">
table, td, th {
	border: 1px solid green;
	font-family: 'Oxygen', sans-serif;
}

th {
	background-color: green;
	color: white;
}

body {
	 text-align: center;
}

.container {
	 margin-left: auto;
	 margin-right: auto;
	 width: 40em;
}
</style>

<title>Insert title here</title>
<script
	src="<%=application.getContextPath()%>/assests/js/jquery-1.11.1.js"></script>
<script
	src="<%=application.getContextPath()%>/assests/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/assests/js/jquery.dataTables.bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#tablediv").hide();
		$("#showTable").click(function(event) {
			$.get('CartData', function(responseJson) {
				if (responseJson != null) {

					$("#countrytable").find("tr:gt(0)").remove();
					var table1 = $("#countrytable");
					$.each(responseJson, function(key, value) {
						var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td></tr>");
						rowNew.children().eq(0).text(value['productName']);
						rowNew.children().eq(1).text(value['productType']);
						rowNew.children().eq(2).text(value['price']);
						rowNew.children().eq(3).html("<img src="+value['image']+">");
						rowNew.children().eq(4).html("<button operationid='"+value['operationid']+"'>BUY</button>");
						rowNew.appendTo(table1);
					});
					$("[operationid]").click(function(){
						var operationId = $(this).attr("operationid");
						
						//alert(operationid);
						
						$.ajax({
							"url":"<%=request.getContextPath()%>/BuyUpdate?operationid="+ operationId,
							"success" : function(output) {
										//location.reload(true);
							$("#buy").html(output);

																									}

																								});

																						return false;
																						//	window.location.assign("abc?pid="+pId);
																					});
																}
															});
											$("#tablediv").show();
											$('#countrytable').DataTable();
										});

					});
</script>
</head>
<body class="container" bgcolor="#B833FF">
	<CENTER>
		<h1>
			<B>PRODUCT DETAILS</B>
		</h1>
		<table align="center" border="1">
			<tr>
				<th>productName</th>
				<th>productPrice</th>
				<th>productType</th>
				<th>productQuantity</th>
			</tr>
			<tr>
				<td>${DTO.productName}</td>
				<td>${DTO.productPrice}</td>
				<td>${DTO.productType}</td>
				<td>${DTO.quantity}</td>
				<%-- <td>${DTO.quantity}</td> --%>

			</tr>
		</table>
		<img src="${DTO.image}">
		<div id="buy"></div>
		<form action="<%=application.getContextPath()%>/servlet2">
			<input type="submit" class="btn btn-info" value="ADD_CART"
				name="action"> <input type="submit" class="btn btn-info"
				value="BUY_PRODUCT" name="action"> <input type="submit"
				class="btn btn-info" value="CHECK_CART" name="action"> <input
				type="button" class="btn btn-info" value="CartData" id="showTable" />

		</form>
		<div id="tablediv">
			<table cellspacing="0" align="center" border="1" id="countrytable">

				<thead>
					<tr>
						<th scope="col">ProductName</th>
						<th scope="col">ProductType</th>
						<th scope="col">Price</th>
						<th scope="col">Product-Image</th>
						<th scope="col">Buy</th>
						<!-- <th scope="col"></th> -->
					</tr>
				</thead>

			</table>
		</div>
	</CENTER>
</body>
</html>