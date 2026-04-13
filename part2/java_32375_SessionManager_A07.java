import java.util.HashMap;
import java.util.Map;

public class java_32375_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_32375_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = java.util.UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkAuthFailure(String sessionId) {
        if (sessionMap.get(sessionId) == null) {
            System.out.println("Auth failure for session: " + sessionId);
            // Handle auth failure here. This is a placeholder.
        } else {
            System.out.println("Successful auth for session: " + sessionId);
            // Handle successful auth here. This is a placeholder.
        }
    }
}