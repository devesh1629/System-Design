package food_ordering_system.services;


import food_ordering_system.strategy.*;

public class ServiceFactory {

    private static OrderService orderService;
    private static RestaurantService restaurantService;
    private static LowestPriceSelectionStrategy lowestPriceSelectionStrategy;

    public static OrderService getOrderService() {
        if(orderService == null)
            orderService = new OrderService();
        return orderService;
    }

    public static RestaurantService getRestaurantService() {
        if(restaurantService == null)
            restaurantService = new RestaurantService();
        return restaurantService;
    }

    public static LowestPriceSelectionStrategy getLowestPriceSelectionStrategy() {
        if(lowestPriceSelectionStrategy == null)
            lowestPriceSelectionStrategy = new LowestPriceSelectionStrategy();
        return lowestPriceSelectionStrategy;
    }

}
