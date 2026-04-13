public class java_20464_SessionManager_A03 {

    private static final ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();

    public static Session openSession() {
        return openSession("");
    }

    public static Session openSession(String dbName) {
        Session session = null;
        try {
            session = SessionFactory.getInstance().openSession(dbName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sessionThreadLocal.set(session);
        return session;
    }

    public static void closeSession() {
        Session session = sessionThreadLocal.get();
        if (session != null) {
            session.close();
            sessionThreadLocal.remove();
        }
    }
}