package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart implements Serializable {
	private Map<String, ShoppingCartItem> items = null;

	public ShoppingCart() {
		items = new HashMap<String, ShoppingCartItem>();
	}

	public int getCount() {
		return items.size();
	}

	public void addItem(Product product) {
		String code = product.getCode();
		if (items.containsKey(code)) {
			ShoppingCartItem scitem = (ShoppingCartItem) items.get(code);
			scitem.incrementQuantity();
			;
		} else {
			ShoppingCartItem newItem = new ShoppingCartItem(product, 1);
			items.put(code, newItem);
		}
	}

	public void addItem(Product product, int quantity) {
		String code = product.getCode();
		if (items.containsKey(code)) {
			ShoppingCartItem scitem = (ShoppingCartItem) items.get(code);
			scitem.setQuantity(quantity);
		} else {
			ShoppingCartItem newItem = new ShoppingCartItem(product, quantity);
			items.put(code, newItem);
		}
	}

	public void remove(String code) {
		items.remove(code);
	}

	public List<ShoppingCartItem> getItems() {
		List<ShoppingCartItem> results = new ArrayList<ShoppingCartItem>();
		results.addAll(this.items.values());
		return results;
	}

	public int getNumberOfItems() {
		int numberOfItems = 0;
		for (ShoppingCartItem scitem : items.values()) {
			numberOfItems += scitem.getQuantity();
		}
		System.out.println("Number Of Items in cart is " + numberOfItems);
		return numberOfItems;
	}

	public double getTotal() {
		double amount = 0.0;
		for (ShoppingCartItem scitem : items.values()) {
			amount += scitem.getTotal();
		}
		return roundOff(amount);
	}

	private double roundOff(double x) {
		long val = Math.round(x * 100); // cents
		return val / 100.0;
	}

	public void clear() {
		System.out.println("Clearing cart.");
		items.clear();
	}
}
