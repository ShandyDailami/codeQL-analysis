import java.util.HashMap;
import java.util.Map;

public class java_11335_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_11335_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session Already Exists!");
        } else {
            sessionMap.put(sessionId, userId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No Session Exists!");
        }
    }

    public void deleteAllSessions() {
        sessionMap.clear();
    }
}