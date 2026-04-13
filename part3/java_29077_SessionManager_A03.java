import java.util.HashMap;

public class java_29077_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_29077_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Session creation
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Session retrieval
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session deletion
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Session validation
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}