package Data.Models;

public class Product {
     public final String id;
     public final String title;
     public final String description;
     public final int price;
     public final boolean avialable;

    public Product(String id, String title, String description, int price, boolean avialable) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.avialable = avialable;
    }
}
