public class java_20763_SessionManager_A01 {

    // The current session
    private static Session currentSession;

    // The thread-safe holder of the session
    private static final ThreadLocal<Session> sessionHolder = new ThreadLocal<Session>();

    public static void setCurrentSession(Session session) {
        currentSession = session;
    }

    public static Session getCurrentSession() {
        return currentSession;
    }

    public static void createSession(String userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User(userId);
        session.save(user);
        session.getTransaction().commit();
        sessionHolder.set(session);
        setCurrentSession(session);
    }

    public static void closeSession() {
        Session session = sessionHolder.get();
        if (session != null) {
            session.close();
            sessionHolder.remove();
            setCurrentSession(null);
        }
    }
}