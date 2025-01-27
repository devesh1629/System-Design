package food_ordering_system.services;

import food_ordering_system.models.*;
import food_ordering_system.strategy.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    Map<String, Order> orders = new HashMap<>();

    static int index = 1;

    RestaurantService restaurantService = ServiceFactory.getRestaurantService();

//    LowestPriceSelectionStrategy lowestPriceSelectionStrategy = ServiceFactory.getLowestPriceSelectionStrategy();

    StrategyService strategyService = new LowestPriceSelectionStrategy();

    public String orderFood(String customerName, Map<String, Integer> items) {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();

        List<OrderedItem> itemsOrderedFromRestaurants = new ArrayList<>();
        int orderAmount = 0;

        for(Map.Entry<String, Integer> entry : items.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            Restaurant selectedRestaurant = strategyService.selectRestaurant(itemName, quantity, restaurants);

            if(selectedRestaurant == null) {
                orderAmount = -1;
                break;
            }
            int itemCost = restaurantService.getAmountFromItem(selectedRestaurant, itemName);;
            OrderedItem orderedItem = new OrderedItem(selectedRestaurant.getName(), itemName, quantity, itemCost);
            itemsOrderedFromRestaurants.add(orderedItem);
            orderAmount += itemCost * quantity;

        }
        if(orderAmount == -1) {
            System.out.println("Order cannot be full filled");
            return "Order cannot be full filled";
        }
        Order order = new Order("order"+index, orderAmount, customerName);
        for(OrderedItem orderedItem : itemsOrderedFromRestaurants) {
            restaurantService.updateRestaurantWithOrder(orderedItem.getRestaurantName(), orderedItem.getQuantity());
            order.addFoodOrderedPerRestaurant(orderedItem);;
        }
        orders.put(order.getOrderId(), order);
        index++;
        System.out.println("Ordered with id: " + order.getOrderId());
        return order.getOrderId();

    }

    public void printAllOrdersPlaced() {
//        System.out.println("[");
        for(Map.Entry<String, Order> entry : orders.entrySet()) {
            Order order = entry.getValue();

            System.out.print("{ order_id: " + entry.getKey() + ", ");
            System.out.print("user: " + order.getCustomerName() + ", ");
            System.out.print("order_details: [");
            for(OrderedItem orderedItem : order.getFoodOrderedPerRestaurant()) {
                String restaurantName = orderedItem.getRestaurantName();
                System.out.print(" { restaurant: " + restaurantName + ", items: {");
                System.out.print(orderedItem.getItemName() + " ,");
                System.out.print(orderedItem.getQuantity() + " } ");
            }
            System.out.print("cost: " + order.getTotalAmount() + "\n");

        }
    }
}

/*
[{ ‘order_id’: ‘order1’, ‘user’: ‘cust1’, ‘order_details’: [ {‘restaurant’: ‘resta1’, ‘items’:
{‘bendi_macaroni’: 3, ‘samosa_pizza’: 2’}, ‘cost’: 64}] }]

 */
