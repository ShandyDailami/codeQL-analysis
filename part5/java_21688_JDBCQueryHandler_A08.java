import java.sql.*;

public class java_21688_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";

    // Create a connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Create a statement
    public Statement getStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    // Execute a query
    public ResultSet executeQuery(Statement statement, String query) throws SQLException {
        return statement.executeQuery(query);
    }

    // Close connection and statement
    public void close(Statement statement, Connection connection) throws SQLException {
        statement.close();
        connection.close();
    }

    // Test connectivity
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        try {
            Connection connection = handler.getConnection();
            Statement statement = handler.getStatement(connection);
            ResultSet resultSet = handler.executeQuery(statement, "SELECT * FROM table");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column"));
            }
            handler.close(statement, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}