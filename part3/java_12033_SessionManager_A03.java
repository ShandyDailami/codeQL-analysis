import java.util.HashMap;
import java.util.Map;

public class java_12033_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_12033_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Here are some placeholder methods to keep the code simple
    private String generateSessionId() {
        return "A03_SessionId_" + System.currentTimeMillis();
    }

    private boolean isValidSessionId(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();
        String sessionId = sessionManager.createSession("Alice");
        System.out.println("Session ID: " + sessionId);

        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username: " + username);

        sessionManager.deleteSession(sessionId);
    }
}