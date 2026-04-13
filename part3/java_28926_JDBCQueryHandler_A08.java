import java.sql.*;

public class java_28926_JDBCQueryHandler_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn;

    public java_28926_JDBCQueryHandler_A08() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void performQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Process result set here
            }
        } catch (SQLException e) {
            // Handle integrity failure
            e.printStackTrace();
        } finally {
            // Close resources here
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.performQuery("SELECT * FROM Users");
    }
}