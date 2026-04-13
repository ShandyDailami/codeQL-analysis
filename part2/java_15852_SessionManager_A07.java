import java.util.HashMap;
import java.util.Map;

public class java_15852_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_15852_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
        return sessionId;
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsValue(sessionId);
    }

    public void deleteInvalidSessions() {
        sessionMap.entrySet().removeIf(entry -> !isValidSession(entry.getValue()));
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Test creating a session
        String userId = "user1";
        String sessionId = sessionManager.createSession(userId, "session1");
        System.out.println("Created session for user: " + userId);

        // Test getting a session
        String session = sessionManager.getSession(userId);
        System.out.println("Session for user: " + userId + " is: " + session);

        // Test deleting a session
        sessionManager.deleteSession(userId);
        System.out.println("Deleted session for user: " + userId);

        // Test checking if a session is valid
        boolean isValid = sessionManager.isValidSession("session1");
        System.out.println("Is valid session: " + isValid);

        // Test deleting invalid sessions
        sessionManager.deleteInvalidSessions();
    }
}