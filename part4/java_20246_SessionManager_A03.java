import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_20246_SessionManager_A03 {

    private static Connection connection;

    // Establish a connection to the database
    public static Connection establishConnection() {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            connection = null;
        }
        return connection;
    }

    // Execute a SQL statement using the established connection
    public static void executeStatement(String sql) {
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sql);
                System.out.println("SQL statement executed successfully!");
            } catch (SQLException e) {
                System.out.println("Failed to execute SQL statement: " + e.getMessage());
            }
        } else {
            System.out.println("Connection not established!");
        }
    }

    // Main method
    public static void main(String[] args) {
        establishConnection();
        executeStatement("SELECT * FROM mytable");
    }
}