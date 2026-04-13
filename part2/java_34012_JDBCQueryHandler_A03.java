import java.sql.*;

public class java_34012_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            pstmt.setString(1, "testUser"); // This is a security-sensitive operation related to A03_Injection

            // Step 3: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the result
            while (rs.next()) {
                String username = rs.getString("username");
                // Do something with the username
            }

            // Step 5: Close the connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}