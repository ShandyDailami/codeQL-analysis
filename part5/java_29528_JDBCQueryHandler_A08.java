import java.sql.*;

public class java_29528_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1. Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // 2. Create a statement
            stmt = conn.createStatement();

            // 3. Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            // 4. Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            // 5. Clean up resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}