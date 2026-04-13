import java.sql.Session;
import java.sql.SessionFactory;
import java.sql.SQLException;

public class java_32312_SessionManager_A03 {

    private SessionFactory sessionFactory;

    public java_32312_SessionManager_A03(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertSession(String sessionId) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(sessionId);
            session.getTransaction().commit();
        } catch (HibernateException | SQLException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteSession(String sessionId) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(sessionId);
            session.getTransaction().commit();
        } catch (HibernateException | SQLException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}