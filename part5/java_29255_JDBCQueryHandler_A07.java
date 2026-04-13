import java.sql.*;

public class java_29255_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_29255_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                // Process the result set here
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while executing the query: " + e.getMessage());
        }
    }
}