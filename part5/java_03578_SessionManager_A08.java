import java.util.HashMap;
import java.util.Map;

public class java_03578_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_03578_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists!");
        }
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist!");
        }
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist!");
        }
        sessionMap.put(sessionId, newSessionData);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist!");
        }
        sessionMap.remove(sessionId);
    }
}