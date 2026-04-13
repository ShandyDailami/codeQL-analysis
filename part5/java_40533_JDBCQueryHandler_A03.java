import java.sql.*;

public class java_40533_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();

            // Insert operation
            String insertSQL = "INSERT INTO users (username, password) VALUES ('testuser', 'testpassword')";
            stmt.executeUpdate(insertSQL);

            // Query operation
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username = 'testuser'");
            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username") + " - " + rs.getString("password"));
            }

            // Update operation
            String updateSQL = "UPDATE users SET password = 'newpassword' WHERE username = 'testuser'";
            stmt.executeUpdate(updateSQL);

            // Delete operation
            String deleteSQL = "DELETE FROM users WHERE username = 'testuser'";
            stmt.executeUpdate(deleteSQL);

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