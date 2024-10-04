package Trivio.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
    private Connection connection;

    public DatabaseUtil() {
        try {
            this.connection = PostgreJDBC.getPostgreConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface ResultSetHandler<T> {
        T handle(ResultSet rs) throws SQLException;
    }

    public <T> T executeQuery(String sql, ResultSetHandler<T> handler) {
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            return handler.handle(rs);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
