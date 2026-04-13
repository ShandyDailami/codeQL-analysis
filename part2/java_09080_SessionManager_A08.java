import java.util.HashMap;
import java.util.Map;

public class java_09080_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_09080_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a session
        String sessionId = "session1";
        String sessionValue = "value1";
        sessionManager.createSession(sessionId, sessionValue);

        // Retrieving a session
        String retrievedSessionValue = sessionManager.getSessionValue(sessionId);
        System.out.println("Retrieved session value: " + retrievedSessionValue);

        // Deleting a session
        sessionManager.deleteSession(sessionId);
        if (sessionManager.hasSession(sessionId)) {
            System.out.println("Session still exists after deletion");
        } else {
            System.out.println("Session deleted successfully");
        }
    }
}