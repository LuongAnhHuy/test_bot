package Trivio.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerJDBC {
    public static Connection getSQLServerConnection() {
        String hostName = "221.132.33.184";
        String sqlInstanceName = "SQLEXPRESS";
        String database = "customerdata";
        String userName = "sa";
        String password = "sWK4qO3sLDuC1qe";
        return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
    }
    public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Cấu trúc URL Connection dành cho SQL Server
            String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" + ";instance=" + sqlInstanceName + ";databaseName=" + database;
            conn = DriverManager.getConnection(connectionURL, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
