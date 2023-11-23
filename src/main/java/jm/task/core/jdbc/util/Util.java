package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static Connection connection;
    private static Util instance;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/localdb";
    private static final String USER = "User";
    private static final String PASS = "root";


    public static Connection getConnection()  {
        return connection;
    }

    private Util() {
        try {
            if (null == connection || connection.isClosed()) {
                connection = DriverManager
                        .getConnection(DB_URL, USER, PASS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Util getInstance() {
        if (null == instance) {
            instance = new Util();
        }
        return instance;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
