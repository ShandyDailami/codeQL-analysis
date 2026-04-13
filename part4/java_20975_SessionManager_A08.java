public class java_20975_SessionManager_A08 {

    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();

    public static Session openSession(String dbURL, String userName, String password) {
        Session session = null;
        try {
            session = SessionFactory.openSession(dbURL, userName, password);
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

    public static Session getCurrentSession() {
        return sessionThreadLocal.get();
    }

    public static void update(Object object) {
        Session session = sessionThreadLocal.get();
        if (session != null) {
            session.update(object);
        }
    }

    public static void delete(Object object) {
        Session session = sessionThreadLocal.get();
        if (session != null) {
            session.delete(object);
        }
    }

    public static void save(Object object) {
        Session session = sessionThreadLocal.get();
        if (session != null) {
            session.save(object);
        }
    }

    public static Object get(Class clazz, Serializable id) {
        Session session = sessionThreadLocal.get();
        if (session != null) {
            return session.get(clazz, id);
        }
        return null;
    }

    public static List<Object> find(String hql) {
        Session session = sessionThreadLocal.get();
        if (session != null) {
            Query query = session.createQuery(hql);
            return query.list();
        }
        return null;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.openSession("jdbc:mysql://localhost:3306/test", "root", "root");
        // Perform integrity-sensitive operations related to integrity failure
        sessionManager.save(new User("test"));
        sessionManager.closeSession();
    }
}