import java.util.HashMap;

public class java_01954_SessionManager_A03 {
    private HashMap<String, Object> sessionMap;

    public java_01954_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}