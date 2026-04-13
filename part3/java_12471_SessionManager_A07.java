import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_12471_SessionManager_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // If everything goes well, create a new session
            if (connection.isValid()) {
                System.out.println("Connection established.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    // Close the connection
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing the connection: " + e.getMessage());
                }
            }
        }
    }
}