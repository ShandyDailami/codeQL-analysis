import java.sql.*;

public class java_40598_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_40598_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public boolean authenticate(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";

        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        try {
            new JDBCQueryHandler("jdbc:your_database_url", "username", "password").authenticate("username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}