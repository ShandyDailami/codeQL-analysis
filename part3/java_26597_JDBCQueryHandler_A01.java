import java.sql.*;

public class java_26597_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn = null;

    public java_26597_JDBCQueryHandler_A01() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isUserAllowed(String userRole) {
        String query = "SELECT * FROM Users WHERE Role = ?";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                // If a user with the given role exists, return true.
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // If no user with the given role exists, return false.
        return false;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        // User with role 'Admin' is allowed.
        System.out.println(handler.isUserAllowed("Admin")); // true

        // User with role 'Employee' is not allowed.
        System.out.println(handler.isUserAllowed("Employee")); // false
    }
}