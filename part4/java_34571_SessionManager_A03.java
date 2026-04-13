import java.util.HashMap;
import java.util.Map;

public class java_34571_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_34571_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = java.util.UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUserBySession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SecuritySessionManager sessionManager = new SecuritySessionManager();
        String sessionId = sessionManager.createSession("user1");
        String user = sessionManager.getUserBySession(sessionId);
        System.out.println("User: " + user + ", Session ID: " + sessionId);
        sessionManager.endSession(sessionId);
    }
}