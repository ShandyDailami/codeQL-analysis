import java.sql.*;

public class java_11877_JDBCQueryHandler_A01 {
    // Database URL, username and password for the database connection
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    // Method to execute a query
    public static void executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Step 4: Process the result
            while (rs.next()) {
                System.out.println("Access granted to user: " + rs.getString("username"));
            }

            // Step 5: Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Test the query
        executeQuery("SELECT username FROM users WHERE role='admin'");
    }
}