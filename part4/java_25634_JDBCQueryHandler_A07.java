import java.sql.*;

public class java_25634_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "user";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Step 3: Set parameters and execute the query
            pstmt.setString(1, "user1");
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the results
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the resources
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in connection: " + e.getMessage());
        }
    }
}