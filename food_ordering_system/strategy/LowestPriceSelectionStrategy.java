package food_ordering_system.strategy;

import food_ordering_system.models.*;
import food_ordering_system.services.*;

import java.util.List;

public class LowestPriceSelectionStrategy implements StrategyService {

    private final RestaurantService restaurantService = ServiceFactory.getRestaurantService();

    @Override
    public Restaurant selectRestaurant(String itemName, int quantity, List<Restaurant> restaurants) {
        System.out.println(restaurants.size());
        Restaurant selectedRestaurant = null;
        int minCost = Integer.MAX_VALUE;

        for(Restaurant restaurant : restaurants) {
            Item item = restaurantService.getItemByName(restaurant, itemName);
            if(item == null)
                continue;
            int cost = item.getPrice();
            if(cost < minCost && restaurant.getCapacityLeft() >= quantity) {
                minCost = cost;
                selectedRestaurant = restaurant;
            }
        }
        return selectedRestaurant;
    }
}
