import java.util.HashMap;
import java.util.Map;

public class java_04303_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_04303_SessionManager_A03() {
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateSession(String sessionId, String newData) {
        if (isValidSession(sessionId)) {
            sessionMap.replace(sessionId, newData);
        }
    }
}