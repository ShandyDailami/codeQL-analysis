import java.util.HashMap;

public class java_26216_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_26216_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
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

    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (hasSession(sessionId)) {
            sessionMap.replace(sessionId, newSessionData);
        }
    }
}