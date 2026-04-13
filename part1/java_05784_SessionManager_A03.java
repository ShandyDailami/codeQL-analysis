import java.util.HashMap;

public class java_05784_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_05784_SessionManager_A03() {
        sessionMap = new HashMap<String, String>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}