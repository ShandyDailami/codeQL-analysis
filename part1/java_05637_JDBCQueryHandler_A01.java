import java.sql.*;

public class java_05637_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Open a connection to the database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement object
            stmt = conn.createStatement();

            // Step 3: Execute a SQL query
            rs = stmt.executeQuery("SELECT * FROM users");

            // Step 4: Process the result set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Always close the statement and connection in a finally block
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}