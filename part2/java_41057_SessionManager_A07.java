import java.util.HashMap;
import java.util.Map;

public class java_41057_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_41057_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isValidSession(String userId, String sessionId) {
        return sessionMap.containsKey(userId) && sessionMap.get(userId).equals(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String userId = "user1";
        String sessionId = "session1";

        // Create a session for user 'user1'
        sessionManager.createSession(userId, sessionId);

        // Check if the session is valid
        if (sessionManager.isValidSession(userId, sessionId)) {
            System.out.println("Session is valid");
        } else {
            System.out.println("Session is not valid");
        }

        // Get the session for user 'user1'
        String userSession = sessionManager.getSession(userId);
        System.out.println("User session: " + userSession);

        // Delete the session for user 'user1'
        sessionManager.deleteSession(userId);

        // Check if the session for user 'user1' has been deleted
        if (!sessionManager.isValidSession(userId, sessionId)) {
            System.out.println("Session for user " + userId + " has been deleted");
        } else {
            System.out.println("Session for user " + userId + " is still valid");
        }
    }
}