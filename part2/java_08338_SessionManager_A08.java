import java.util.HashMap;

public class java_08338_SessionManager_A08 {
    private HashMap<String, String> sessionMap;
    private String sessionId;

    public java_08338_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession() {
        sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, "active");
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void deleteAllSessions() {
        sessionMap.clear();
    }
}