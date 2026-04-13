import java.util.HashMap;
import java.util.Map;

public class java_28482_SessionManager_A01 {

    // A simple in-memory session store.
    private Map<String, String> sessionStore;

    public java_28482_SessionManager_A01() {
        this.sessionStore = new HashMap<>();
    }

    // Implementing Access Control

    public String get(String sessionId) {
        if (!sessionStore.containsKey(sessionId)) {
            System.out.println("Session not found: " + sessionId);
            return null;
        }

        // Check if the session Id corresponds to a sensitive operation.
        // If it does, deny access.
        if (sessionId.equals("sensitiveOperationSessionId")) {
            System.out.println("Denied access to sensitive operation. Session ID: " + sessionId);
            return null;
        }

        // Session found, return the value.
        return sessionStore.get(sessionId);
    }

    public void put(String sessionId, String value) {
        sessionStore.put(sessionId, value);
    }

    public void remove(String sessionId) {
        sessionStore.remove(sessionId);
    }

    public void clear() {
        sessionStore.clear();
    }

    public boolean containsKey(String sessionId) {
        return sessionStore.containsKey(sessionId);
    }
}