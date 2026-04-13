import java.util.HashMap;

public class java_26556_SessionManager_A01 {

    // Using HashMap as SessionStorage
    private HashMap<String, String> sessionStorage;
    private static SecuritySessionManager sessionManager;

    private java_26556_SessionManager_A01() {
        this.sessionStorage = new HashMap<>();
    }

    public static SecuritySessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SecuritySessionManager();
        }
        return sessionManager;
    }

    // Method to create a session
    public String createSession(String sessionId) {
        sessionStorage.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        if (sessionStorage.containsKey(sessionId)) {
            return sessionId;
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionStorage.remove(sessionId);
    }
}