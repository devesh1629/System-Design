package food_ordering_system.models;

import java.util.*;

public class Restaurant {

    String name;
    List<Item> menu;
    int maxCapacity;
    int capacityLeft;

    public Restaurant(String name, List<Item> menu, int maxCapacity) {
        this.name = name;
        this.menu = menu;
        this.maxCapacity = maxCapacity;
        this.capacityLeft = maxCapacity;
    }

    public Restaurant(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.capacityLeft = maxCapacity;
        this.menu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getMenu() {
        return menu;
    }

    public void setMenu(List<Item> menu) {
        this.menu = menu;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCapacityLeft() {
        return capacityLeft;
    }

    public void setCapacityLeft(int capacityLeft) {
        this.capacityLeft = capacityLeft;
    }

    public void addItemToMenu(Item item) {
        this.menu.add(item);
    }
}
