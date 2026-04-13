import java.sql.*;

public class java_08443_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_08443_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately.
        }
    }

    public boolean verifyUser(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql, username, password);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately.
        }
        return false;
    }
}