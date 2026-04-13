import java.util.HashMap;

public class java_35899_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_35899_SessionManager_A07() {
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

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}