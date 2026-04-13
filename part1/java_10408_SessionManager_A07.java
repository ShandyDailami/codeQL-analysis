import java.util.HashMap;
import java.util.Map;

public class java_10408_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_10408_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists.");
        }
        sessionMap.put(sessionId, "valid");
        return sessionId;
    }

    public String validateSession(String sessionId) {
        if(!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist.");
        }
        if(!sessionMap.get(sessionId).equals("valid")) {
            throw new IllegalStateException("Session is not valid.");
        }
        return sessionId;
    }

    public void invalidateSession(String sessionId) {
        if(!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist.");
        }
        sessionMap.put(sessionId, "invalid");
    }
}