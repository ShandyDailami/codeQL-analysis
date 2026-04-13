import java.sql.*;

public class java_00137_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "user";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE role='ADMIN'");

            while (rs.next()) {
                String role = rs.getString("role");
                System.out.println("User role: " + role);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}