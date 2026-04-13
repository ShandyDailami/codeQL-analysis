import java.sql.*;

public class java_30407_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM users WHERE username = ?";
            ResultSet rs = stmt.executeQuery(sql, "user1");

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