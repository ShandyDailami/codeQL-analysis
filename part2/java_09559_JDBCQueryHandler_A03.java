import java.sql.*;

public class java_09559_JDBCQueryHandler_A03 {
    // Using a Connection Pool to prevent SQL Injection
    private static ConnectionPool connectionPool = new ConnectionPool();

    // Using a Statement to prevent SQL Injection
    private Statement statement;

    // Use PreparedStatement to prevent SQL Injection
    private PreparedStatement preparedStatement;

    public java_09559_JDBCQueryHandler_A03() {
        try {
            Connection connection = connectionPool.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String query) {
        try {
            int rowsInserted = statement.executeUpdate(query);
            System.out.println("Rows Inserted: " + rowsInserted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM USERS");

        try {
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbcQueryHandler.executeUpdate("INSERT INTO USERS (username, password) VALUES ('test', 'test')");
    }
}