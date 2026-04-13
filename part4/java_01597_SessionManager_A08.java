import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01597_SessionManager_A08 {

    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/test";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        // Load JDBC driver
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Open a connection
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {

            // Create a session
            Session session = connection.beginSession();

            // Execute a query
            session.createQuery("from User").list().forEach(user -> System.out.println(user.getName()));

            // Close the session
            session.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}