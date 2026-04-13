import java.util.HashMap;
import java.util.Map;

public class java_21349_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_21349_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
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
        String storedSessionId = sessionMap.get(userId);
        return storedSessionId != null && storedSessionId.equals(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("user1", "session1");

        if (sessionManager.isValidSession("user1", "session1")) {
            System.out.println("Session is valid: " + sessionManager.getSession("user1"));
        } else {
            System.out.println("Session is not valid");
        }

        sessionManager.deleteSession("user1");

        if (sessionManager.isValidSession("user1", "session1")) {
            System.out.println("Session is valid after deletion: " + sessionManager.getSession("user1"));
        } else {
            System.out.println("Session is not valid after deletion");
        }
    }
}