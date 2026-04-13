import java.util.HashMap;
import java.util.Map;

public class java_31300_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_31300_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists!";
        } else {
            sessionMap.put(sessionId, sessionId);
            return "Successfully created session!";
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Error: Session does not exist!";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Successfully deleted session!";
        } else {
            return "Error: Session does not exist!";
        }
    }

    public String integrityFailure(String sessionId) {
        // Simulate integrity failure by removing the session
        sessionMap.remove(sessionId);
        return "Integrity failure!";
    }
}