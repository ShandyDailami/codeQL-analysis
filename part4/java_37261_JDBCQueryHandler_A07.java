import java.sql.*;

public class java_37261_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Connection URL
        String url = "jdbc:mysql://localhost:3306/Test";
        // Username and password
        String username = "root";
        String password = "password";

        try {
            // Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Prepare Statement
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set parameter values
            pstmt.setString(1, "user1");
            pstmt.setString(2, "password1");

            // Execute Statement
            ResultSet rs = pstmt.executeQuery();

            // Process ResultSet
            while (rs.next()) {
                System.out.println(rs.getString("username") + " " + rs.getString("email"));
            }

            // Close ResultSet and Connection
            rs.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}