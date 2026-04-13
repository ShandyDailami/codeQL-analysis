import java.util.HashMap;

public class java_38644_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_38644_SessionManager_A08() {
        sessionMap = new HashMap<String, String>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}