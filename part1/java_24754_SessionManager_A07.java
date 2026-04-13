import java.util.HashMap;
import java.util.Map;

public class java_24754_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_24754_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // Session is not valid, handle this case appropriately
            return null;
        }
    }

    public void setSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            // Session does not exist, handle this case appropriately
        }
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}