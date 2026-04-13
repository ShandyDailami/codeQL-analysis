import java.util.HashMap;
import java.util.Map;

public class java_19276_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_19276_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String username) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists";
        } else {
            sessionMap.put(sessionId, username);
            return "Session created successfully";
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Error: Session does not exist";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session deleted successfully";
        } else {
            return "Error: Session does not exist";
        }
    }
}