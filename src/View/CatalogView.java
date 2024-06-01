package View;

import Common.AppView;
import Data.Comparators.AppComparator;
import Data.Comparators.PriceComparator;
import Data.Models.Product;
import Data.Services.ShopService;
import java.util.ArrayList;
import java.util.Comparator;

public class CatalogView extends AppView {
    public CatalogView(ShopService shopService, ArrayList<AppView> children, ArrayList<AppComparator<Product>> comparators) {
        super("Каталог", children);
        this.shopService = shopService;
        availableComparators.addAll(comparators);
        if(!availableComparators.isEmpty()){
            selectedComparator = availableComparators.get(0);
        }
    }
    final ShopService shopService;
    @Override
    public void action() {
        PriceComparator comparator = new PriceComparator();
        comparator.isAsc = false;
       ArrayList<Product> catalog =  shopService.getCatalog(nowPage,pageLimit,selectedComparator.comparator);
       hasNextPage = catalog.size()==pageLimit;
       for(Product product: catalog){
           System.out.println(product.id + " " + product.title + " " + product.price);
       }
        System.out.println();
    }
}
