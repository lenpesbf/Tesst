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
	<c:if test="${quantity != 0}">
		<button type="button" onclick="location.href='cart'">Show
			Cart</button>
		<button type="button" onclick="location.href='checkout'">Check
			Out</button>
	</c:if>
	<h1>CD list</h1>
	<form action="addToCart" method="post">
		<table border="1">
			<tr>
				<th>Description</th>
				<th>Price</th>
				<th></th>
			</tr>
			<!-- Duyệt qua danh sách sản phẩm và hiển thị từng sản phẩm -->
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>
						<button type="submit" name="code" value="${product.code}">Add
							To Cart</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<br>

</body>
</html>