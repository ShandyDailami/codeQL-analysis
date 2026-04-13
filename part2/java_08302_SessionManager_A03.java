import java.util.HashMap;

public class java_08302_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_08302_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void invalidateAllSessions() {
        sessionMap.clear();
    }
}