package org.itstep.dao.impl;


import org.itstep.DbUtils;
import org.itstep.dao.UserDao;
import org.itstep.data.User;


import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserDaoImpl implements UserDao {
       private final DbUtils dbUtils;
    private final static String INSERT =
            "INSERT INTO users(first_name, last_name, login, password) VALUES (?, ?, ?, ?);";
//    private final static String Update = "UPDATE tasks SET condition_id = %s WHERE id = %s;";
//    private final static String Delete = "DELETE FROM tasks WHERE id = %s;";
    private final static String SelectByLoginAndPassword = "SELECT * FROM users WHERE login = '%s' and password = '%s';";
//    private final static String SelectBySort = "SELECT * FROM tasks ORDER BY %s;";

    public UserDaoImpl(String url, String username, String password) {
        dbUtils = DbUtils.getInstance();
        dbUtils.init(url, username, password);
    }


    @Override
    public void addUser(String firstName, String lastName, String login, String password) {
        try {
            Optional<Connection> optionalConnection = dbUtils.getConnection();
            optionalConnection.ifPresent(connection -> {
                try {
                    var stmt = connection.prepareStatement(INSERT);
                    stmt.setString(1, firstName);
                    stmt.setString(2, lastName);
                    stmt.setString(3, login);
                    stmt.setString(4, password);

                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserByLoginAndPassword (String login, String password) {
//        List<User> users = new ArrayList<>();
        User [] rezultUser = new User[1];
        rezultUser[0] = null;
        String selectTotal;
        selectTotal = SelectByLoginAndPassword.formatted(login, password);
        System.out.println("selectTotal = " + selectTotal);
        try {
            Optional<Connection> optionalConnection = dbUtils.getConnection();
            optionalConnection.ifPresent(connection -> {
                try {
                    Statement stmt = connection.createStatement();
                    ResultSet resultSet = stmt.executeQuery(selectTotal);

                    while (resultSet.next()) {
//                        System.out.println(resultSet.getInt("id"));
//                        System.out.println(resultSet.getString("login"));
//                        System.out.println(resultSet.getString("password") );
                        rezultUser[0] = new User(
                                resultSet.getInt("id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("login"),
                                resultSet.getString("password") );
                        System.out.println(rezultUser[0].toString());
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rezultUser[0];
    }
}
