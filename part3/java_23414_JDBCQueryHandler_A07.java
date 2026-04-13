import java.sql.*;

public class java_23414_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Establish connection
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");
            stmt = conn.createStatement();

            // Security-sensitive operation related to A07_AuthFailure
            String sql = "SELECT * FROM users WHERE username = 'admin' AND password = 'password'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}