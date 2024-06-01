package Data.Services;

import Data.DataSource.Catalog.Cart.CartDataSource;
import Data.DataSource.Catalog.CatalogDataSource;
import Data.DataSource.Catalog.Order.OrderDataSource;
import Data.Models.CartItem;
import Data.Models.Order;
import Data.Models.Product;

import java.util.ArrayList;
import java.util.Comparator;

public class ShopService {
    final CatalogDataSource catalogDataSource;
    final CartDataSource cartDataSource;
    final OrderDataSource orderDataSource;


    public ShopService(CatalogDataSource catalogDataSource, CartDataSource cartDataSource, OrderDataSource orderDataSource) {
        this.catalogDataSource = catalogDataSource;
        this.cartDataSource = cartDataSource;
        this.orderDataSource = orderDataSource;
    }

    public ArrayList<Product> getCatalog(int page,int limit){
        return catalogDataSource.getCatalog(page,limit);
    }

    public ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator){
        return catalogDataSource.getCatalog(page,limit,comparator);
    }

   public boolean addToCart(String productId, int count){
       Product product = catalogDataSource.productById(productId);
           if(product != null){
               cartDataSource.addToCart(product, count);
               return true;
           }
       return false;
   }

   public ArrayList<CartItem> getCart(){
       return cartDataSource.getCart();
   }

   public void createOrder(String name, String phone, String address, String paymentType, String deliveryType){
        ArrayList<CartItem> cart = getCart();
        Order newOrder = new Order(name, phone, address,paymentType, deliveryType,cart);
        orderDataSource.createOrder(newOrder);
   }
}
