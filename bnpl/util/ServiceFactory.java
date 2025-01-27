package util;

import services.DueService;
import services.InventoryService;
import services.OrderService;
import services.UserService;

public class ServiceFactory {

    private static InventoryService inventoryService;
    private static OrderService orderService;
    private static UserService userService;
    private static DueService dueService;

    public static InventoryService getInventoryService() {
        if(inventoryService == null)
            inventoryService = new InventoryService();
        return inventoryService;
    }

    public static OrderService getOrderService() {
        if(orderService == null)
            orderService = new OrderService();
        return orderService;
    }

    public static UserService getUserService() {
        if(userService == null)
            userService = new UserService();
        return userService;
    }

    public static DueService getDueService() {
        if(dueService == null)
            dueService = new DueService();
        return dueService;
    }
}
