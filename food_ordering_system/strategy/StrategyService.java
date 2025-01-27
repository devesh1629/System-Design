package food_ordering_system.strategy;

import food_ordering_system.models.*;

import java.util.List;

public interface StrategyService {

    public Restaurant selectRestaurant(String itemName, int quantity, List<Restaurant> restaurants);
}
