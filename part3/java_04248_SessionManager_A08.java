import java.util.Optional;

public class java_04248_SessionManager_A08 {
    private final SessionFactory sessionFactory;

    public java_04248_SessionManager_A08(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Optional<Session> getSession() {
        try {
            return Optional.ofNullable(sessionFactory.openSession());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}