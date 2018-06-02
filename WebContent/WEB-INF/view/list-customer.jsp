<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer List</title>

</head>
<body>
		<div id="wrapper">
		<div id="header">
			<h2>List of Customers</h2>
		</div>
		</div>
	
	<div id="container">
		<div id="content">
		
			
			<!--  add our html table here -->		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Mobile No</th>
					<th>PanCard No</th>
					<th>UID No</th>
					<th>Wallet Money</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td> ${tempCustomer.mobNo} </td>
						<td> ${tempCustomer.panCardNo} </td>
						<td> ${tempCustomer.uidNo} </td>
						<td> ${tempCustomer.wallet.amount} </td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	
</body>
</html>