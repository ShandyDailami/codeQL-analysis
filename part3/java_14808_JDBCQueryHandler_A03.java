import java.sql.*;

public class java_14808_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a SQL query
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "bad_user"); // This should be bad_user, but in a real application

            // Step 3: Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the results
            while (rs.next()) {
                String username = rs.getString("username");
                System.out.println("Username: " + username);
            }

            // Step 5: Close the connection
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to database: " + e.getMessage());
        }
    }
}