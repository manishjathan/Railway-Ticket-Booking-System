<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	ID : ${customer.id}
	<br> Customer : ${customer.firstName} ${customer.lastName}
	<br> Address : ${customer.address}
	<br> MobNo : ${customer.mobNo}
	<br>

	<c:url var="updateLink" value="/customer/getWallet">
		<c:param name="customerId" value="${customer.id}" />
	</c:url>
	<a href="${updateLink}">Update Wallet</a>

</body>
</html>