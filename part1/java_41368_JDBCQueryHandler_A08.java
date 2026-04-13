import java.sql.*;

public class java_41368_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_41368_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            // Handle SQLException, such as bad JDBC driver, bad credentials, etc.
            e.printStackTrace();
        } finally {
            // Always close connections to prevent resource leaks
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return resultSet;
    }
}

// Usage
public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "username";
        String password = "password";

        JDBCQueryHandler queryHandler = new JDBCQueryHandler(url, username, password);

        String query = "SELECT * FROM users WHERE id = " + 123;
        ResultSet resultSet = queryHandler.executeQuery(query);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println("Name: " + name);
        }
    }
}