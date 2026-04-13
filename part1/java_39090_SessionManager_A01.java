import java.util.HashMap;

public class java_39090_SessionManager_A01 {
    private HashMap<String, Object> sessionMap;

    public java_39090_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, Object sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}