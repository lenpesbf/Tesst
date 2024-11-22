<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Your cart</h1>
	<table border="1">
		<tr>
			<th>Quantity</th>
			<th>Description</th>
			<th>Price</th>
			<th>SubTotal</th>
			<th></th>
		</tr>
		<!-- Duyệt qua các sản phẩm trong giỏ hàng -->
		<c:forEach var="item" items="${items}">
			<tr>
				<form action="update" method="post">
				<td><input type="number" name="quantity"
					value="${item.quantity}" min="1" />
					<button type="submit" name="code" value="${item.product.code}">Update</button>
				</td>
				</form>
				<td>${item.product.description}</td>
				<td>$${item.product.price}</td>
				<td>${item.getTotalCurrencyFormat()}</td>
				<td>
					<button type="submit" name="remove" value="${item.product.code}">Remove
						Item</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<button type="button" onclick="location.href='productCatalog'">Continue
		Shopping</button>
	<button type="button" onclick="location.href='checkout'">Checkout</button>
</body>
</html>