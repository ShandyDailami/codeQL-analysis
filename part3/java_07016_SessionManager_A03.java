public class java_07016_SessionManager_A03 {
    private static SessionManager instance;
    private static Session session;
    
    private java_07016_SessionManager_A03() {
        // Private constructor to prevent instantiation from outside
    }
    
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    
    public void openSession() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory.getSessionFactory().openSession();
        } catch (Exception e) {
            System.out.println("Failed to create session. " + e.getMessage());
        }
    }
    
    public void closeSession() {
        session.close();
    }
    
    public void performOperation(String query) {
        Query q = session.createQuery(query);
        q.executeUpdate();
    }
}