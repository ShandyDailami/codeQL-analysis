public class java_11423_SessionManager_A03 {

    // Create a static instance of SessionManager
    private static SessionManager instance;

    // Private constructor to prevent instantiation
    private java_11423_SessionManager_A03() {}

    // Static method to get instance of SessionManager
    public static SessionManager getInstance() {
        if(instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Private session variable
    private Session session;

    // Method to open a session
    public void openSession() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to close a session
    public void closeSession() {
        session.close();
    }

    // Method to save an object
    public void saveObject(Object object) {
        try {
            session.save(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to find an object
    public Object findObject(Object object) {
        try {
            return session.get(object.getClass(), object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}