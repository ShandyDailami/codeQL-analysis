import java.util.HashMap;

public class java_41198_SessionManager_A08 {
    private HashMap<String, Object> sessionMap;

    public java_41198_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObj) {
        sessionMap.put(sessionId, sessionObj);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSession(String sessionId, Object sessionObj) {
        sessionMap.put(sessionId, sessionObj);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}