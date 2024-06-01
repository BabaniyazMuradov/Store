package Common;

import Data.Comparators.AppComparator;
import Data.Models.Product;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class AppView {
    public final String title;
    public final ArrayList<AppView> children;
    public  int nowPage = 0;
    public final int pageLimit = 5;
    public boolean hasNextPage = false;
    public AppComparator<Product> selectedComparator;
    public final ArrayList<AppComparator<Product>> availableComparators = new ArrayList<>();


    protected AppView(String title, ArrayList<AppView> children) {
        this.title = title;
        this.children = children;
    }

    public void action(){

    };
}
