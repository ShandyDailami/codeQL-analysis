import java.util.HashMap;

public class java_06758_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_06758_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}