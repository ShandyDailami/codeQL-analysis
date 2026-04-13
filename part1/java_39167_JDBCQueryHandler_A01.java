import java.sql.*;

public class java_39167_JDBCQueryHandler_A01 {

    // Define database connection constants
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Create a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            stmt = conn.createStatement();

            // Execute a query
            rs = stmt.executeQuery("SELECT * FROM Users WHERE username = 'admin' AND password = 'password'");

            // Process the result set
            while (rs.next()) {
                System.out.println("User found!");
                System.out.println("User ID: " + rs.getString("id"));
                System.out.println("User Name: " + rs.getString("username"));
                System.out.println("User Email: " + rs.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("Error in query: " + e.getMessage());
        } finally {
            // Close the result set and statement
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing connection: " + e.getMessage());
            }
        }
    }
}