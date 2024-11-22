package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ShoppingCart;
import model.ShoppingCartItem;

@WebServlet("/cart")
public class CartController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ShoppingCart cart = null;
		if (session.getAttribute("cart") != null) {
			cart = (ShoppingCart) session.getAttribute("cart");
		} else {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}

		List<ShoppingCartItem> items = cart.getItems();
		req.setAttribute("items", items);
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
