import java.sql.*;

public class java_03967_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_03967_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
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

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");

            // Query 1: Select all users
            ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            // Query 2: Insert a new user
            jdbcQueryHandler.executeUpdate("INSERT INTO users (username, password) VALUES ('newuser', 'password')");

            // Query 3: Update a user
            jdbcQueryHandler.executeUpdate("UPDATE users SET password = 'newpassword' WHERE username = 'newuser'");

            // Query 4: Delete a user
            jdbcQueryHandler.executeUpdate("DELETE FROM users WHERE username = 'newuser'");

            jdbcQueryHandler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error executing queries: " + e.getMessage());
        }
    }
}