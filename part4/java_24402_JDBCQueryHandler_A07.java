import java.sql.*;

public class java_24402_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "testUser"); // Username
            pstmt.setString(2, "testPassword"); // Password

            // Step 3: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Handle the result
            while (rs.next()) {
                System.out.println("User found!");
            }

            // Step 5: Close the connections
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
       
        }
    }
}