import java.sql.*;

public class java_11605_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_11605_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        return resultSet;
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public static void main(String[] args) {
        // Create a JDBCQueryHandler instance with a connection string and credentials
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

        // Execute a query
        ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM Users");

        // Process the results
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            // ... perform security-sensitive operations
        }
    }
}