package Data.DataSource.Catalog.Order;
import Data.Models.Order;


public abstract class OrderDataSource {


   public abstract void createOrder(Order order);
   public abstract Order getOrder();


}
