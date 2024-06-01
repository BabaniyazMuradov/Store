package Data.DataSource.Catalog.Cart;

import Data.Models.CartItem;
import Data.Models.Product;

import java.util.ArrayList;

public class MockCartDataSource extends CartDataSource{
    private ArrayList<CartItem> cart = new ArrayList<>();

    @Override
     public void addToCart(Product product, int count) {
        cart.add(new CartItem(product, count));
    }

    @Override
   public ArrayList<CartItem> getCart() {
        return cart;
    }
}
