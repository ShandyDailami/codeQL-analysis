import java.util.HashMap;

public class java_41403_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_41403_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUserBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}