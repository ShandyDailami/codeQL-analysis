import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_02833_SessionManager_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Use the connection (e.g., perform SQL operations)
            // Here, let's just create a new session
            SessionManager sessionManager = new SessionManager(connection);
            Session session = sessionManager.openSession();
            session.beginTransaction();

            // Perform integrity-sensitive operations here

            session.getTransaction().commit();
            session.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

// A SessionManager class which holds the database connection
class SessionManager {
    private Connection connection;

    public java_02833_SessionManager_A08(Connection connection) {
        this.connection = connection;
    }

    public Session openSession() {
        return connection.openSession();
    }
}

// A Session class which represents a single database session
class Session {
    private org.hibernate.Session session;

    public java_02833_SessionManager_A08(org.hibernate.Session session) {
        this.session = session;
    }

    public void beginTransaction() {
        session.beginTransaction();
    }

    public void commit() {
        session.getTransaction().commit();
    }

    public void close() {
        session.close();
    }
}