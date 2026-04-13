import javax.sql.SessionFactory;
import javax.sql.SessionFactoryBuilder;
import javax.sql.Session;

public class java_19567_SessionManager_A01 {
    private SessionFactory sessionFactory;

    public java_19567_SessionManager_A01() {
        // Create a new session factory with the credentials of the database
        sessionFactory = new SessionFactoryBuilder()
                .setUsername("username")
                .setPassword("password")
                .setDriver("com.mysql.jdbc.Driver")
                .setURL("jdbc:mysql://localhost/dbname")
                .buildSessionFactory();
    }

    public Session getSession() {
        // Return a new session
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        // Close the session
        session.close();
    }

    public static void main(String[] args) {
        // Create a new session manager
        SessionManager manager = new SessionManager();

        // Get a new session
        Session session = manager.getSession();

        // Perform session operations
        // ...

        // Close the session
        manager.closeSession(session);
    }
}