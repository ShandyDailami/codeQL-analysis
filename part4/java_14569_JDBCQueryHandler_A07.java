import java.sql.*;

public class java_14569_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a Statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute a Query
            String query = "SELECT * FROM users WHERE id = ?";
            ResultSet rs = stmt.executeQuery(query);

            // Step 4: Handle Authentication Failure
            if (!rs.isBeforeFirst()) {
                System.out.println("Authentication failure!");
            } else {
                while (rs.next()) {
                    System.out.println("User found: " + rs.getString("username"));
                }
            }

            // Step 5: Close the Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}