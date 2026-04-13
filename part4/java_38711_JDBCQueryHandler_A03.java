import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_38711_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Use the connection
            executeQuery(connection);

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        } finally {
            // Step 4: Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing the connection.");
                    e.printStackTrace();
                }
            }
        }
    }

    private static void executeQuery(Connection connection) {
        // Step 5: Create and execute a query
        String query = "SELECT * FROM users WHERE username = '" + connection.getClientIdentifier() + "' AND password = '" + connection.getPassword() + "'";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query.");
            e.printStackTrace();
        }
    }
}