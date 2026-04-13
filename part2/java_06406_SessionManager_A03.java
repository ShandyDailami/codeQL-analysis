import java.sql.Session;
import java.sql.SessionFactory;
import java.sql.SQLException;

public class java_06406_SessionManager_A03 {

    private SessionFactory sessionFactory;

    public java_06406_SessionManager_A03(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session openSession() throws SQLException {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) throws SQLException {
        session.close();
    }

    public Session openSessionWithTransaction() throws SQLException {
        Session session = openSession();
        session.beginTransaction();
        return session;
    }

    public void closeSessionWithTransaction(Session session, SessionTransaction transaction) {
        transaction.commit();
        closeSession(session);
    }
}