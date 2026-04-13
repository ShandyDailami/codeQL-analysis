import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class java_07311_SessionManager_A03 {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static Optional<Session> getSession() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return Optional.ofNullable(sessionFactory.openSession());
    }

    public static void main(String[] args) {
        getSession().ifPresent(session -> {
            // Start your operations here
        });
    }
}