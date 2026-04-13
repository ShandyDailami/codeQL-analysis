import java.util.HashMap;
import java.util.UUID;

public class java_18230_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_18230_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, "Active");
        return sessionId;
    }

    // Method to retrieve a session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to terminate a session
    public void terminateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, "Inactive");
        }
    }
}