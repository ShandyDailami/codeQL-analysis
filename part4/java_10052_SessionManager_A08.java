import java.util.HashMap;
import java.util.Map;

public class java_10052_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_10052_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserNameFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void clearAllSessions() {
        sessionMap.clear();
    }

    public void checkSessionIntegrity() {
        // This is a security-sensitive operation.
        // We will simulate it by throwing an UnsupportedOperationException.
        // This should only be used for demonstration purposes.
        throw new UnsupportedOperationException("Session integrity check failed.");
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        sessionManager.createSession("session1", "user1");

        // Check the session integrity
        sessionManager.checkSessionIntegrity();

        // Get the user name from the session
        String userName = sessionManager.getUserNameFromSession("session1");
        System.out.println("User name: " + userName);

        // Delete the session
        sessionManager.deleteSession("session1");

        // Clear all sessions
        sessionManager.clearAllSessions();
    }
}