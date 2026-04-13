import java.sql.*;

public class java_33359_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            // Create a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Prepare a statement
            String sql = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameter value
            pstmt.setInt(1, 123);

            // Execute the statement
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }

            // Close the connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in JDBC operation: " + e.getMessage());
        }
    }
}