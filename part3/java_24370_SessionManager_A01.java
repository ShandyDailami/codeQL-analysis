import java.util.HashMap;
import java.util.Map;

public class java_24370_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_24370_SessionManager_A01() {
        sessionMap = new HashMap<>();
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