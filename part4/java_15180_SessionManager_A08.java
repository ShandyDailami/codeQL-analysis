public class java_15180_SessionManager_A08 {
    private static SessionManager instance;
    private Session session;
    private String url;
    private String username;
    private String password;

    private java_15180_SessionManager_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static SessionManager getInstance(String url, String username, String password) {
        if (instance == null) {
            instance = new SessionManager(url, username, password);
        }
        return instance;
    }

    public void openSession() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory.openSession(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeSession() {
        session.close();
    }

    public void performIntegrityFailureOperation() {
        try {
            // Example of a security-sensitive operation related to A08_IntegrityFailure
            session.createQuery("SELECT * FROM User").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}