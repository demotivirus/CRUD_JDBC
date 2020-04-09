package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static Connection connection;

    public static Connection getConnection(){
        if (connection == null)
            connection = createConnection();
        return connection;
    }

    private static Connection createConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
            //DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:mysql://"). //db type
                    append("localhost:"). //host name
                    append("3306/"). //port
                    append("crud_service?"). //db name
                    append("user=root&"). //login
                    append("password=root&"). //password
                    append("useLegacyDatetimeCode=false&").
                    append("serverTimezone=UTC&characterEncoding=utf-8");

            Connection newConnection = DriverManager.getConnection(url.toString());
            System.out.println(url.toString());
            return newConnection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}