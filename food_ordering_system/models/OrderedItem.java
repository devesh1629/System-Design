package food_ordering_system.models;

public class OrderedItem {

    String itemName;
    int quantity;
    int price;
    String restaurantName;

    public OrderedItem(String restaurantName, String name, int quantity, int price) {
        this.itemName = name;
        this.quantity = quantity;
        this.price = price;
        this.restaurantName = restaurantName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
