import java.sql.*;

public class java_16371_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_16371_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
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

// Use the handler like this:
public class Main {
    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");

            ResultSet resultSet = handler.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            handler.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}