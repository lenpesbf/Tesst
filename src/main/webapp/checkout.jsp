<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Cart</title>
</head>
<body>
	<h1>Your cart</h1>
	<table border="1">
		<tr>
			<th>Description</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>SubTotal</th>
		</tr>

		<c:set var="total" value="0" />

		<c:forEach var="item" items="${items}">
			<tr>
				<td>${item.product.description}</td>
				<td>$${item.product.price}</td>
				<td>${item.quantity}</td>
				<td>${item.getTotalCurrencyFormat()}</td>
			</tr>

			<c:set var="total" value="${total + item.getTotal()}" />
		</c:forEach>
	</table>
	<div
		style="display: flex; align-items: flex-start; flex-direction: column;">
		<h5>Total: $${total}</h5>
		<button type="button" onclick="location.href='order'">OK</button>
	</div>
	<br>
</body>
</html>
