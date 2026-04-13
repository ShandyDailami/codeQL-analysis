import java.util.HashMap;
import java.util.Map;

public class java_36057_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_36057_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists";
        } else {
            sessionMap.put(sessionId, sessionData);
            return "Success";
        }
    }

    public String retrieveSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Error: Session does not exist";
        }
    }

    public String updateSession(String sessionId, String newSessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newSessionData);
            return "Success";
        } else {
            return "Error: Session does not exist";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Success";
        } else {
            return "Error: Session does not exist";
        }
    }
}