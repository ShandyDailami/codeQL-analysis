import java.util.HashMap;

public class java_21219_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_21219_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, newSessionData);
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}