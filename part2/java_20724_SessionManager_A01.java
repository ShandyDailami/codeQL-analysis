import java.util.HashMap;
import java.util.Map;

public class java_20724_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_20724_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = java.util.UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    public void validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            // Session is valid, do nothing
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("user1");
        String user = sessionManager.getUserFromSession(sessionId);
        System.out.println("User: " + user);

        sessionManager.validateSession(sessionId);
        sessionManager.deleteSession(sessionId);

        try {
            sessionManager.getUserFromSession(sessionId);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}