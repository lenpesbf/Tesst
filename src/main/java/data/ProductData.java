package data;

import java.io.*;
import java.util.*;

import model.*;

public class ProductData {
   static List<Product> products = new ArrayList<Product>();
   static {
      products.add(new Product("8601", "86 (the band) - True Life Songs and Pictures", 14.95));
      products.add(new Product("pf01", "Paddlefoot - The first CD", 12.95));
      products.add(new Product("pf02", "Paddlefoot - The second CD", 14.95));
      products.add(new Product("jr01", "Joe Rut - Genuine Wood Grained Finish", 14.95));
   }

   public static Product getProduct(String code) {
      for (Product product : products) {
         if (code.equalsIgnoreCase(product.getCode()))
            return product;
      }
      return null;
   }

   public static List<Product> getProducts() {
      return products;
   }
}