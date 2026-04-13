import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_14257_SessionManager_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Use the connection (session)
            // Here we're just getting a session. In a real application, you'd use the connection
            // to perform database operations
            System.out.println("Connected to database");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Close the connection
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Disconnected from database");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}