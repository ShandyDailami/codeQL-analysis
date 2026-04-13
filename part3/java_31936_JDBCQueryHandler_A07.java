import java.sql.*;

public class java_31936_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_31936_JDBCQueryHandler_A07() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(String username, String password) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("password").equals(password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}