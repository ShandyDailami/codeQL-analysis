import java.sql.*;

public class java_12766_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        // Open a connection to the database
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            // Prepare a statement
            try (Statement stmt = conn.createStatement()) {
                // Execute a query
                ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

                // Print the results
                while (rs.next()) {
                    System.out.println("User Found: " + rs.getString("username"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}