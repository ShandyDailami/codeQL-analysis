import java.util.HashMap;
import java.util.Map;

public class java_13829_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_13829_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "No session found";
        }
    }

    public String createSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionId);
            return "Session created";
        } else {
            return "Session already exists";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session deleted";
        } else {
            return "No session found";
        }
    }
}