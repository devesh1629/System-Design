package services;

import models.User;
import util.ConsolePrint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    Map<String, User> users = new HashMap<>();

    ConsolePrint print = new ConsolePrint();

    public void registerUser(String name, Integer creditLimit) {
        User user = new User(name, creditLimit);
        users.put(user.getUserName(), user);
        print.printLog( user.getUserName() + " registered !!");
    }

    public User getUserByName(String name) {
        if(users.containsKey(name))
            return users.get(name);
        return null;
    }


    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
