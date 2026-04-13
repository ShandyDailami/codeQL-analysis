import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class java_20501_SessionManager_A01 {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Load the Hibernate configuration file and instantiate a SessionFactory
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Optional<Session> getSession(String username) {
        try {
            // Validate username
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("Username is required");
            }

            // Open a session
            return Optional.of(sessionFactory.openSession());
        } catch (Exception ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        getSession("user").ifPresent(session -> {
            // Use the session here (e.g., save, update, query, etc.)
            session.beginTransaction();
            session.getTransaction().commit();
        });
    }
}