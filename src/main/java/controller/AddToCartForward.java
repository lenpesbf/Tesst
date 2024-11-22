package controller;

import java.io.IOException;

import data.ProductData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;
import model.ShoppingCart;

@WebServlet("/addToCart")
public class AddToCartForward extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		HttpSession session = req.getSession();
		ShoppingCart cart = null;
		if (session.getAttribute("cart") != null) {
			cart = (ShoppingCart) session.getAttribute("cart");
		} else {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}

		Product product = ProductData.getProduct(code);

		cart.addItem(product);

		resp.sendRedirect("productCatalog");
	}
}
