import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_25956_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");
            e.printStackTrace();
        }

        // Step 3: Execute a query
        if (connection != null) {
            try {
                connection.createStatement().execute("SELECT * FROM Users");
            } catch (SQLException e) {
                System.out.println("Failed to execute query.");
                e.printStackTrace();
            }
        }

        // Step 4: Close the connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connection.");
                e.printStackTrace();
            }
        }
    }
}