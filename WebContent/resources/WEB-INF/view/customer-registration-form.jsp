<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration Form</title>
</head>
<body>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			
			<!-- need to associate this data with customer id -->	
			
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					
					<tr>
						<td><label>Address:</label></td>
						<td><form:input path="address" /></td>
					</tr>
				
					<tr>
						<td><label>Mob No:</label></td>
						<td><form:input path="mobNo" /></td>
					</tr>

					<tr>
						<td><label>Pan Card No:</label></td>
						<td><form:input path="panCardNo" /></td>
					</tr>
					
					<tr>
						<td><label>UID No:</label></td>
						<td><form:input path="uidNo" /></td>
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