public class java_25140_SessionManager_A01 {
    private static SessionManager instance;
    private Session session;

    // Private constructor to enforce singleton pattern
    private java_25140_SessionManager_A01() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory.openSession(new Configuration().configure().buildSessionFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if(instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }
}