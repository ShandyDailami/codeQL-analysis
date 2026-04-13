import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_29427_SessionManager_A08 {
    public static void main(String[] args) {
        // Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establish the connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/test", "username", "password")) {

            // Begin a transaction
            connection.setAutoCommit(false);

            // Create a new session
            Session session = sessionFactory.openSession();

            // Create a new user
            User user = new User();
            user.setName("John Doe");
            user.setEmail("john.doe@example.com");

            // Persist the user
            session.persist(user);

            // Commit the transaction
            session.getTransaction().commit();

            // Close the session
            session.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}