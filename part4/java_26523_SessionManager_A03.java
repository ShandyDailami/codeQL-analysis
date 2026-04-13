public class java_26523_SessionManager_A03 {

    private SessionFactory sessionFactory;
    private Map<String, Session> sessionMap;

    public java_26523_SessionManager_A03() {
        sessionMap = new HashMap<>();
        sessionFactory = createSessionFactory();
    }

    private SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new ServiceRegistry();
        serviceRegistry.applySettings(configuration.getProperties());

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public Session getSession(String name) {
        Session session = sessionMap.get(name);

        if (session == null) {
            session = sessionFactory.openSession();
            sessionMap.put(name, session);
        }

        return session;
    }

    public void closeSession(String name) {
        Session session = sessionMap.get(name);

        if (session != null) {
            session.close();
            sessionMap.remove(name);
        }
    }

    public void closeAllSessions() {
        for (Map.Entry<String, Session> entry : sessionMap.entrySet()) {
            Session session = entry.getValue();
            session.close();
        }

        sessionMap.clear();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = sessionManager.getSession("session1");
        session1.beginTransaction();
        // Perform security-sensitive operations related to A03_Injection
        session1.save("User", new User("username1", "password1"));
        session1.getTransaction().commit();

        Session session2 = sessionManager.getSession("session2");
        session2.beginTransaction();
        // Perform security-sensitive operations related to A03_Injection
        session2.save("User", new User("username2", "password2"));
        session2.getTransaction().commit();

        sessionManager.closeAllSessions();
    }
}