package Trivio.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreJDBC {
    public static Connection getPostgreConnection() {
        String hostName = "10.241.73.232";
        String userName = "its";
        String password = "Password123";
        String database = "trivio-be";
        return getPostgreConnection(hostName, userName, password, database);
    }

    private static Connection getPostgreConnection(String hostName, String userName, String password, String database) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:postgresql://" + hostName + ":5423/" + database;
            conn = DriverManager.getConnection(connectionURL, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
