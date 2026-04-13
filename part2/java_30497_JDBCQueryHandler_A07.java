import java.sql.*;

public class java_30497_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Step 3: Set the parameter value
            pstmt.setString(1, "testUser");

            // Step 4: Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the result
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Clean up
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}