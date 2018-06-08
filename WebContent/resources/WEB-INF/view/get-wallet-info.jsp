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
	
	<form:form action="updateCustomer" modelAttribute="customer" method="POST">
			
			<!-- need to associate this data with customer id -->	
			
			
			<table>
				<tbody>
					<tr>
						<td><form:hidden path="id" /></td>
					</tr>
					<tr>
						<td><form:hidden path="firstName" /></td>
					</tr>
				
					<tr>
						<td><form:hidden path="lastName" /></td>
					</tr>

					<tr>
						<td><form:hidden path="email" /></td>
					</tr>
					
					<tr>
						<td><form:hidden path="address" /></td>
					</tr>
				
					<tr>
						<td><form:hidden path="mobNo" /></td>
					</tr>

					<tr>
						<td><form:hidden path="panCardNo" /></td>
					</tr>
					
					<tr>
						<td><form:hidden path="uidNo" /></td>
					</tr>
					<tr>
						<td><label>Wallet Id:</label></td>
						<td><form:input path="wallet.id" /></td>
					</tr>
					<tr>
						<td><label>Wallet Amount:</label></td>
						<td><form:input path="wallet.amount" /></td>
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