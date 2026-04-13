import java.sql.*;

public class java_22859_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Prepare a statement
            stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Process the result
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);

                // Here you would typically check the password against a hashed value for security reasons
                // This is a simplified example and would not be secure in a real application
                if (password.equals("hashedPassword")) {
                    System.out.println("Access granted");
                } else {
                    System.out.println("Access denied");
                }
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in handling database");
            e.printStackTrace();
        }
    }
}