import java.sql.*;

public class java_22864_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_22864_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public boolean authenticate() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            return true;
        } catch (SQLException e) {
            System.out.println("Authentication failed. Error: " + e.getMessage());
            return false;
        }
    }

    public ResultSet executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query)) {
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Query execution failed. Error: " + e.getMessage());
            return null;
        }
    }
}