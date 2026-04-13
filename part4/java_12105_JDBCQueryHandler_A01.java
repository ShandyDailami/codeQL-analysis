import java.sql.*;

public class java_12105_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_12105_JDBCQueryHandler_A01() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // assuming we're using MySQL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/legacy_system", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validateUser(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("password").equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}