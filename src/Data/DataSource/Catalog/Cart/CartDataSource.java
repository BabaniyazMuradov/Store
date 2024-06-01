package Data.DataSource.Catalog.Cart;

import Data.Models.CartItem;
import Data.Models.Product;

import java.util.ArrayList;


public abstract class CartDataSource {


     public abstract void addToCart(Product product, int count);
     public abstract ArrayList<CartItem> getCart();

}
