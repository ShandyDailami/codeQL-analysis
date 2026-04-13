import java.sql.*;

public class java_01741_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Connect to database
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            stmt = conn.createStatement();

            // Create a new user
            String createUser = "INSERT INTO users (username, password) VALUES ('user1', 'password1')";
            stmt.executeUpdate(createUser);

            // Get user by username
            String selectUser = "SELECT * FROM users WHERE username='user1'";
            ResultSet rs = stmt.executeQuery(selectUser);
            while (rs.next()) {
                String user = rs.getString("username");
                String pass = rs.getString("password");
                System.out.println("User: " + user + ", Password: " + pass);
            }

            // Update user
            String updateUser = "UPDATE users SET password='newpassword' WHERE username='user1'";
            stmt.executeUpdate(updateUser);

            // Delete user
            String deleteUser = "DELETE FROM users WHERE username='user1'";
            stmt.executeUpdate(deleteUser);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}