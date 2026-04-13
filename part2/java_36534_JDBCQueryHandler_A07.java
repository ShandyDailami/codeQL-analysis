import java.sql.*;

public class java_36534_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            stmt = conn.createStatement();

            // Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

            if (rs.next()) {
                System.out.println("Authentication succeeded");
            } else {
                System.out.println("Authentication failed");
            }

            // Clean up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}