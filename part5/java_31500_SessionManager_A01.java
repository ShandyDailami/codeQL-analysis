import java.util.HashMap;
import java.util.Map;

public class java_31500_SessionManager_A01 {

    private Map<String, String> sessionStore;

    public java_31500_SessionManager_A01() {
        sessionStore = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        if (sessionStore.containsKey(sessionId)) {
            System.out.println("Session ID already exists. Cannot create session.");
            return null;
        }
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessionStore.containsKey(sessionId)) {
            System.out.println("No such session exists with ID: " + sessionId);
            return;
        }
        sessionStore.remove(sessionId);
    }

    public void validateSession(String sessionId) {
        if (!sessionStore.containsKey(sessionId)) {
            System.out.println("Session ID: " + sessionId + " does not exists.");
            return;
        }
        System.out.println("Valid session ID: " + sessionId);
    }
}