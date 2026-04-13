import java.sql.*;

public class java_40528_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set the parameter value
            pstmt.setString(1, "invalid_user");

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("User found");
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}