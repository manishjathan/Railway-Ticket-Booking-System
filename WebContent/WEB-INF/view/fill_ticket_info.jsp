<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form:form action="bookTicket" modelAttribute="customer" method="POST">
			
			<!-- need to associate this data with customer id -->	
			
			<table>
				<tbody>
					<tr>
						<td><label>Customer_id:</label></td>
						<td><form:input path="customer.id" /></td>
					</tr>
					<tr>
						<td><label>Id:</label></td>
						<td><form:input path="id" /></td>
					</tr>
					<tr>
						<td><label>Journey Type:</label></td>
						<td><form:input path="journeyType" /></td>
					</tr>
				
					<tr>
						<td><label>Source:</label></td>
						<td><form:input path="source" /></td>
					</tr>

					<tr>
						<td><label>Destination:</label></td>
						<td><form:input path="destination" /></td>
					</tr>
					
					<tr>
						<td><label>Total Fare:</label></td>
						<td><form:input path="totalFare" /></td>
					</tr>
				
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

					
				</tbody>
			</table>
					
		</form:form>
	

</body>
</html>