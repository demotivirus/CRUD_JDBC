package dao;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public User getUser(long id){
        User user = null;
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from users where id = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                int age = resultSet.getInt("age");
                return new User(id, name, password, age);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return user;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            User user;
            while (result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                String password = result.getString("password");
                int age = result.getInt("age");
                user = new User(id, name, password, age);
                users.add(user);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return users;
    }
}
