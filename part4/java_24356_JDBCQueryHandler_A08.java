import java.sql.*;

public class java_24356_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users WHERE password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Beware of SQL injection. Use parameterized queries to prevent it.
            pstmt.setString(1, "password123");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String passwordFromDB = rs.getString("password");
                System.out.println("Password from database: " + passwordFromDB);
            }
        } catch (SQLException e) {
            System.out.println("Error in JDBC connection or query execution: " + e.getMessage());
        }
    }
}