import java.util.HashMap;
import java.util.Map;

public class java_37614_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_37614_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Invalid session";
        }
    }

    public String destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session destroyed";
        } else {
            return "Invalid session";
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("Alice");
        System.out.println("Created session: " + sessionId);
        System.out.println("Username: " + sessionManager.getUsername(sessionId));

        sessionManager.destroySession(sessionId);
        System.out.println("Destroyed session: " + sessionId);
    }
}