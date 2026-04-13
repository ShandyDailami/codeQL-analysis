import java.util.HashMap;

public class java_33512_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_33512_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists.");
        } else {
            sessionMap.put(sessionId, "Session data");
            return sessionId;
        }
    }

    public void destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new RuntimeException("Session does not exist.");
        }
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new RuntimeException("Session does not exist.");
        }
    }

    public void updateSessionData(String sessionId, String newData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.replace(sessionId, newData);
        } else {
            throw new RuntimeException("Session does not exist.");
        }
    }
}