package model;

import java.io.Serializable;
import java.text.NumberFormat;

public class ShoppingCartItem implements Serializable {

   private Product product;
   private int quantity;

   public ShoppingCartItem() {
   }

   public ShoppingCartItem(Product product, int quantity) {
      this.product = product;
      this.quantity = quantity;
   }

   public ShoppingCartItem(Product product) {
      this(product, 1);
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   public Product getProduct() {
      return product;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public int getQuantity() {
      return quantity;
   }

   public void incrementQuantity() {
      quantity++;
   }
   public double getTotal() {
      return product.getPrice() * quantity;
   }

   public String getTotalCurrencyFormat() {
      NumberFormat currency = NumberFormat.getCurrencyInstance();
      return currency.format(this.getTotal());
   }
}