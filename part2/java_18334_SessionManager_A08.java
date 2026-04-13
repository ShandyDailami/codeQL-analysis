import java.util.HashMap;
import java.util.Map;

public class java_18334_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_18334_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists";
        } else {
            sessionMap.put(sessionId, sessionId);
            return "Session created successfully";
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session exists";
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