import java.sql.*;

public class java_18049_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Prepare the statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Users WHERE username = ?");
            pstmt.setString(1, "testUser");

            // Step 3: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the results
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
        }
    }
}