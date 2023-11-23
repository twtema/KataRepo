package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        userService.createUsersTable();

        userService.saveUser("Иван", "Иванов", (byte) 10);
        userService.saveUser("Сергей", "Сергеев", (byte) 11);
        userService.saveUser("Григорий", "Григорьев", (byte) 12);
        userService.saveUser("Антон", "Антонов", (byte) 13);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
