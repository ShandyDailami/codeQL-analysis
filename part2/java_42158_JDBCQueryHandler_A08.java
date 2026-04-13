import java.sql.*;

public class java_42158_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    private ConnectionPool connectionPool;

    public java_42158_JDBCQueryHandler_A08() {
        connectionPool = new ConnectionPool();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = connectionPool.getConnection();
        Statement statement = connection.createStatement();

        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = connectionPool.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate(query);
   
        connectionPool.releaseConnection(connection);
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler();
            ResultSet resultSet = handler.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String email = resultSet.getString("Email");

                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            handler.executeUpdate("UPDATE Users SET Email = 'newemail@example.com' WHERE Name = 'TestUser'");
        } catch (SQLException e) {
            System.out.println("Error executing query or update: " + e.getMessage());
        }
    }
}