import java.sql.*;

public class java_41653_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_41653_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query, username, password);

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}