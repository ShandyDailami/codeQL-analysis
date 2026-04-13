import java.sql.*;

public class java_40816_JDBCQueryHandler_A08 {

    // Assume we have a User database table named 'users' with columns 'id', 'username', 'password', 'email'

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Create a statement
            stmt = conn.createStatement();

            // Execute the SQL query
            String sql = "SELECT id, username, password, email FROM users WHERE username = ?";
            ResultSet rs = stmt.executeQuery(sql, "testuser");

            // Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                System.out.println("User ID: " + id);
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Email: " + email);
            }

            // Close the result set and statement
            rs.close();
            stmt.close();

            // Close the connection
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}