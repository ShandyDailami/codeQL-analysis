import java.util.HashMap;
import java.util.Map;

public class java_14756_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_14756_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, "Active");
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String checkSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Inactive";
        }
    }

    public void integrityCheck(String sessionId) {
        if (sessionMap.get(sessionId) == null) {
            throw new SecurityException("IntegrityFailure: Session " + sessionId + " is inactive");
        }
    }
}