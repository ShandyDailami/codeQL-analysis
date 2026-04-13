import java.sql.Connection;
import java.sql.SQLException;

public class java_10739_SessionManager_A08 {
    private java.sql.SessionFactory sessionFactory;

    public java_10739_SessionManager_A08(java.sql.SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public java.sql.Session openSession() {
        java.sql.Session session = null;
        try {
            session = sessionFactory.openSession();
        } catch (SQLException e) {
            System.out.println("Error while opening session: " + e.getMessage());
        }
        return session;
    }

    public void closeSession(java.sql.Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void save(java.sql.Session session, Object entity) {
        try {
            session.save(entity);
            session.flush();
        } catch (SQLException e) {
            System.out.println("Error while saving entity: " + e.getMessage());
        } finally {
            closeSession(session);
        }
    }

    public <T> T get(java.sql.Session session, Class<T> clazz, long id) {
        return session.get(clazz, id);
    }
}