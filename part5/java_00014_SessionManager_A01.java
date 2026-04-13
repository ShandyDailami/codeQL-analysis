import java.util.HashMap;
import java.util.Map;

public class java_00014_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_00014_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
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

        // Create a session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Get the user from the session
        String userFromSession = sessionManager.getUserIdFromSession(sessionId);
        System.out.println("User from session: " + userFromSession);

        // Delete the session
        sessionManager.deleteSession(sessionId);

        // Check if the session has been deleted
        boolean hasSession = sessionManager.hasSession(sessionId);
        System.out.println("Does the session exist? " + hasSession);
    }
}