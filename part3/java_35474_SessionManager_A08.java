import java.util.HashMap;

public class java_35474_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_35474_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, String newSessionData) {
        sessionMap.replace(sessionId, newSessionData);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}