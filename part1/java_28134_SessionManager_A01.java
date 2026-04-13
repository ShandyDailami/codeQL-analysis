import java.util.HashMap;
import java.util.Map;

public class java_28134_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_28134_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
        System.out.println("Session started for user: " + username);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + username);
        } else {
            System.out.println("No active session found for session id: " + sessionId);
        }
    }
}