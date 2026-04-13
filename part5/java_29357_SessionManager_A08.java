import java.util.HashMap;
import java.util.Map;

public class java_29357_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_29357_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void updateSession(String sessionId, String sessionData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionData);
        } else {
            System.out.println("Invalid session ID");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("Invalid session ID");
        }
    }
}