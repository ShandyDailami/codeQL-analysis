import java.util.HashMap;
import java.util.Map;

public class java_18488_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_18488_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session already exists";
        } else {
            sessionMap.put(sessionId, "Session data");
            return "Session created successfully";
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Session does not exist";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session deleted successfully";
        } else {
            return "Session does not exist";
        }
    }
}