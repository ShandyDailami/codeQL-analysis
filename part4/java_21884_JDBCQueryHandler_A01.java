import java.sql.*;

public class java_21884_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_21884_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public boolean validateUser(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String dbPassword = result.getString("password");
                return password.equals(dbPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}