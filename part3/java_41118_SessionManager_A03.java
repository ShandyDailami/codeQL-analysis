import java.util.HashMap;

public class java_41118_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_41118_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    public void deleteSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    public void updateSession(String sessionId, String newValue) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newValue);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }
}