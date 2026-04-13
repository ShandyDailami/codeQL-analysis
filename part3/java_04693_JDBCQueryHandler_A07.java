import java.sql.*;

public class java_04693_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Prepare a statement
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Step 3: Set the parameters
            pstmt.setString(1, "user1"); // replace with the actual username
            pstmt.setString(2, "password1"); // replace with the actual password

            // Step 4: Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Handle the result
            if (rs.next()) {
                System.out.println("User authenticated successfully");
            } else {
                System.out.println("Authentication failed");
            }

            // Step 6: Clean up
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}