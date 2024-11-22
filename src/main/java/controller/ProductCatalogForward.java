package controller;

import java.io.IOException;
import java.util.List;

import data.ProductData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;
import model.ShoppingCart;

@WebServlet("/productCatalog")
public class ProductCatalogForward extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> products = ProductData.getProducts();
		req.setAttribute("products", products);
		HttpSession session = req.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		int quantityInCart = (cart != null) ? cart.getNumberOfItems() : 0;

		req.setAttribute("quantity", quantityInCart);
		req.getRequestDispatcher("productCatalog.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
