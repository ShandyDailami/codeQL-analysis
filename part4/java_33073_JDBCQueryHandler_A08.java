import java.sql.*;

public class java_33073_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_33073_JDBCQueryHandler_A08() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fetchUser(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.insertUser("user1", "password1");
        handler.fetchUser("user1");
    }
}