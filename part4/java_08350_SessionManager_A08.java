import java.util.HashMap;

public class java_08350_SessionManager_A08 {
    // We use a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    public java_08350_SessionManager_A08() {
        // Initialize the session map
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}