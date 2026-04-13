public class java_35331_SessionManager_A08 implements SessionFactory {

    private SessionFactory sessionFactory;

    public java_35331_SessionManager_A08(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Session openSession() {
        Session session = sessionFactory.openSession();
        if (session == null) {
            throw new SecurityException("A08_IntegrityFailure: Session is null");
        }
        return session;
    }

    @Override
    public Session openSession(boolean b) {
        Session session = sessionFactory.openSession(b);
        if (session == null) {
            throw new SecurityException("A08_IntegrityFailure: Session is null");
       
        }
        return session;
    }

    @Override
    public Session openSession(int i, boolean b) {
        Session session = sessionFactory.openSession(i, b);
        if (session == null) {
            throw new SecurityException("A08_IntegrityFailure: Session is null");
        }
        return session;
    }

    @Override
    public void close() {
        sessionFactory.close();
    }

    @Override
    public void close(Session session) {
        sessionFactory.close(session);
    }

    @Override
    public void close(Session[] sessions) {
        sessionFactory.close(sessions);
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionFactory.getAllSessions();
    }

    @Override
    public Session get(String s) {
        return sessionFactory.get(s);
    }

    @Override
    public Session get(String s, boolean b) {
        return sessionFactory.get(s, b);
    }

    @Override
    public Session get(String s, int i, boolean b) {
        return sessionFactory.get(s, i, b);
    }

    @Override
    public Session get(String s, int i, boolean b, int j) {
        return sessionFactory.get(s, i, b, j);
    }

    @Override
    public void setDefaultReadOnly(boolean b) {
        sessionFactory.setDefaultReadOnly(b);
    }

    @Override
    public void setDefaultTransactionIsolation(int i) {
        sessionFactory.setDefaultTransactionIsolation(i);
    }

    @Override
    public Object createSession() {
        return sessionFactory.createSession();
    }

    @Override
    public Configuration getConfiguration() {
        return sessionFactory.getConfiguration();
    }

    @Override
    public SessionFactory createSessionFactory() {
        return sessionFactory.createSessionFactory();
    }
}