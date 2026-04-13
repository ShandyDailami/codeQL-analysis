public class java_41514_SessionManager_A01 {
    private static SessionManager instance;
    private Session session;

    // Constructor is private so a new instance cannot be created
    private java_41514_SessionManager_A01() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactoryBuilder.getSessionFactory().openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void openSession() {
        if (session == null || !session.isOpen()) {
            try {
                session = SessionFactoryBuilder.getSessionFactory().openSession();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }

    public void execute(String query) {
        try {
            session.createQuery(query).executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}