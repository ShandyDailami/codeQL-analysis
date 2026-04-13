import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.TransactionException;

public class java_03496_SessionManager_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a Session
            Session session = connection.createSession(true, Session.AUTO_COMMIT);

            // Begin a transaction
            session.beginTransaction();

            // Perform some operations on the session
            // ...

            // Commit the transaction
            session.getTransaction().commit();

            // Close the session and connection
            session.close();
            connection.close();

            System.out.println("Transaction committed successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}