import java.util.HashMap;

public class java_02962_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_02962_SessionManager_A01() {
        sessionMap = new HashMap<String, String>();
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
}