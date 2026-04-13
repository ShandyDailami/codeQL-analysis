import java.sql.*;

public class java_31061_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Assuming you already have a username and password
            String existingUsername = "existing_username";
            String existingPassword = "existing_password";

            // Setting the parameters and executing the query
            pstmt.setString(1, existingUsername);
            pstmt.setString(2, existingPassword);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}