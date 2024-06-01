package Data.DataSource.Catalog;

import Data.Models.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class MockCatalogDataSource extends CatalogDataSource {
    @Override
    public ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator) {
        ArrayList<Product>products = generateProducts();
        Stream<Product> productStream = products.stream().filter(p->p.avialable).sorted(comparator).skip((long) page *limit).limit(limit);
        return new ArrayList<>(productStream.toList());
    }

    @Override
    public ArrayList<Product> getCatalog(int page, int limit) {
        ArrayList<Product>products = generateProducts();
        // пагинация
        Stream<Product> productStream = products.stream().filter(p->p.avialable).skip((long) page *limit).limit(limit);
        return new ArrayList<>(productStream.toList());
    }

    @Override
    public Product productById(String id) {
        ArrayList<Product> products = getCatalog(0,999999);
        for (Product p:products) {
            if(p.id.equals(id)){
                return p;
            }
        }
        return null;
    }
    ArrayList<Product> generateProducts(){
        ArrayList<Product>products = new ArrayList<>();
        //добавление
        products.add(new Product("id1","SmartPhone","Best Phone",1000,true));
        products.add(new Product("id2","Laptop","Some Laptop",2000,true));
        products.add(new Product("id3","Watch","Best Watch",500,true));
        products.add(new Product("id4","Phone","Simple Phone",100,true));
        for (int i = 0; i < 20; i++) {
            products.add(new Product("id"+(i+5),"IPhone-"+i,"Simple Phone",100+i*100,i%4 !=0));

        }
        return products;
    }

}
