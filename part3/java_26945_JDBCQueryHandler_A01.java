import java.sql.*;

public class java_26945_JDBCQueryHandler_A01 {
    private Connection connection;
    private Statement statement;

    // Constructor
    public java_26945_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    // Execute a query and return the result set
    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    // Execute a statement (update, insert, delete) and return the result set
    public ResultSet executeStatement(String query) throws SQLException {
        return statement.executeUpdate(query) > 0 ? statement.executeQuery(query) : null;
    }

    // Close the connection
    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
            ResultSet resultSet = handler.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            handler.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}