package services;

import models.Order;
import models.PaymentMethod;
import models.Product;
import models.User;
import util.ConsolePrint;
import util.DateConverter;
import util.ServiceFactory;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class OrderService {

    Map<Integer, Order> orderMap = new HashMap<>();
    UserService userService = ServiceFactory.getUserService();
    InventoryService inventoryService = ServiceFactory.getInventoryService();

    ConsolePrint print = new ConsolePrint();
    DateConverter dateConverter = new DateConverter();

    static int index = 1;

    public void buy(String userName, Map<String, Integer> products, PaymentMethod paymentMethod, String date) {

        User user = userService.getUserByName(userName);
        if(user == null) {
            print.printLog(userName + " is not a resigtered user");
            return;
        }
        for(Map.Entry<String, Integer> entry : products.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            Product product = inventoryService.getProductByName(productName);
            if(product.getQuantity() < quantity) {
                print.printLog("Insufficient quantity for " + productName);
                return;
            }
            Integer orderAmount = product.getPrice() * quantity;
            if(paymentMethod.equals(PaymentMethod.BNPL)) {
                if (user.getCreditLimit() < orderAmount) {
                    print.printLog("Insufficient credit limit for buying " + productName);
                    return;
                }
            }
            product.setQuantity(product.getQuantity() - quantity);
            LocalDate orderDate = dateConverter.getDateFromString(date);
            Order order = new Order(index, productName, quantity, orderAmount, paymentMethod, orderDate);
            if(paymentMethod.equals(PaymentMethod.BNPL)) {
                user.setCreditLimit(user.getCreditLimit() - orderAmount);
            }
            orderMap.put(index, order);
            index++;
            user.getOrderList().add(order.getOrderId());
        }
    }

    public Order getOrderById(int orderId) {
        if(orderMap.containsKey(orderId)) {
            return orderMap.get(orderId);
        }
        return null;
    }

    public void orderStatus(String userName) {
        User user = userService.getUserByName(userName);
        if (user == null) {
            print.printLog(userName + " is not a resigtered user");
            return;
        }
        print.printLog(user.getCreditLimit() + " (BNPL : Credit Limit left)");
        for (Integer orderId : user.getOrderList()) {
            Order order = getOrderById(orderId);
            print.printLog(orderId + " -> " + order.getOrderDate() + " " + order.getOrderAmount() + " " + order.getPaymentMethod().toString() + " " + order.getProductName() + " " + order.getQuantity());
        }
    }

//    public void checkBlackListing(String date) {
//
//        List<User> userList = userService.getAllUsers();
//        for(User user : userList) {
//            userService.viewDues(user.getUserName(), date);
//            if(user.getPaymentDelayed() > 3) {
//                user.setBlackListed(true);
//            }
//        }
//    }

}
