package food_ordering_system.services;

import food_ordering_system.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantService {

    Map<String, Restaurant> restaurants = new HashMap<>();

    public void addRestaurant(String name, Map<String, Integer> items,  int maxCapacity) {
        Restaurant restaurant = new Restaurant(name, maxCapacity);

        for(Map.Entry<String, Integer> entry : items.entrySet()) {
            Item item = new Item(entry.getKey(), entry.getValue());
            restaurant.addItemToMenu(item);
        }
        restaurants.put(name, restaurant);
        System.out.println("Restaurant added successfully");
    }

    public void updateMenu(String name, Map<String, Integer> items) {
        Restaurant restaurant = getRestaurantByName(name);
        if(restaurant == null) {
            System.out.println(name + " is not a valid restaurant");
            return;
        }
        for(Map.Entry<String, Integer> entry : items.entrySet()) {
            Item item = getItemByName(restaurant, entry.getKey());
            if(item == null) {
                Item newItem = new Item(entry.getKey(), entry.getValue());
                restaurant.addItemToMenu(newItem);
            }
            else {
                item.setPrice(entry.getValue());
            }
        }
        System.out.println("Restaurant updated successfully");
    }

    public Item getItemByName(Restaurant restaurant, String foodName) {
        List<Item> menu = restaurant.getMenu();
        for(Item item : menu) {
            if(item.getFoodName().equalsIgnoreCase(foodName))
                return item;
        }
        return null;
    }

    public Restaurant getRestaurantByName(String name) {
        if(restaurants.containsKey(name))
            return restaurants.get(name);
        return null;
    }

    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurants.values());
    }

    public int getAmountFromItem(Restaurant restaurant, String itemName) {
        for(Item item : restaurant.getMenu()) {
            if(item.getFoodName().equalsIgnoreCase(itemName))
                return item.getPrice();
        }
        return -1;
    }

    public void updateRestaurantWithOrder(String restaurantName, int capacityUsed) {
        Restaurant restaurant = restaurants.get(restaurantName);
        restaurant.setCapacityLeft(restaurant.getCapacityLeft() - capacityUsed);
    }

    public void printAllRestaurants() {
        for(Restaurant restaurant : restaurants.values()) {
            System.out.print("{ name: " + restaurant.getName() + ", menu: { ");
            for(Item item : restaurant.getMenu()) {
                System.out.print(item.getFoodName() + " : " + item.getPrice() + ", ");
            }
            System.out.print( "}, total_capacity: " + restaurant.getMaxCapacity() + ", capacityUsed: " + (restaurant.getMaxCapacity()-restaurant.getCapacityLeft()) + " }\n");

        }
    }
}
