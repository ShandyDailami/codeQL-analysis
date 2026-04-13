import java.sql.*;

public class java_13473_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_13473_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                // perform operations on the result set
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}