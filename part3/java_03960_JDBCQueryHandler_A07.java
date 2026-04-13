import java.sql.*;

public class java_03960_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE AuthFailureCount > 5");

            while (rs.next()) {
                String username = rs.getString("Username");
                int failureCount = rs.getInt("AuthFailureCount");

                System.out.println("Username: " + username);
                System.out.println("Failure Count: " + failureCount);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}