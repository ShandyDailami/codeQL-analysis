import java.sql.*;

public class java_04874_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_04874_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String userId, String password) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Create a statement
            Statement stmt = conn.createStatement();
            // Execute SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = '" + userId + "' AND password = '" + password + "'");

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}