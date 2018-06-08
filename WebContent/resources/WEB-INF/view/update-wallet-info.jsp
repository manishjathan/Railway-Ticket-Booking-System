<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ID : ${customer.id}
<br>
Customer : ${customer.firstName} ${customer.lastName}
<br>
Address : ${customer.address}
<br>
MobNo : ${customer.mobNo}
<br>
<!-- Wallet : ${customer.wallet} -->

<url var = "updateWallet" value = "/customer/updateWallet">
<param name="customerId" value="${customer.id}"/>
</url>
<a href="${updateWallet}">Update Wallet</a>

</body>
</html>