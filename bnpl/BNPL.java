import models.PaymentMethod;
import models.Product;
import models.User;
import services.DueService;
import services.InventoryService;
import services.OrderService;
import util.ServiceFactory;
import services.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BNPL {

    public static void main(String[] args) {

        InventoryService inventoryService = ServiceFactory.getInventoryService();
        UserService userService = ServiceFactory.getUserService();
        OrderService orderService = ServiceFactory.getOrderService();
        DueService dueService = ServiceFactory.getDueService();


        Product product1 = new Product(1, "Shoes", 5, 200);
        Product product2 = new Product(2, "Watch", 10, 1000);
        Product product3 = new Product(3, "Shirt", 15, 2000);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        inventoryService.seedInventory(products);
        inventoryService.viewInventory();

        userService.registerUser("Akshay", 5000);
        userService.registerUser("Jack", 10000);

        Map<String, Integer> order1 = new HashMap<>();
        order1.put("Shoes", 2);
        order1.put("Watch", 1);

        orderService.buy("Akshay", order1, PaymentMethod.BNPL, "05/11/2024");

        inventoryService.viewInventory();
        orderService.orderStatus("Akshay");

        List<Integer> orders = new ArrayList<>();
        orders.add(1);
        orders.add(2);
        dueService.viewDues("Akshay", "08/12/2024");
        dueService.clearDues("Akshay", orders,  "25/11/2024");

        dueService.viewDues("Akshay", "26/11/2024");
//        orderService.orderStatus("Akshay");


    }
}
