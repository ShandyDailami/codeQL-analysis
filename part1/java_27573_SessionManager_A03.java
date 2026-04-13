import java.util.HashMap;
import java.util.Map;

public class java_27573_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_27573_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void setSessionVariable(String sessionId, String variable) {
        if (sessionId != null && variable != null) {
            sessionMap.put(sessionId, variable);
        } else {
            throw new IllegalArgumentException("Session ID and variable cannot be null");
        }
    }

    public String getSessionVariable(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Session ID not found");
        }
    }

    public boolean isValidSession(String sessionId) {
        if (sessionId == null) {
            return false;
        }
        return sessionMap.containsKey(sessionId);
    }
}