import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_15703_SessionManager_A03 {

    public static void main(String[] args) {
        try {
            createSession();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createSession() throws ClassNotFoundException, SQLException {
        // Load the database driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a connection to the database
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testDB", "username", "password");

        // Create a new session using the connection
        Session session = sessionFactory.openSession(connection);

        // Start a transaction
        Transaction transaction = session.beginTransaction();

        // Perform a transaction-related operation...

        // Commit the transaction
        transaction.commit();

        // Close the session
        session.close();
    }
}