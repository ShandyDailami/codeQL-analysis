import java.sql.*;

public class java_06828_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, "invalid_user");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbUsername = rs.getString("username");
                String dbPassword = rs.getString("password");

                if (invalidUser(dbUsername, dbPassword)) {
                    System.out.println("Authentication failure for user: " + dbUsername);
                }
            } else {
                System.out.println("Invalid user");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean invalidUser(String username, String password) {
        // Here you would typically compare the password with a hashed version stored in the database.
        // For simplicity, we'll just check if the password is empty.
        return password.isEmpty();
    }
}