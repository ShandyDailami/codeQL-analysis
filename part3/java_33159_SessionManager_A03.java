import java.util.HashMap;
import java.util.Map;

public class java_33159_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_33159_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return "Session created successfully";
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public String deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
        return "Session deleted successfully";
    }

    public String updateSession(String sessionId, String newSessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionId);
            return "Session updated successfully";
        } else {
            return "Session not found";
        }
    }
}