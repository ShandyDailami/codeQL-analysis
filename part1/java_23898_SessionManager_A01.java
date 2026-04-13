import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23898_SessionManager_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Begin a transaction
            connection.setAutoCommit(false);

            // Start a session
            Session session = sessionFactory.openSession();

            // Start a transaction
            session.beginTransaction();

            // Execute a query
            session.save(new User("John", "Doe"));

            // Commit the transaction
            session.getTransaction().commit();
            session.close();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}