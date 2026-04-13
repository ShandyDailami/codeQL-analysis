import java.sql.*;

public class java_14224_JDBCQueryHandler_A07 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_14224_JDBCQueryHandler_A07() {
        try {
            this.connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute update: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        // Example 1: Executing a query
        String query = "SELECT * FROM users WHERE username = ?";
        ResultSet result = handler.executeQuery(query);
        if (result != null) {
            while (result.next()) {
                String username = result.getString("username");
                // Process the result
            }
            result.close();
        }

        // Example 2: Executing an update
        String updateQuery = "UPDATE users SET password = ? WHERE username = ?";
        handler.executeUpdate(updateQuery);
    }
}