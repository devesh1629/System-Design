package bnpl.services;

import bnpl.models.*;
import bnpl.util.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class InventoryService {

    Map<String, Product> inventory = new HashMap<>();
    ConsolePrint print = new ConsolePrint();

//    private static final Logger logger = Logger.getLogger(InventoryService.class.getName());

    public void seedInventory(List<Product> products) {
        for(Product product : products) {
            inventory.put(product.getProductName(), product);
        }
        print.printLog("Inventory added successfully");
    }

    public void viewInventory() {
        for(Product product : inventory.values()) {
            if(product.getQuantity() > 0)
                print.printLog(product.getProductName() + " " + product.getQuantity() + " " + product.getPrice());
        }
    }

    public void addInventory(String productName, int quantity) {
        Product product = getProductByName(productName);
        if(product == null) {
            print.printLog(productName + " does not exist");
            return;
        }
        product.setQuantity(product.getQuantity()+quantity);
        inventory.put(productName,product);
    }

    public void removeInventory(String productName, int quantity) {
        Product product = getProductByName(productName);
        if(product == null) {
            print.printLog(productName + " does not exist");
            return;
        }
        if(product.getQuantity() < quantity) {
            print.printLog("Insufficient quantity");
            return;
        }
        product.setQuantity(product.getQuantity()-quantity);
        inventory.put(productName,product);
    }

    public Product getProductByName(String name) {
        if(inventory.containsKey(name)){
            return inventory.get(name);
        }
        return null;
    }

    public Product createProduct(String name, int quantity, int price) {
        return new Product(name, quantity, price);
    }
}
