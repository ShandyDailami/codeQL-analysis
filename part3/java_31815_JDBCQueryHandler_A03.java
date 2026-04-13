import java.sql.*;

public class java_31815_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Create SQL query
            String query = "SELECT * FROM users WHERE username = ?";

            // Prepare statement
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set parameter value
            pstmt.setString(1, "testUser");

            // Execute query
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }

            // Close connection
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}