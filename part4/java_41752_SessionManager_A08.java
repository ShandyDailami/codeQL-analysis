import java.util.HashMap;
import java.util.Map;

public class java_41752_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_41752_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public void updateSession(String sessionId, String newValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newValue);
        } else {
            System.out.println("No session found for update.");
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found for retrieval.");
            return null;
        }
    }
}