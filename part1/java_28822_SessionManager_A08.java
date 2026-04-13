public class java_28822_SessionManager_A08 {
    // Instance Variables
    private static SessionManager instance;
    private List<String> sessionList;

    // Private Constructor to prevent instantiation of a new SessionManager
    private java_28822_SessionManager_A08() {
        sessionList = new ArrayList<>();
    }

    // Public method to get the singleton instance of the SessionManager
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Method to open a new session
    public String openSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionList.add(sessionId);
        return sessionId;
    }

    // Method to close a session
    public boolean closeSession(String sessionId) {
        if (sessionList.remove(sessionId)) {
            return true;
        } else {
            return false;
        }
    }

    // Method to get the list of active sessions
    public List<String> getActiveSessions() {
        return sessionList;
    }
}