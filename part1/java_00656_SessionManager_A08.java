import java.util.HashMap;
import java.util.Map;

public class java_00656_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_00656_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists with id: " + sessionId);
        }
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public void destroySession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No session found with id: " + sessionId);
       
        }
        sessionMap.remove(sessionId);
    }

    public String getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No session found with id: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }
}