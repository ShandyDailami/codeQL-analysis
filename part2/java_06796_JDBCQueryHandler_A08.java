import java.sql.*;

public class java_06796_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Step 3: Set the parameter value
            pstmt.setString(1, "testuser");

            // Step 4: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the result
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                // Process the result
            }

            // Step 6: Clean up
            rs.close();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}