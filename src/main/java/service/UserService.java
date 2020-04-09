package service;

import dao.UserDao;
import models.User;

public class UserService {
    private static UserService userService;
    private UserDao userDao;

    private UserService(){}

    public static UserService getInstance(){
        if (userService == null)
            userService = new UserService();
        return userService;
    }

    public void addUser(User user) {
        userDao = new UserDao();
        userDao.addUser(user);
    }
}
