public class java_10060_SessionManager_A03 {
    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();
    private static ConnectionPool connectionPool;

    static {
        connectionPool = new ConnectionPool();
    }

    public static Session getSession() {
        Session session = sessionThreadLocal.get();
        if (session == null) {
            session = connectionPool.getConnection();
            sessionThreadLocal.set(session);
        }
        return session;
    }

    public static void closeSession() {
        Session session = sessionThreadLocal.get();
        if (session != null) {
            sessionThreadLocal.set(null);
            connectionPool.returnConnection(session);
        }
    }

    public static void beginSession() {
        Session session = getSession();
        if (session != null) {
            session.beginTransaction();
        } else {
            throw new RuntimeException("No available Session");
        }
    }

    public static void commitSession() {
        Session session = sessionThreadLocal.get();
        if (session != null) {
            session.getTransaction().commit();
            sessionThreadLocal.set(null);
            connectionPool.returnConnection(session);
        } else {
            throw new RuntimeException("No available Session");
        }
    }
}