import java.sql.*;

public class java_08158_JDBCQueryHandler_A07 {
    // Database connection
    private static Connection conn = null;

    // Execute a query
    public static ResultSet executeQuery(String query) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    // Execute a non-query (Update, Insert, Delete)
    public static int executeNonQuery(String query) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }
}