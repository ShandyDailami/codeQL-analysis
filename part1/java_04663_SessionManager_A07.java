import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class java_04663_SessionManager_A07 {

    private SessionFactory sessionFactory;

    public java_04663_SessionManager_A07() {
        Configuration configuration = new Configuration();
        configuration.configure();

        this.sessionFactory = configuration.buildSessionFactory();
    }

    public Optional<Session> getSession() {
        return Optional.ofNullable(sessionFactory.openSession());
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}