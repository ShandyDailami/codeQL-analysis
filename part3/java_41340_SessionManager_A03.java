import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_41340_SessionManager_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create session
            Session session = connection.beginSession();

            // Perform security-sensitive operation
            session.doWork();

            // Commit transaction
            session.commit();

            // Close connection
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Session {

    private Connection connection;

    public java_41340_SessionManager_A03(Connection connection) {
        this.connection = connection;
    }

    public void doWork() {
        // Security-sensitive operation here
        // For example, SQL Injection, in this case
        String injection = "INJECT_ME_HERE";
        String query = "SELECT * FROM users WHERE username = '" + injection + "'";

        // Execute query
        // ...
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}