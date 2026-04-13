import java.sql.*;

public class java_02011_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Prepare a statement
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "validUser"); // replace with actual valid username

            // Execute the statement
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("User Found: " + rs.getString("username"));
            }

            // Close the connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}