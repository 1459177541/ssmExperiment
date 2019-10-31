package chapter04.tool;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    private String jdbcDriver;
    private String dbUrl;
    private String userName;
    private String userPassword;

    private Connection connection = null;

    private static JDBCUtil defaultConnection;

    public static Connection getConnection(){
        if (defaultConnection == null) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("jdbc.properties"));
                defaultConnection = new JDBCUtil(properties);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return defaultConnection.getConn();
    }

    public JDBCUtil(Properties properties){
        jdbcDriver = properties.getProperty("jdbc.driver");
        dbUrl = properties.getProperty("jdbc.url");
        userName = properties.getProperty("jdbc.user");
        userPassword = properties.getProperty("jdbc.password");
        restart();
    }

    public Connection getConn() {
        return connection;
    }

    public boolean shutdown() {
        if (null==connection) {
            return false;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean restart() {
        if (null!=connection) {
            if (!shutdown()) {
                return false;
            }
        }
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(dbUrl, userName, userPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}