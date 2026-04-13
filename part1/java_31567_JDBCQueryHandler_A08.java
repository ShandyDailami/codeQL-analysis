import java.sql.*;

public class java_31567_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_31567_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                // Process the result set
            }
        } catch (SQLException e) {
            // Handle the exception
        }
    }

    public void updateQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query)) {
            // No result set returned
        } catch (SQLException e) {
            // Handle the exception
        }
    }
}