package View;

import Common.AppView;
import Data.Models.CartItem;
import Data.Models.Product;
import Data.Services.ShopService;

import java.util.ArrayList;

public class CartView extends AppView {
    public CartView(ShopService shopService) {
        super("Корзина", new ArrayList<>());
        this.shopService = shopService;
    }
    final ShopService shopService;
    @Override
    public void action() {
       ArrayList<CartItem> cart =  shopService.getCart();
        if(cart.isEmpty()){
            System.out.println("Корзина пуста! ");
        }
       for(CartItem cartItem: cart){
           System.out.println(cartItem.product.id  + " " + cartItem.product.title + " " + cartItem.count);
       }
        System.out.println();
    }
}
