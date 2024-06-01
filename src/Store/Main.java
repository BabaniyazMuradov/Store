package Store;

import Common.AppView;
import Common.PageLoop;
import Data.Comparators.AppComparator;
import Data.Comparators.PriceComparator;
import Data.DataSource.Catalog.Cart.CartDataSource;
import Data.DataSource.Catalog.Cart.MockCartDataSource;
import Data.DataSource.Catalog.CatalogDataSource;
import Data.DataSource.Catalog.MockCatalogDataSource;
import Data.DataSource.Catalog.Order.MockOrderDataSource;
import Data.DataSource.Catalog.Order.OrderDataSource;
import Data.Models.Product;
import Data.Services.ShopService;
import View.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CartDataSource cartDataSource = new MockCartDataSource();
        CatalogDataSource catalogDataSource = new MockCatalogDataSource();
        OrderDataSource orderDataSource = new MockOrderDataSource();
        ShopService shopService = new ShopService(catalogDataSource,cartDataSource,orderDataSource);

        AppView addToCartView = new AddToCardView(shopService);

        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);
        ArrayList<AppComparator<Product>> catalogComparators = new ArrayList<>();
        catalogComparators.add(new AppComparator<>(new PriceComparator(true),"по возрастанию цены"));
        catalogComparators.add(new AppComparator<>(new PriceComparator(false),"по убыванию цены"));
        AppView catalogView = new CatalogView(shopService, catalogChildren,catalogComparators);

        AppView cartView = new CartView(shopService);
        AppView orderView = new OrderView(shopService);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);
        AppView mainView = new MainView(mainChildren);

        new PageLoop(mainView).run();

    }
}
