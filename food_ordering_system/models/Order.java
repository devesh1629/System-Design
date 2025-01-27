package food_ordering_system.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {

    String orderId;
    List<OrderedItem> foodOrderedPerRestaurant;
    int totalAmount;
    String customerName;

    public Order(String orderId, int totalAmount, String customerName) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.customerName = customerName;
        this.foodOrderedPerRestaurant = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderedItem> getFoodOrderedPerRestaurant() {
        return foodOrderedPerRestaurant;
    }

    public void setFoodOrderedPerRestaurant(List<OrderedItem> foodOrderedPerRestaurant) {
        this.foodOrderedPerRestaurant = foodOrderedPerRestaurant;
    }

    public void addFoodOrderedPerRestaurant(OrderedItem orderedItem) {
        this.foodOrderedPerRestaurant.add(orderedItem);
    }
}
