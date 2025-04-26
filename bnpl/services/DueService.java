package bnpl.services;

import bnpl.models.*;
import bnpl.util.*;

import java.time.LocalDate;
import java.util.List;

public class DueService {

    private final UserService userService = ServiceFactory.getUserService();
    private final OrderService orderService = ServiceFactory.getOrderService();

    ConsolePrint print = new ConsolePrint();
    DateConverter dateConverter = new DateConverter();

    public void clearDues(String userName, List<Integer> orders, String date) {
        User user = userService.getUserByName(userName);
        if(user == null) {
            print.printLog(userName + " is not a resigtered user");
            return;
        }
        for(Integer orderId : orders) {
            Order order = orderService.getOrderById(orderId);
            order.setPaymentCompleted(true);
            LocalDate paymentDate = dateConverter.getDateFromString(date);
            order.setPaymentDate(paymentDate);
            user.setCreditLimit(user.getCreditLimit() + order.getOrderAmount());
        }
        print.printLog("Dues cleared");
    }

    public void viewDues(String userName, String date) {
        User user = userService.getUserByName(userName);
        if(user == null) {
            print.printLog(userName + " is not a resigtered user");
            return;
        }
        int flag = 1;
        for(Integer orderId : user.getOrderList()) {
            Order order = orderService.getOrderById(orderId);
            if(!order.getPaymentCompleted()) {
                flag = 0;
                LocalDate dueDate = order.getOrderDate().plusDays(30);
                print.printLog(order.getOrderDate() + " " + order.getOrderAmount() + " Due by: " + dueDate);
                LocalDate currentDate = dateConverter.getDateFromString(date);
                if(currentDate.isAfter(dueDate)) {
                    print.printLog("DELAYED");
                    user.setPaymentDelayed(user.getPaymentDelayed()+1);
                }
            }
        }
        if(flag == 1) {
            print.printLog("NO dues");
        }
    }
}
