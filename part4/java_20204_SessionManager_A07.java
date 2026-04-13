import java.util.HashMap;
import java.util.Map;

public class java_20204_SessionManager_A07 implements SessionFactory {

    private Map<String, Session> sessionMap = new HashMap<>();

    @Override
    public Session openSession() {
        Session session = new CustomSession();
        sessionMap.put(((CustomSession) session).getId(), session);
        return session;
    }
}

class CustomSession implements Session {

    private String id;

    @Override
    public String getId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
        return id;
    }

    @Override
    public SessionContext getSessionContext() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void closeSession() {
        sessionMap.remove(this.getId());
    }

    @Override
    public Transaction getTransaction(TransactionDefinition definition) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void refresh(Object entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDefaultReadOnly(boolean readOnly) {
        throw new UnsupportedOperationException();
    }
}

public class SessionManager {

    private SessionFactory sessionFactory;

    public java_20204_SessionManager_A07() {
        sessionFactory = new CustomSessionFactory();
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        session.closeSession();
    }

    public void beginTransaction(Session session) {
        session.beginTransaction();
    }

    public void commit(Session session) {
        session.commit();
    }

    public void rollback(Session session) {
        session.rollback();
    }

    public boolean isOpen(Session session) {
        return session.isOpen();
    }
}