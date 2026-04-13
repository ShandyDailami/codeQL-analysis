import java.sql.*;

public class java_36501_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_36501_JDBCQueryHandler_A08(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}

// Usage
public class Main {

    public static void main(String[] args) {
        try {
            JDBCQueryHandler queryHandler = new JDBCQueryHandler("url", "user", "password");
            ResultSet resultSet = queryHandler.executeQuery("SELECT * FROM users WHERE role = 'admin'");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            queryHandler.closeConnection();

        } catch (SQLException e) {
            System.out.println("Error executing query or connection: " + e.getMessage());
        }
    }
}