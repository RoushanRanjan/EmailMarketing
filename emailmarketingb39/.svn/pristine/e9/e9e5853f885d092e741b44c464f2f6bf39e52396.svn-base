<%-- <%@page import="org.apache.catalina.core.ApplicationContext"%>
 --%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ProductOwnerNotifications</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assests/bootstrap/css/bootstrap.min.css">
  <script src="<%=application.getContextPath()%>/JS/jquery-1.12.3.js"></script>
  <script src="<%=application.getContextPath()%>/assests/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
</style>
</head>
<body>
<br>
<div class="bs-example">
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Click</a>
                </h4>
            </div>
            <div id="collapseOne" class="accordion-body collapse">
                <div class="panel-body">
                	<div class="bs-example">
                	  	<c:choose>
                	  		<c:when test="${clickList ne null}">
             	  				 <table class="table" border="1" align="center"  style="border: #000000 solid 2px; padding:5px;">
							        <thead><tr><th>ProductName</th><th>Date</th><th>MailId</th></tr></thead>
    	            	  			<c:forEach items="${clickList}" var="item">
							        <tbody>
							        	<tr class="active">
											<td>${item.getProductName()}</td>
											<td>${item.getProductRegisteredDate()}</td>
											<td>${item.getMailId()}</td>
								            </tr>
								        </tbody>
			        	  			</c:forEach>
        					    </table>
                	  		</c:when>
                	  		<c:otherwise>
							<tr><td>No New Notifications</td></tr>
							</c:otherwise>
						</c:choose>
					</div>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Buy</a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <div class="panel-body">
                	  	<c:choose>
                	  		<c:when test="${buyList ne null}">
             	  				 <table class="table" border="1" align="center"  style="border: #000000 solid 2px; padding:5px;">
							        <thead><tr><th>ProductName</th><th>ProductOrderedDate</th><th>FullName</th><th>ContactNumber</th><th>MailId</th><th>Address</th></tr></thead>
    	            	  			<c:forEach items="${buyList}" var="item">
							        <tbody>
							        	<tr class="active">
											<td>${item.getProductName()}</td>
											<td>${item.getProductRegisteredDate()}</td>
											<td>${item.getFullName()}</td>
											<td>${item.getContactNumber()}</td>
											<td>${item.getMailId()}</td>
											<td>${item.getAddress()}</td>
								            </tr>
								        </tbody>
			        	  			</c:forEach>
        					    </table>
                	  		</c:when>
                	  		<c:otherwise>
							<tr><td>No New Notifications</td></tr>
							</c:otherwise>
						</c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>                                		                                		