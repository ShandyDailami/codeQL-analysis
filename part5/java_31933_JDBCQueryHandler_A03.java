import java.sql.*;

public class java_31933_JDBCQueryHandler_A03 {
    // URL, username, password for the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASS = "password";

    // Main function
    public static void main(String[] args) {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Connected to database!");

            // Create a statement
            try (Statement stmt = conn.createStatement()) {
                // Execute a query
                ResultSet rs = stmt.executeQuery("SELECT * FROM users");

                // Process the result set
                while (rs.next()) {
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println("Name: " + name + ", Age: " + age);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}