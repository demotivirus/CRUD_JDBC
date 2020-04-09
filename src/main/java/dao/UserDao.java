package dao;

import models.User;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    private Connection connection;

    public UserDao(){
        connection = DBHelper.getConnection();
    }

    public void addUser(User user) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT into users (name, password, age) values (?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getAge());

            preparedStatement.executeUpdate();
            System.out.println("Add user " + user + " success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
