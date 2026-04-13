import java.sql.*;

public class java_08307_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Step 3: Set parameters
            pstmt.setString(1, "testUser");

            // Step 4: Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the results
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            // Step 6: Close the connection
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}