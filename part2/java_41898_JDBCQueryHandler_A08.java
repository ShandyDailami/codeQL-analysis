import java.sql.*;

public class java_41898_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_41898_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public boolean userExists(int userId) {
        String query = "SELECT * FROM Users WHERE userId = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}