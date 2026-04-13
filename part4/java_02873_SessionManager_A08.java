import java.util.HashMap;

public class java_02873_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_02873_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean checkSessionIntegrity(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}