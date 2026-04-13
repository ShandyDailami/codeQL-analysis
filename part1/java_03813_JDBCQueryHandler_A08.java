import java.sql.*;

public class java_03813_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute a query
            String sql = "SELECT * FROM users WHERE name = 'John' AND password = 'password'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 5: Process the ResultSet
            while (rs.next()) {
                System.out.println("Found user!");
            }

            // Step 6: Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception caught: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}