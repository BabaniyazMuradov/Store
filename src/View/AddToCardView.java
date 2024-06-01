package View;

import Common.AppView;
import Data.Services.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class AddToCardView extends AppView {
    public AddToCardView(ShopService shopService) {
        super("Добавить товар", new ArrayList<>());
        this.shopService = shopService;
    }
    final ShopService shopService;

    @Override
    public void action() {
        Scanner scn  = new Scanner(System.in);
        System.out.println("Ввудите id продукта ");
        String productId = scn.nextLine();
        if(productId == null){
            return;
        }
        System.out.println("Ввудите количество ");
        int count = scn.nextInt();
       final boolean res =  shopService.addToCart(productId,count);
       if(res){
           System.out.println("Товар добавлен");
       } else {
           System.out.println("Не удалось ддобавить товар");
       }
    }
}
