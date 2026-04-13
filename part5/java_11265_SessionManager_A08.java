import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11265_SessionManager_A08 {
    public static void main(String[] args) {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Create a session
            Session session = connection.getSession();

            // Perform a simple operation
            session.beginTransaction();
            User user = new User("John", "Doe", "john@example.com");
            session.save(user);
            session.getTransaction().commit();

            // Close the connection
            session.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}