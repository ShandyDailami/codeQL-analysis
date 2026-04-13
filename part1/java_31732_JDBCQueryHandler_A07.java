import java.sql.*;

public class java_31732_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute a query
            String sql = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the results
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                if (username.equals(args[0]) && password.equals(args[1])) {
                    System.out.println("Authentication successful.");
                } else {
                    System.out.println("Invalid username or password.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Step 5: Close the statement and connection
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}