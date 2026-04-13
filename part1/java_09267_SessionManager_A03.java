import java.util.HashMap;
import java.util.Map;

public class java_09267_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_09267_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new RuntimeException("Session not found");
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}