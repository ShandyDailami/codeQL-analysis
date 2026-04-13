public class java_01710_SessionManager_A03 {
    private static SessionManager instance;
    private Session session;

    private java_01710_SessionManager_A03() {
        // Using the factory method to get an instance of SessionFactory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }
}