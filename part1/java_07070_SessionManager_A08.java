import java.util.HashMap;

public class java_07070_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_07070_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSessionIntegrity(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityFailureException("Session integrity failure: session does not exist");
        }
    }
}