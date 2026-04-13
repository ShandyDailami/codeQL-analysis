import java.util.HashMap;
import java.util.Map;

public class java_19362_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_19362_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkAuthFailure(String sessionId) {
        if (!isValidSession(sessionId)) {
            System.out.println("Authentication failure. Invalid session: " + sessionId);
            return;
        }

        String username = getUsername(sessionId);
        if ("admin".equals(username)) {
            System.out.println("Authentication failure. Admin login attempted");
            return;
        }

        System.out.println("Authentication successful: " + username);
    }
}