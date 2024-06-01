package View;

import Common.AppView;
import Data.Models.CartItem;
import Data.Models.Product;
import Data.Services.ShopService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    public OrderView(ShopService shopService) {
        super("Оформление заказа", new ArrayList<>());
        this.shopService = shopService;
    }
    final ShopService shopService;
    @Override
    public void action() {
        ArrayList<CartItem> cart = shopService.getCart();
        if(cart.isEmpty()){
            System.out.println("Невозможно оформить заказ, корзина пуста !");
        } else {
            Scanner scn = new Scanner(System.in);
            System.out.println("Введите свое имя");
            String name = scn.nextLine();
            System.out.println("Введите свой телефон");
            String phone = scn.nextLine();
            shopService.createOrder(name, phone, "adress", "cash", "утро");
        }

    }
}
