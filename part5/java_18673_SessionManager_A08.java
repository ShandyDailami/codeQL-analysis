import java.util.HashMap;
import java.util.Map;

public class java_18673_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_18673_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String sessionId) {
        if (sessionMap.containsKey(username)) {
            System.out.println("Error: Session already exists for user: " + username);
        } else {
            sessionMap.put(username, sessionId);
            System.out.println("Session started for user: " + username);
        }
    }

    public void endSession(String username) {
        if (sessionMap.containsKey(username)) {
            sessionMap.remove(username);
            System.out.println("Session ended for user: " + username);
        } else {
            System.out.println("Error: No session exists for user: " + username);
        }
    }

    public String getSessionId(String username) {
        if (sessionMap.containsKey(username)) {
            return sessionMap.get(username);
        } else {
            System.out.println("Error: No session exists for user: " + username);
            return null;
        }
    }
}