package bnpl.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    Integer userId;
    String userName;
    Integer creditLimit;
    List<Integer> orderList;
    Integer paymentDelayed;
    Boolean blackListed;

    public User(String userName, Integer creditLimit) {
        this.userName = userName;
        this.creditLimit = creditLimit;
        orderList = new ArrayList<>();
        paymentDelayed = 0;
        blackListed = false;
    }

    public User(Integer userId, String userName, Integer creditLimit) {
        this.userId = userId;
        this.userName = userName;
        this.creditLimit = creditLimit;
        orderList = new ArrayList<>();
        paymentDelayed = 0;
        blackListed = false;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public List<Integer> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Integer> orderList) {
        this.orderList = orderList;
    }

    public Integer getPaymentDelayed() {
        return paymentDelayed;
    }

    public void setPaymentDelayed(Integer paymentDelayed) {
        this.paymentDelayed = paymentDelayed;
    }

    public Boolean getBlackListed() {
        return blackListed;
    }

    public void setBlackListed(Boolean blackListed) {
        this.blackListed = blackListed;
    }
}
