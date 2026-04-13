import java.util.HashMap;
import java.util.Map;

public class java_41541_SessionManager_A08 {
    // This is a simple session manager. It's not secure for storing sensitive data.
    private Map<String, String> sessionMap;

    public java_41541_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void setSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }

    public void integrityCheck(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session integrity failure: session " + sessionId + " does not exist.");
        }
    }
}