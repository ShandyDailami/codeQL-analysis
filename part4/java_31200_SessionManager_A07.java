import java.util.HashMap;

public class java_31200_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_31200_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = sessionManager.createSession("session1");

        // Get a session
        String session = sessionManager.getSession("session1");
        System.out.println("Retrieved session: " + session);

        // Delete a session
        sessionManager.deleteSession("session1");
    }
}