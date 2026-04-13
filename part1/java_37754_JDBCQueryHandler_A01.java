import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_37754_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_37754_JDBCQueryHandler_A01(String dbUrl, String user, String password) {
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("Unable to connect to the database: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to close the database connection: " + e.getMessage());
        }
    }

    public List<String> executeQuery(String query) {
        List<String> result = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query: " + e.getMessage());
        }
        return result;
    }
}