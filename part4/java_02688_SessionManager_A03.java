import java.util.Optional;

// The SessionFactory interface is part of Hibernate, JPA and other Java ORM libraries.
// It provides methods to create, retrieve and delete session objects.
// Session objects are used to interact with a database session.
// A session is a transaction and is a lightweight object that holds a connection.
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_02688_SessionManager_A03 {

    // Store the reference to the session factory.
    private static SessionFactory sessionFactory;

    // The static initializer loads the Hibernate configuration and instantiate the SessionFactory.
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // This method opens a session.
    // In a real-world scenario, you'd use the SessionFactory to open a session, not the Session.
    public static Optional<Session> openSession() {
        return Optional.ofNullable(sessionFactory.openSession());
    }

    // This method starts a transaction.
    // In a real-world scenario, you'd use the Session to start a transaction, not the SessionFactory.
    public static void startTransaction(Session session) {
        Transaction transaction = session.beginTransaction();
        // You can use the transaction here for example for logging purposes.
    }

    // This method commits a transaction.
    // In a real-world scenario, you'd use the Session to commit a transaction, not the SessionFactory.
    public static void commitTransaction(Session session) {
        session.getTransaction().commit();
    }

    // This method closes a session.
    // In a real-world scenario, you'd use the SessionFactory to close a session, not the Session.
    public static void closeSession(Session session) {
        session.close();
    }
}