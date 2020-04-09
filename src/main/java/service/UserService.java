package service;

import dao.UserDao;
import model.User;

import java.util.List;

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

    public User getUser(long id){
        userDao = new UserDao();
        return userDao.getUser(id);
    }

    public List<User> getAll() {
        userDao = new UserDao();
        return userDao.getAll();
    }

    public void deleteUser(Long id) {
        userDao = new UserDao();
        userDao.deleteUser(id);
    }

    public void updateUser(User user) {
        userDao = new UserDao();
        userDao.updateUser(user);
    }
}
