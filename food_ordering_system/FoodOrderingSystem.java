package food_ordering_system;

import food_ordering_system.services.*;

import java.util.HashMap;
import java.util.Map;

public class FoodOrderingSystem {

    public static void main(String[] args) {
        RestaurantService restaurantService = ServiceFactory.getRestaurantService();
        OrderService orderService = ServiceFactory.getOrderService();
        Map<String, Integer> items1 = new HashMap<>();
        items1.put("king_burger", 10);
        items1.put("samosa_pizza", 20);
        items1.put("aloo_pasta", 19);

        restaurantService.addRestaurant("rest1", items1, 15);

        Map<String, Integer> items4 = new HashMap<>();
        items4.put("macaroni", 12);
        items4.put("samosa_pizza", 25);
        items4.put("aloo_pasta", 17);

        restaurantService.addRestaurant("rest2", items4, 12);

        Map<String, Integer> items2 = new HashMap<>();
        items2.put("macaroni", 8);
        items2.put("king_burger", 15);

        restaurantService.updateMenu("rest1",items2);

        restaurantService.printAllRestaurants();
        Map<String, Integer> items3 = new HashMap<>();
        items3.put("macaroni",3);
        items3.put("samosa_pizza", 2);
         orderService.orderFood("cust1", items3);
//
//
         restaurantService.printAllRestaurants();
//
         orderService.printAllOrdersPlaced();

        Map<String, Integer> items6 = new HashMap<>();
        items6.put("aloo_pasta", 3);
        orderService.orderFood("cust2", items6);

        restaurantService.printAllRestaurants();
        orderService.printAllOrdersPlaced();


    }
}
