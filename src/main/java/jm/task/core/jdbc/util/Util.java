package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/localdb";
    private static final String DB_USER = "User";
    private static final String DB_PASS = "root";

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = getConfiguration();
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    public static void close() {
        try {
            Util.getSessionFactory().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.URL, DB_URL);
        settings.put(Environment.USER, DB_USER);
        settings.put(Environment.PASS, DB_PASS);
        settings.put(Environment.HBM2DDL_AUTO, "");
        configuration.setProperties(settings);
        return configuration;
    }


    private static Connection connection;
    private static Util instance;


    public static Connection getConnection() {
        return connection;
    }

    private Util() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager
                        .getConnection(DB_URL, DB_USER, DB_PASS);
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
}









