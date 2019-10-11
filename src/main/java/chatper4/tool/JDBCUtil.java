package chatper4.tool;

import java.sql.*;
import java.util.Objects;

public class JDBCUtil {

    private String jdbcDriver;
    private String dbUrl;
    private String userName;
    private String userPassword;

    private Connection connection = null;

    private static JDBCUtil defaultConnection;

    public JDBCUtil toDefault(){
        defaultConnection = this;
        return this;
    }

    public static JDBCUtil getDefault(){
        return Objects.requireNonNull(defaultConnection,"没有默认数据库链接");
    }

    public static Connection getConnection(){
        if (defaultConnection == null) {
            defaultConnection = new JDBCUtil("yxc", "816357492", "test");
        }
        return defaultConnection.getConn();
    }

    public JDBCUtil(String userName, String userPassword, String databaseName){
        this.userName = userName;
        this.userPassword = userPassword;
        jdbcDriver = "com.mysql.cj.jdbc.Driver";
        dbUrl = "jdbc:mysql://localhost:3306/"+databaseName+"?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true";
        restart();
    }

    public JDBCUtil(String jdbcDriver, String dbUrl, String userName, String userPassword) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.userName = userName;
        this.userPassword = userPassword;
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

    @SuppressWarnings({"SqlNoDataSourceInspection", "SqlResolve"})
    public boolean hasTable(String name){
        if (connection==null){
            restart();
        }
        String sql = "SHOW TABLES;";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                String tableName = rs.getString(0);
                if (tableName.equals(name)){
                    return true;
                }
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

}







