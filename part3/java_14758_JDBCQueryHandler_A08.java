import java.sql.*;

public class java_14758_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String sql = "SELECT * FROM Users WHERE Email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Step 3: Set parameters
            pstmt.setString(1, "test@example.com"); // This is a fake email.

            // Step 4: Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Handle the result set
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
            }

            // Step 6: Close the connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database: " + e.getMessage());
        }
    }
}