import java.sql.*;

public class java_26175_JDBCQueryHandler_A08 {
    private final String url;
    private final String username;
    private final String password;

    public java_26175_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        connection.close();

        return resultSet;
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        connection.close();
    }
}

public class SecurityTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "testuser";
        String password = "testpassword";
        
        // Create a new JDBCQueryHandler
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler(url, username, password);

        // Execute a query
        ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM Users");

        // Check if the resultSet is null
        if (resultSet == null) {
            System.out.println("Security failure detected!");
        } else {
            System.out.println("Security check passed!");
        }
    }
}