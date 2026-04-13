public class java_10386_SessionManager_A01 {
    private static int sessionCount = 0;
    private static SessionManager instance = null;
    private int sessionId;

    // Private constructor to prevent instantiation of the class
    private java_10386_SessionManager_A01() {
        sessionCount++;
        this.sessionId = sessionCount;
    }

    // Static method to get the instance of the class
    public static SessionManager getInstance() {
        if(instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Method to get the session id
    public int getSessionId() {
        return this.sessionId;
    }

    public static void main(String[] args) {
        SessionManager sm1 = SessionManager.getInstance();
        SessionManager sm2 = SessionManager.getInstance();
        System.out.println("Session ID of sm1: " + sm1.getSessionId());
        System.out.println("Session ID of sm2: " + sm2.getSessionId());
    }
}