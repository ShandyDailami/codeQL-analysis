import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_10398_SessionManager_A08 {
    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Step 2: Create a SessionFactory
            if (connection.getClass().getName().contains("CachedConnection")) {
                connection = connection.unwrapUndisposedCachedConnection();
            }
            SessionFactory sessionFactory = connection.getSessionFactory();

            // Step 3: Create a Session
            Session session = sessionFactory.openSession();

            // Step 4: Perform some operations on the Session

            // Step 5: Close the Session
            session.close();

            // Step 6: Close the SessionFactory
            sessionFactory.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}