import java.util.HashMap;

public class java_33155_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_33155_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }
}