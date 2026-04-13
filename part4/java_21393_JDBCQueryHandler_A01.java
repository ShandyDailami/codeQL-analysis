import java.sql.*;

public class java_21393_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_21393_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void close() throws SQLException {
        connection.close();
    }
}

// Example usage:

public class Main {
    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");

            // Assume a broken access control scenario:
            handler.executeUpdate("DROP TABLE users;"); // This should fail due to lack of privileges

            // To avoid breaking access control, we handle exceptions:
            try {
                ResultSet resultSet = handler.executeQuery("SELECT * FROM users;");
                while (resultSet.next()) {
                    // handle resultSet...
                }
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }

            handler.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}