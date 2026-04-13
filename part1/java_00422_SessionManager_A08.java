public class java_00422_SessionManager_A08 {
    private static SessionManager instance;
    private Session session;

    // Private constructor to prevent instantiation from outside
    private java_00422_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory.openSession("user", "password");
        } catch (Exception e) {
            System.out.println("Error while initializing SessionFactory:" + e);
        }
    }

    // Singleton instance getter
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Security-sensitive operations (not shown)

    // Standard session methods (starts, closes, etc.)
    public void startSession() {
        session.beginTransaction();
    }

    public void closeSession() {
        session.getTransaction().commit();
    }

    // ... and so on for other session operations
}